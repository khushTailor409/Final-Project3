package org.khush;

import java.util.List;

public class Admin extends User{

    public Admin(String name) {
        super(name);
    }
    @Override
    public int getBorrowedLimit() {
        return 10000000;
    }
}
