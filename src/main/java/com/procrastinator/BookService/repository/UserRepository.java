package com.procrastinator.BookService.repository;

import com.procrastinator.BookService.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
