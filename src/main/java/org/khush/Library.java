package org.khush;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<User> users = new ArrayList<>();
    private List<Item> items = new ArrayList<>();

    //add

    public void addUser(User user) {
        users.add(user);
    }
    public void addItem(Item item) {
        items.add(item);
    }

    //borrow

    public void borrowItem(User user,Item item) throws Exception {

        if (!item.isAvailable()) {
            throw new Exception("Item is not available");
        }

        if (user.getBorrowedLimit().size() >= user.getBorrowedLimit()) {
            throw new Exception("user reached borrow limit");

        }

    }


}
