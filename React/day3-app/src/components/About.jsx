import React from "react";
import { Link, Outlet } from "react-router-dom";

function About() {
    return(<div className="container p-5">About
        <Link className="px-5" to="/about/permanant">Permanant Address</Link>
        <Link className="px-5" to="/about/current">Current Address</Link>
        <Outlet />
    </div>);
}

export default About;
