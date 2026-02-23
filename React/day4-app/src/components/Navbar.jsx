import React from "react";
import toast from "react-hot-toast";
import { Link, Outlet, useNavigate } from "react-router-dom";

function Navbar({ isLogedIn, setIsLogedIn, currUser, setCurrUser }) {

  const logout = () => {
    setIsLogedIn(false);
    setCurrUser(null);
    toast.success("Logged Out successfully!");
  };

  return (
    <nav className="navbar navbar-expand-lg bg-body-tertiary">
      <div className="container-fluid">
        <Link className="navbar-brand" to="/">
          MyApp
        </Link>
        <button
          className="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarText"
          aria-controls="navbarText"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>

        <div>
          {!isLogedIn && (
            <div>
              <Link to="/login" className="btn btn-outline-primary mx-2 px-3">
                Login
              </Link>
              <Link to="/signup" className="btn btn-outline-primary mx-2 px-3">
                Sign Up
              </Link>
            </div>
          )}

          {currUser && isLogedIn && (
            <div>
                <span className="mx-5">Hello, {currUser.toUpperCase()}</span>
                <Link
                to="/login"
                onClick={logout}
                className="btn btn-outline-danger mx-2 px-3"
                >
                Logout
                </Link>
            </div>
          )}
        </div>
      </div>

      <Outlet />
    </nav>
  );
}

export default Navbar;
