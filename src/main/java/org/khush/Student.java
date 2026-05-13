package org.khush;

import java.util.List;

public class Student extends User{

    public Student(String name) {
        super(name);
    }
    @Override
    public int getBorrowedLimit() {
        return 5;
    }
}
