package org.khush;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {

    private List<User> users = new ArrayList<>();
    private List<Item> items = new ArrayList<>();

    //add

    public void addUser(User user) {
        users.add(user);
    }
    public void addItem(Item item) {
        items.add(item);
    }

    //borrow

    public void borrowItem(User user,Item item) throws Exception {

        if (user == null || item == null) {
            throw new LibraryOperationException("User or item is null");
        }

        if (!item.isAvailable()) {
            throw new Exception("Item is not available");
        }

        // student

        if (user instanceof Student) {

            if (!(item instanceof Book)) {
                throw new LibraryOperationException("student can borrow books");
            }

            long bookSBorrowed = user.getBorrowedItems()
                    .stream()
                    .filter(i -> i instanceof Book)
                    .count();

            if (bookSBorrowed >= user.getBorrowedLimit()) {
                throw new Exception("student borrow limit reached");
            }
        }

        user.borrowItem(item);
        item.setStatus(Item.Status.BORROWED);
    }

    //return

    public void returnItem(User user,Item item) throws Exception {

        if (user == null || item == null) {
            throw new Exception("User or item is null");
        }
        if (!user.getBorrowedItems().contains(item)) {
            throw new Exception("user did not borrow this item");
        }
        user.returnItem(item);
        item.setStatus(Item.Status.IN_STORE);
    }

    //search title stream

    public List<Item> searchByTitle(String title) {
        return items.stream()
                .filter(i -> i.getTitle().equalsIgnoreCase(title))
                .distinct()
                .collect(Collectors.toList());


    }

    //search author recursive

    public List<Book> searchByAuthor(String author) {

        List<Book> result = new ArrayList<>();
        searchByAuthorRecursive(author, 0, result);
        return result;
    }

    public void searchByAuthorRecursive(String author, int index, List<Book> result){

        if (index >= items.size()) {
            return;
        }

        Item current = items.get(index);

        if (current instanceof  Book) {
            Book book = (Book) current;

            if (book.getA)
        }


    }
}
