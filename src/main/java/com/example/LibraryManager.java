package com.example;

import java.util.List;
import java.util.Scanner;

public class LibraryManager {
    private static Scanner scanner = new Scanner(System.in);
    private static BookDAO bookDAO = new BookDAO();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== Library Manager =====");
            System.out.println("1. Create Book");
            System.out.println("2. Read All Books");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> createBook();
                case 2 -> readBooks();
                case 3 -> updateBook();
                case 4 -> deleteBook();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }

    private static void createBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        Book book = new Book(0, title, author);
        bookDAO.create(book);
    }

    private static void readBooks() {
        List<Book> books = bookDAO.read();
        if (books.isEmpty()) {
            System.out.println("No books found.");
        } else {
            books.forEach(System.out::println);
        }
    }

    private static void updateBook() {
        System.out.print("Enter book ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter new title: ");
        String title = scanner.nextLine();

        System.out.print("Enter new author: ");
        String author = scanner.nextLine();

        Book book = new Book(id, title, author);
        bookDAO.update(book);
    }

    private static void deleteBook() {
        System.out.print("Enter book ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        bookDAO.delete(id);
    }
}
