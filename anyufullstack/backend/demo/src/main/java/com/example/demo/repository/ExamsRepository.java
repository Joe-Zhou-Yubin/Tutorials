package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Exams;

@Repository
public interface ExamsRepository extends JpaRepository<Exams, Long> {

	Exams findByExamid(String examid);

}
