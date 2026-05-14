package org.khush;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter

public class Book extends Item{

    private String isbn;
    private String author;
    private String genre;

    public Book(String title, String isbn, String author, String genre) {
        super(title);
        this.isbn = isbn;
        this.author = author;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }
}
