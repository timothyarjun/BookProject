package com.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.entity.Address;
@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {

}
