package org.khush;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter

public class Magazine extends Item {

    private int issueNumber;
    private String publisher;

    public Magazine(String id, String title, Status status, int issueNumber, String publisher) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.issueNumber = issueNumber;
        this.publisher = publisher;
    }

    public Magazine(String title, int issueNumber, String publisher) {
        super(title);
        this.issueNumber = issueNumber;
        this.publisher = publisher;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public String getPublisher() {
        return publisher;
    }
}
