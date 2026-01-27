package com.example.libraryapi.controller;


import com.example.libraryapi.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {


    private List<Book> books = new ArrayList<>();

    @PostMapping
    public String addBook(@RequestBody Book book) {
        books.add(book);
        return "Book Added Successfully";
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable int id) {
       for(Book book : books) {
           if(book.getId() == id) {
               return ResponseEntity.ok(book);
           }
       }
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book with id " + id + " not found");
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchBook(@RequestParam int year) {
        List<Book> filteredBooks = new ArrayList<>();
        for(Book book : books) {
            if(book.getYear() == year) {
                filteredBooks.add(book);
            }
        }

        if(filteredBooks.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No book found for year " + year);
        }
        return ResponseEntity.ok(filteredBooks);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable int id) {

        for(Book book : books) {
            if(book.getId() == id) {
                books.remove(book);
                return ResponseEntity.ok("Book with id " + id + " deleted successfully");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No book found for id " + id);
    }
}
