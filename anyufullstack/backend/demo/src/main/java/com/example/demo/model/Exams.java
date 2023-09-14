package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "exams")
public class Exams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double year;
    private double sem;
    private double term;
    private String coursecode;
    private String weightage;
    private String location;
    private String examid;

    public Exams() {
        this.examid = generateExamId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getYear() {
        return year;
    }

    public void setYear(double year) {
        this.year = year;
    }

    public double getSem() {
        return sem;
    }

    public void setSem(double sem) {
        this.sem = sem;
    }

    public double getTerm() {
        return term;
    }

    public void setTerm(double term) {
        this.term = term;
    }

    public String getCoursecode() {
        return coursecode;
    }

    public void setCoursecode(String coursecode) {
        this.coursecode = coursecode;
    }

    public String getWeightage() {
        return weightage;
    }

    public void setWeightage(String weightage) {
        this.weightage = weightage;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getExamid() {
        return examid;
    }

    public void setExamid(String examid) {
        this.examid = examid;
    }

    // Generate examid by concatenating year, sem, term, and coursecode
    public String generateExamId() {
        return String.format("%.0f%.0f%.0f%s", year, sem, term, coursecode);
    }

    @Override
    public String toString() {
        return "Exams [id=" + id + ", year=" + year + ", sem=" + sem + ", term=" + term + ", coursecode=" + coursecode
                + ", weightage=" + weightage + ", location=" + location + ", examid=" + examid + "]";
    }
}
