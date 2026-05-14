package org.khush;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)

public class Admin extends User implements Reportable {

    private Library library;


    public Admin(String name, Library library) {
        super(name);
        this.library = library;
    }

    @Override
    public int getBorrowedLimit() {
        return 10000000;
    }

    @Override
    public String reportItemsByStatus(Item.Status status) {

        List<Item> items = library.getItems();

        String report = status + "\n";

        for (Item item : items) {
            if (item.getStatus() == status) {
                report = report + item + "\n";
            }
        }
        return report;
    }

    @Override
    public String reportAllUsers() {
        List<User> users = library.getUsers();
        String report = "USERS\n";
        for (User user: users) {
            report = report + user + "\n";
        }
        return report;
    }

    @Override
    public String reportAllItemsByStatusSections() {
        String report = "";
        for (Item.Status status: Item.Status.values()) {
            report = report + reportItemsByStatus(status) + "\n";
        }
        return report;
    }
}
