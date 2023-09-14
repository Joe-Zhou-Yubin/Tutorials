import React from 'react';
import { render } from 'react-dom';
import { BrowserRouter as Router, Routes, Route, useNavigate } from 'react-router-dom';

import CreateExam from './components/CreateExam';
import Home from './components/Home';
import 'bootstrap/dist/css/bootstrap.min.css';



function App(){
  return(
    <Router>
      <Routes>
        <Route path="/*" element={<Home/>}/>
        <Route path="/create" element={<CreateExam/>}/>
      </Routes>
    </Router>
  );
}

render(<App />, document.getElementById('root'));