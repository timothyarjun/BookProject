package com.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.entity.Teacher;
@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long> {

}
