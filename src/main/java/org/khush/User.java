package org.khush;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString

public abstract class User {

    protected String id;
    protected String name;
    protected List<Item> borrowedItems;

    public static int nextId = 0;

    public User(String name) {
        this.id = String.format("%04d", nextId++);
        this.name = name;
        this.borrowedItems = new ArrayList<>();
    }

    public abstract int getBorrowedLimit();

    public void borrowItem(Item item) throws Exception {
        if (borrowedItems.size() >= getBorrowedLimit()) {
            throw new Exception("Borrow limit reached");
        }
        borrowedItems.add(item);
    }
    public void returnItem(Item item) {
        borrowedItems.remove(item);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Item> getBorrowedItems() {
        return borrowedItems;
    }

    public static int getNextId() {
        return nextId;
    }
}
