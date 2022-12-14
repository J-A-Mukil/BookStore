package com.assignment.BookStore.Service;

import com.assignment.BookStore.Model.Book;
import com.assignment.BookStore.Repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public List<Book> getBooks(){
        return this.bookRepo.findAll();
    };

    public Book getBookById(long bookId){
        Optional<Book> bookObj = this.bookRepo.findById(bookId);

        if(bookObj.isPresent()){
            return bookObj.get();
        }else{
            throw new NullPointerException();
        }
    };

    public Book addBook(Book book){
        return bookRepo.save(book);
    }

    public Book updateBook (Book book){
        Optional<Book> bookObj = this.bookRepo.findById((long) book.getBookIsbn());

        if(bookObj.isPresent()){
            Book bookUpdate = bookObj.get();
            bookUpdate.setBookIsbn(book.getBookIsbn());
            bookUpdate.setBookId(book.getBookId());
            bookUpdate.setBookName(book.getBookName());
            bookUpdate.setBookAuthor(book.getBookAuthor());
            bookUpdate.setBookCategory(book.getBookCategory());
            bookUpdate.setBookPrice(book.getBookPrice());
            return this.bookRepo.save(bookUpdate);
        }
        else {
            throw new NullPointerException();
        }
    }
}