import logo from './logo.svg';
import './App.css';
import Main from './components/dashboard/Main';

import Router from './pages/Router';
import Footer from './components/Footer';
import { BrowserRouter } from 'react-router-dom';


function App() {
  return (
    <div className="container">
      <BrowserRouter>
        <Router></Router>
      </BrowserRouter>
      <Footer></Footer>
    </div>
  );
}

export default App;
