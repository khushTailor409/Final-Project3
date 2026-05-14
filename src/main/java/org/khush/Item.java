package org.khush;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString

public abstract class Item {
    protected String id;
    protected String title;
    protected Status status; // use enum

    public static int nextId = 0;

    public Item( String title) {
        this.id = String.format("%04d",nextId++);
        this.title = title;
        this.status = Status.IN_STORE;
    }
    public boolean isAvailable() {
        return status == Status.IN_STORE;
    }
    public void setStatus(Status status){
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public enum Status {
        IN_STORE,BORROWED,LOST
    }
}
