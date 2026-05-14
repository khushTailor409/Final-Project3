package org.khush;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter

public class DVD extends Item {

    private String director;
    private int duration;

    public DVD(String id, String title, Status status, String director, int duration) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.director = director;
        this.duration = duration;
    }

    public DVD(String title, String director, int duration) {
        super(title);
        this.director = director;
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    public int getDuration() {
        return duration;
    }
}
