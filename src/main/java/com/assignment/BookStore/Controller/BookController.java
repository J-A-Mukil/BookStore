package com.assignment.BookStore.Controller;

import com.assignment.BookStore.Model.Book;
import com.assignment.BookStore.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    private ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok().body(this.bookService.getBooks());
    }

    @GetMapping("/books/{bookIsbn}")
    private Book getBookById(@PathVariable long bookIsbn){
        return this.bookService.getBookById(bookIsbn);
    }

    @PostMapping("/books")
    private ResponseEntity<Book> addBook(@RequestBody Book book){
        return ResponseEntity.ok().body(this.bookService.addBook(book));
    }

    @PutMapping("/books/{bookIsbn}")
    private ResponseEntity<Book> updateBook(@PathVariable long bookIsbn, @RequestBody Book book){
        book.setBookIsbn(bookIsbn);
        return ResponseEntity.ok().body(this.bookService.updateBook(book));
    }
}