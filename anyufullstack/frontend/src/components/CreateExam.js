import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

function CreateExam() {
  const [examData, setExamData] = useState({
    year: 0,
    sem: 0,
    term: 0,
    coursecode: '',
    weightage: '',
    location: '',
  });
  const navigate = useNavigate();

  const handleChange = (e) => {
    const { name, value } = e.target;
    setExamData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    // Make a POST request to create the exam
    axios.post('http://localhost:8080/api/create', examData)
      .then((response) => {
        // Handle success, e.g., redirect to the home page
        console.log('Exam created successfully:', response.data);

        navigate('/home');
      })
      .catch((error) => {
        console.error('Error creating exam:', error);
      });
  };

  return (
    <div className="container">
      <h1 className="mt-5 mb-4">Create Exam</h1>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label>Year:</label>
          <input
            type="number"
            className="form-control"
            name="year"
            value={examData.year}
            onChange={handleChange}
          />
        </div>
        <div className="form-group">
          <label>Semester:</label>
          <input
            type="number"
            className="form-control"
            name="sem"
            value={examData.sem}
            onChange={handleChange}
          />
        </div>
        <div className="form-group">
          <label>Term:</label>
          <input
            type="number"
            className="form-control"
            name="term"
            value={examData.term}
            onChange={handleChange}
          />
        </div>
        <div className="form-group">
          <label>Course Code:</label>
          <input
            type="text"
            className="form-control"
            name="coursecode"
            value={examData.coursecode}
            onChange={handleChange}
          />
        </div>
        <div className="form-group">
          <label>Weightage:</label>
          <input
            type="text"
            className="form-control"
            name="weightage"
            value={examData.weightage}
            onChange={handleChange}
          />
        </div>
        <div className="form-group">
          <label>Location:</label>
          <input
            type="text"
            className="form-control"
            name="location"
            value={examData.location}
            onChange={handleChange}
          />
        </div>
        <button type="submit" className="btn btn-primary">
          Create Exam
        </button>
      </form>
    </div>
  );
}

export default CreateExam;
