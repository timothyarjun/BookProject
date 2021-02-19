package com.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.entity.Wife;

@Repository
public interface WifeRepo extends JpaRepository<Wife, Long> {	

}
