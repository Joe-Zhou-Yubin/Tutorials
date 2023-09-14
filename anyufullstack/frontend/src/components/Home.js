import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

function Home() {
  const [exams, setExams] = useState([]);

  useEffect(() => {
    // Make a GET request to fetch all exam objects from the API
    axios.get('http://localhost:8080/api/all')
      .then((response) => {
        // Set the retrieved exam data to the state
        setExams(response.data);
      })
      .catch((error) => {
        console.error('Error fetching exam data:', error);
      });
  }, []); // Empty dependency array means this effect runs once on component mount

  const handleDeleteClick = (examid) => {
    // Make a DELETE request to delete the exam by examid
    axios.delete(`http://localhost:8080/api/delete/${examid}`)
      .then((response) => {
        // If the deletion is successful, update the exams state to remove the deleted exam
        setExams((prevExams) => prevExams.filter((exam) => exam.examid !== examid));
      })
      .catch((error) => {
        console.error('Error deleting exam:', error);
      });
  };

  return (
    <div className="container">
      <h1 className="mt-5 mb-4">Home</h1>
      <Link to="/create" className="btn btn-primary mb-3">Create Exam</Link>
      <table className="table">
        <thead>
          <tr>
            <th>Exam ID</th>
            <th>Year</th>
            <th>Semester</th>
            <th>Term</th>
            <th>Course Code</th>
            <th>Weightage</th>
            <th>Location</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          {exams.map((exam) => (
            <tr key={exam.id}>
              <td>{exam.examid}</td>
              <td>{exam.year}</td>
              <td>{exam.sem}</td>
              <td>{exam.term}</td>
              <td>{exam.coursecode}</td>
              <td>{exam.weightage}</td>
              <td>{exam.location}</td>
              <td>
                <button
                  className="btn btn-danger"
                  onClick={() => handleDeleteClick(exam.examid)}
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default Home;
