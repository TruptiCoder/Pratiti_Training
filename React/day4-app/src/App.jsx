import Navbar from './components/Navbar';
import {BrowserRouter, MemoryRouter, Route, Routes} from 'react-router-dom';
import Index from './pages/Index';
import Home from './pages/Home';
import Login from './pages/Login';
import Signup from './pages/Signup';
import { Toaster } from 'react-hot-toast'
import { useState } from 'react';

function App() {
  const [isLogedIn, setIsLogedIn] = useState(false);
  const [currUser, setCurrUser] = useState(null);

  return (
    <>
      <MemoryRouter>
        <Navbar isLogedIn={isLogedIn} currUser={currUser} setCurrUser={setCurrUser} setIsLogedIn={setIsLogedIn} />
        <Toaster />
        <Routes>
          <Route path='/' element={<Index />} />
          <Route path='/home' element={<Home setIsLogedIn={setIsLogedIn} currUser={currUser} />} />
          <Route path='/login' element={<Login setCurrUser={setCurrUser} />} />
          <Route path='/signup' element={<Signup />} />
        </Routes>
      
      </MemoryRouter>
    </>
  )
}

export default App