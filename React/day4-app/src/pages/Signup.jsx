import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import toast from "react-hot-toast";

function Signup() {

    const navigate = useNavigate();

  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [email, setEmail] = useState("");

  const handleSubmit = async(e) => {
    e.preventDefault();

    const res = await axios.post("http://192.168.1.75:5050/auth/signup", {
            username,
            password,
            email
        });

        const data = res.data;

        if(data.success){
            toast.success("User created successfull!");
            navigate("/login")
        } 
        else toast.error("User creation Failed! try again!");

    setUsername("");
    setPassword("");
    setEmail("");
  };

  return (
    <form onSubmit={handleSubmit} className="w-25 mx-auto my-5">
        <h3>Sign Up</h3>
      <div className="mb-3">
        <label for="username" className="form-label">
          Username
        </label>
        <input
          type="text"
          className="form-control"
          id="username"
          value={username}
          onChange={(e) => {
            setUsername(e.target.value);
          }}
        />
      </div>
      <div className="mb-3">
        <label for="email" className="form-label">
          Email Address
        </label>
        <input
          type="email"
          className="form-control"
          id="email"
          value={email}
          onChange={(e) => {
            setEmail(e.target.value);
          }}
        />
      </div>
      <div className="mb-3">
        <label for="password" className="form-label">
          Password
        </label>
        <input
          type="password"
          className="form-control"
          id="password"
          value={password}
          onChange={(e) => {
            setPassword(e.target.value);
          }}
        />
      </div>
      <button type="submit" className="btn btn-primary">
        Submit
      </button>
    </form>
  );
}

export default Signup;
