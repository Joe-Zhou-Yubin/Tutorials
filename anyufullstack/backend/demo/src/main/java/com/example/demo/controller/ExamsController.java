package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Exams;
import com.example.demo.repository.ExamsRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ExamsController {
	
	@Autowired
    private ExamsRepository examsRepository;
	
	@PostMapping("/create")
    public ResponseEntity<Exams> createExams(@RequestBody Exams exams) {
        try {
            // Generate the examid before saving the object
            exams.setExamid(exams.generateExamId());

            // Save the exams object to the database
            Exams savedExams = examsRepository.save(exams);

            return new ResponseEntity<>(savedExams, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@DeleteMapping("/delete/{examid}")
    public ResponseEntity<HttpStatus> deleteExamsByExamid(@PathVariable("examid") String examid) {
        try {
            // Find the exam by examid
            Exams exam = examsRepository.findByExamid(examid);

            if (exam == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            // Delete the exam from the database
            examsRepository.delete(exam);
            
            System.out.println("Exam deleted");

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@GetMapping("/all")
    public ResponseEntity<List<Exams>> getAllExams() {
        try {
            List<Exams> examsList = examsRepository.findAll();
            if (examsList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(examsList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
}
