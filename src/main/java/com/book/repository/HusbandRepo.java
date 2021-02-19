package com.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.entity.Husband;
@Repository
public interface HusbandRepo extends JpaRepository<Husband, Long> {	
	
}
