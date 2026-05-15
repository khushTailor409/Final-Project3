package org.khush;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        System.out.println("=== Library Management System ===");


        Library library = new Library();

        try {
            System.out.println("\n[1] Initializing Data...");
            library.loadAll("src/main/resources/items.csv", "src/main/resources/users.csv");
            System.out.println("Data initialized successfully.");

            if (library.getUsers().isEmpty()) {
                System.out.println("Library users list is empty. Adding demo users...");
                library.addUser(new Student("00023", "Gregory", new ArrayList<>()));
                library.addUser(new Teacher("00024", "David", new ArrayList<>()));
                // Admin requires a reference to the library for reporting
                library.addUser(new Admin("System Admin", library));
            }

            User student = library.getUsers().stream()
                    .filter(u -> u instanceof Student)
                    .findFirst()
                    .orElse(null);

            Book javaBook = new Book("Java Mastery", "9780134685991", "Joshua Bloch", "Tech");
            library.addItem(javaBook);

            System.out.println("\n[2] Testing Borrowing Logic...");
            if (student != null) {
                try {
                    System.out.println("Student " + student.getName() + " is borrowing: " + javaBook.getTitle());
                    library.borrowItem(student, javaBook);
                    System.out.println("Item Status: " + javaBook.getStatus());

                    System.out.println("Attempting to borrow the same item again...");
                    library.borrowItem(student, javaBook);
                } catch (LibraryOperationException e) {
                    System.out.println("Caught Expected Error: " + e.getMessage());
                }
            }

            System.out.println("\n[3] Testing Search Logic...");
            System.out.println("Searching for 'Java' using Streams:");
            List<Item> searchResults = library.searchByTitle("Java");

            if (searchResults.isEmpty()) {
                System.out.println("No items found matching that title.");
            } else {
                searchResults.forEach(item -> System.out.println(" - Found: " + item.getTitle() + " [" + item.getClass().getSimpleName() + "]"));
            }

            System.out.println("\n[4] Generating Admin Report...");
            Admin admin = (Admin) library.getUsers().stream()
                    .filter(u -> u instanceof Admin)
                    .findFirst()
                    .orElse(null);

            if (admin != null) {
                System.out.println("--- Admin System Report ---");
                System.out.println(admin.reportAllItemsByStatusSections());
            }

            System.out.println("\n[5] Backing up data...");
            library.exportAll("src/main/resources/items.csv", "src/main/resources/users.csv");
            System.out.println("Export Complete. System shutting down.");

        } catch (Exception e) {
            System.out.println("Critical system error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
