package com.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.entity.Trainer;

public interface TrainerRepo extends JpaRepository<Trainer, Integer> {
	Trainer findByName(String name);
}
