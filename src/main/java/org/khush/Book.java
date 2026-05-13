package org.khush;

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
}
