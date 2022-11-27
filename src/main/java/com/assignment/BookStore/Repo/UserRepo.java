package com.assignment.BookStore.Repo;

import com.assignment.BookStore.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}