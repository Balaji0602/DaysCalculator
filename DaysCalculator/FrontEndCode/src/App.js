// import logo from './logo.svg';
import './App.css';
import React from 'react';
import {BrowserRouter as Router,Routes,Route} from 'react-router-dom';
import HomeComponent from './HomeComponent';
import IndexComponent from './Component/IndexComponent';
import GetDaysCompo from './Component/GetDaysCompo';

function App() {
  return (
    <div className="main">
      <Router>
        <Routes>
          <Route path='/' element = {<IndexComponent/>} />
          <Route path="/Home" element = {<HomeComponent/>}/>
          <Route path='/DaysCalculate' element = {<GetDaysCompo/>}/>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
