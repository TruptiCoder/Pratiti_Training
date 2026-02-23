import React, { useState } from "react";
import axios from 'axios';
import toast from "react-hot-toast";
import { useNavigate } from "react-router-dom";

function Login({setCurrUser}) {

    const navigate = useNavigate();

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    const handleSubmit = async (e) => {
        e.preventDefault();

        const res = await axios.post("http://192.168.1.75:5050/auth/login", {
            username,
            password
        });

        const data = res.data;

        if(data.success){
            setCurrUser(username);
            toast.success("Login successfull!");
            navigate("/home")
        } 
        else toast.error("Login Failed! try again!");

        setUsername("");
        setPassword("");
    }

  return (
    <form onSubmit={handleSubmit} className="w-25 mx-auto my-5">
        <h3>Login</h3>
      <div class="mb-3">
        <label for="username" class="form-label">
          Username
        </label>
        <input
          type="text"
          class="form-control"
          id="username"
          value={username}
          onChange={(e) => {setUsername(e.target.value)}}
        />
      </div>
      <div class="mb-3">
        <label for="password" class="form-label">
          Password
        </label>
        <input
          type="password"
          class="form-control"
          id="password"
          value={password}
          onChange={(e) => {setPassword(e.target.value)}}
        />
      </div>
      <button type="submit" class="btn btn-primary">
        Submit
      </button>
    </form>
  );
}

export default Login;
