package com.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.entity.Trainee;

public interface TraineeRepo extends JpaRepository<Trainee, Integer> {

}
