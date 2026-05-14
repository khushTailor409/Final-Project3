package org.khush;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<User> users;
    private List<Item> items;

    public Library(List<User> users, List<Item> items) {
        this.users = new ArrayList<>();
        this.items = new ArrayList<>();
    }
}
}
