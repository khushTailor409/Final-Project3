package org.khush;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)

public class Admin extends User implements Reportable {

    public Admin(String name) {
        super(name);
    }
    @Override
    public int getBorrowedLimit() {
        return 10000000;
    }

    @Override
    public String reportItemsByStatus(Item.Status status) {

        List<Item> items = Library.getItems();

        String report = status + "\n";

        for (Item item : items) {
            if (item.getStatus() == status){
                report = report + item + "\n";
            }
        }
        return report;
}
