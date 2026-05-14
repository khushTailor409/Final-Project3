package org.khush;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)

public class Teacher extends User{

    public Teacher(String name) {
        super(name);
    }

    public Teacher(String id, String name, List<Item> borrowedItems) {
        this.id = id;
        this.name = name;
        this.borrowedItems = borrowedItems;
    }
    @Override
    public int getBorrowedLimit() {
        return 10;
    }
}
