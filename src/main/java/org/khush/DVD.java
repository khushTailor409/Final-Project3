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

    public DVD(String title, String director, int duration) {
        super(title);
        this.director = director;
        this.duration = duration;
    }
}
