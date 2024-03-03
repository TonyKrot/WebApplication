package Bookmanager.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Bookmanager.*;
import Bookmanager.dto.BookCreateOrUpdateRequest;
import Bookmanager.dto.BookIdResponse;
import Bookmanager.dto.BookListResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class BookController {

    @PostMapping("/book")
    public BookIdResponse createBook(@RequestBody BookCreateOrUpdateRequest request) {
        Book book = new Book(request.getName());
        book.setYear(request.getYear()); // Установка значения поля year
        int id = BookStorage.addBook(book);
        return new BookIdResponse(id);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Map<String, Object>> getBook(@PathVariable Integer id) {
        Optional<Book> bookOptional = BookStorage.getBook(id);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            Map<String, Object> response = new HashMap<>();
            response.put("name", book.getName());
            response.put("year", book.getYear());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/book")
    public BookListResponse getBookList() {
        return new BookListResponse(BookStorage.getBooklist());
    }

    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable Integer id) {
        BookStorage.deleteBook(id);
    }

    @PutMapping("/book/{id}")
    public void updateBook(@PathVariable Integer id, @RequestBody BookCreateOrUpdateRequest request) {
        Book book = new Book(request.getName());
        book.setYear(request.getYear()); // Установка значения поля year
        BookStorage.updateBook(id, book);
    }
}
