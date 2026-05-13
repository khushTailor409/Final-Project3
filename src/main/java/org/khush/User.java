package org.khush;

import java.util.List;

public abstract class User {
    protected String id;
    protected String name;
    protected List<> borrowedItems;

    public static int nextId = 0;

    public User(String name, List borrowedItems) {
        this.id = id;
        this.name = name;
        this.borrowedItems = borrowedItems;
    }
}
