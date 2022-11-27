package com.assignment.BookStore.Repo;

import com.assignment.BookStore.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book,Long> {
}
