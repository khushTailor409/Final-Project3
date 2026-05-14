package org.khush;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Student extends User{

    public Student(String name) {
        super(name);
    }
    @Override
    public int getBorrowedLimit() {
        return 5;
    }
}
