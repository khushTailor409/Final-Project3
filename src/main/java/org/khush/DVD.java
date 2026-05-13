package org.khush;

public class DVD extends Item {

    private String director;
    private int duration;

    public DVD(String title, String director, int duration) {
        super(title);
        this.director = director;
        this.duration = duration;
    }
}
