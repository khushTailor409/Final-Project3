package org.khush;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Student extends User{

    public Student(String id, String name, List<Item> borrowedItems) {
        this.id = id;
        this.name = name;
        this.borrowedItems = borrowedItems;
    }

    public Student(String name) {
        super(name);
    }


    @Override
    public int getBorrowedLimit() {
        return 5;
    }
}
