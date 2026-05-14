package org.khush;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)

public class Admin extends User {

    public Admin(String name) {
        super(name);
    }
    @Override
    public int getBorrowedLimit() {
        return 10000000;
    }
}
