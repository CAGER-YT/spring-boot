package com.studentDetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentDetails.entity.Student;

public interface studentRepository extends JpaRepository<Student, Integer>{

}
