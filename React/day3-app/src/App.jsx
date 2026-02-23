import React from "react";
import Login from "./components/Login";
import { BrowserRouter, Link, Route, Routes } from "react-router-dom";
import Home from "./components/Home";
import About from "./components/About";
import Help from "./components/Help";
import Permanant from "./components/Permanant";
import Current from "./components/Current";

function App() {
    return (
        <BrowserRouter>
            {/* <Login /> */}

            <nav className="navbar px-5 py-2 text-bg-dark">
              <Link to="/">Home</Link>
              <Link to="/about">About</Link>
              <Link to="/Help">Help</Link>
            </nav>

            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/about" element={<About />}>
                  <Route path="permanant" element={<Permanant />} />
                  <Route path="current" element={<Current />} />
                </Route>
                <Route path="/help" element={<Help />} />
                <Route path="*" element={<h1 className="container p-5">404 Page Not Found!</h1>} />
            </Routes>
        </BrowserRouter>
    );
}

export default App;
