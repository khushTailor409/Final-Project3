package org.khush;

public abstract class Item {
    protected String id;
    protected String title;
    protected Status status; // use enum

    public static int nextId = 0;

    public Item(String id, String title, Status status) {
        this.id = String.format("%04d",nextId++);
        this.title = title;
        this.status = Status.IN_STORE;
    }
    public boolean isAvailable() {
        return status == Status.IN_STORE;
    }
    public static enum Status {
        IN_STORE,BORROWED,LOST
    }
}
