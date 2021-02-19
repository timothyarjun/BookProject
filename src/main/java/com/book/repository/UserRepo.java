package com.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.entity.User;
@Repository
public interface UserRepo extends JpaRepository<User, Long> {


}
