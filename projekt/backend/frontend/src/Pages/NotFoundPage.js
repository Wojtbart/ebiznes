import React from 'react';
import { Link } from 'react-router-dom';
import '../App.css';

const NotFoundPage = () => (
    <div id="notfound">
      <div className="notfound">
        <div className="notfound-404">
          <h3>Oops! Strona nie została znaleziona</h3>
          <h1>
            <span>4</span>
            <span>0</span>
            <span>4</span>
          </h1>
          
        </div>
        <h3 className="under404"><Link to="/"> Strona Główna</Link></h3>
      </div>
      
    </div>
);

export default NotFoundPage;