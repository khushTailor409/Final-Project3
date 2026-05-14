package org.khush;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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

    public void borrowItem(User user, Item item) throws LibraryOperationException {

        if (user == null || item == null) {
            throw new LibraryOperationException("User or item is null");
        }

        if (!item.isAvailable()) {
            throw new LibraryOperationException("Item is not available");
        }
        if (user instanceof Admin) {
            throw new LibraryOperationException("Admin cannot borrow item");
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
                throw new LibraryOperationException("student borrow limit reached");
            }
        }

        //teacher

        if (user instanceof Teacher) {
            if (user.getBorrowedItems().size() >= user.getBorrowedLimit()) {
                throw new LibraryOperationException("Teacher borrow limit reached");
            }
        }
        user.getBorrowedItems().add(item);
        item.setStatus(Item.Status.BORROWED);


    }

    //return

    public void returnItem(User user, Item item) throws LibraryOperationException {

        if (user == null || item == null) {
            throw new LibraryOperationException("User or item is null");
        }
        if (!user.getBorrowedItems().contains(item)) {
            throw new LibraryOperationException("user did not borrow this item");
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

    public void searchByAuthorRecursive(String author, int index, List<Book> result) {

        if (index >= items.size()) {
            return;
        }

        Item current = items.get(index);

        if (current instanceof Book) {
            Book book = (Book) current;

            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        searchByAuthorRecursive(author, index + 1, result);

    }

    public List<User> getUsers() {
        return users;
    }

    public List<Item> getItems() {
        return items;
    }

    // CSV

    public void saveToCsv() throws Exception {

    }

    public void exportItems(String path) {

        File file = new File(path);

        try (FileWriter fw = new FileWriter(file)) {

            for (Item item : items) {

                if (item instanceof Book) {
                    Book b = (Book) item;

                    fw.write("BOOK," +
                            b.getId() + "," +
                            b.getTitle() + "," +
                            b.getStatus() + "," +
                            b.getAuthor() + "," +
                            b.getIsbn() + "," +
                            b.getGenre() + "\n");

                } else if (item instanceof DVD) {
                    DVD d = (DVD) item;

                    fw.write("DVD," +
                            d.getId() + "," +
                            d.getTitle() + "," +
                            d.getStatus() + "," +
                            d.getDirector() + "," +
                            d.getDuration() + "\n");
                } else if (item instanceof Magazine) {
                    Magazine m = (Magazine) item;

                    fw.write("MAGAZINE," +
                            m.getId() + "," +
                            m.getTitle() + "," +
                            m.getStatus() + "," +
                            m.getIssueNumber() + "," +
                            m.getPublisher() + "\n");
                }
            }

        } catch (IOException e) {
            throw new RuntimeException("EXPORT ITEMS FAILED", e);
        }
    }

    public void exportUsers(String path) {
        File file = new File(path);

        try (FileWriter fw = new FileWriter(file)) {

            for (User user : users) {

                fw.write(user.getClass().getSimpleName() + ",");
                fw.write(user.getId() + ",");
                fw.write(user.getName());

                for (Item item : user.getBorrowedItems()) {
                    fw.write("," + item.getId());
                }

                fw.write("\n");
            }

        } catch (IOException e) {
            throw new RuntimeException("Failed to export users");
        }
    }

    public void exportAll(String itemsPath, String usersPath) {
        exportItems(itemsPath);
        exportUsers(usersPath);

    }

    public void loadItems(String path) {

        File file = new File(path);

        try (Scanner sc = new Scanner(file)) {

            while (sc.hasNextLine()) {

                String[] data = sc.nextLine().split(",");

                String type = data[0];
                String id = data[1];
                String title = data[2];

                Item.Status status = Item.Status.valueOf(data[3]);

                Item item = null;

                if (type.equals("BOOK")) {

                    String author = data[4];
                    String isbn = data[5];
                    String genre = data[6];

                    item = new Book(id, title, status, author, isbn, genre);
                } else if (type.equals("DVD")) {

                    String director = data[4];
                    int duration = Integer.parseInt(data[5]);

                    item = new DVD(id, title, status, director, duration);
                } else if (type.equals("MAGAZINE")) {

                    int issueNumber = Integer.parseInt(data[4]);
                    String publisher = data[5];

                    item = new Magazine(id, title, status, issueNumber, publisher);
                }

                if (item != null) {
                    items.add(item);
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("LOAD ITEMS FAILED", e);
        }
    }
}
