package com.example;
import java.util.List;

public class TestLibraryManager {
    public static void main(String[] args) {
        BookDAO dao = new BookDAO();

        // Test Create
        Book b1 = new Book(0, "Test Driven Development", "Kent Beck");
        dao.create(b1);

        // Test Read
        List<Book> books = dao.read();
        System.out.println("Books in DB: " + books.size());

        // Test Update
        if (!books.isEmpty()) {
            Book first = books.get(0);
            first.setTitle("Updated Title");
            dao.update(first);
        }

        // Test Delete
        if (!books.isEmpty()) {
            dao.delete(books.get(0).getId());
        }
    }
}
