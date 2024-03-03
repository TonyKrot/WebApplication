package Bookmanager;

import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

public class BookStorage {

    private static int id = 0;
    private static HashMap<Integer, Book> boooklist = new HashMap<>();

    public static int addBook(Book book) {
        int newId = ++id;
        book.setId(newId);
        boooklist.put(newId, book);
        return newId;
    }

    public static Collection<Book> getBooklist() {
        return boooklist.values();
    }

    public static void deleteBook(int id) {
        boooklist.remove(id);
    }

    public static void updateBook(int id, Book book) {
        book.setId(id);
        boooklist.put(id, book);
    }

    public static Optional<Book> getBook(int id) {
        return boooklist.containsKey(id) ?
            Optional.of(boooklist.get(id)) :
            Optional.empty();
    }
}
