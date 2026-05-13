package org.khush;

public class Magazine extends Item{

    private int issueNumber;
    private  String publisher;

    public Magazine(String title, int issueNumber, String publisher) {
        super(title);
        this.issueNumber = issueNumber;
        this.publisher = publisher;
    }
}
