import React from "react";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useStore } from "../store.js";
import axios from "axios";
import { useRef } from "react";

function Login() {
  const navigate = useNavigate();
  const [result, setResult] = useState("");
  const updateUser = useStore((state) => state.updateUser);

  const api = "http://localhost:5050/auth/login";

  const [input, setInput] = useState({
    email: "",
    password: "",
  });

  const handleSubmit =  async (e) => {
    e.preventDefault();
    try {
      const res = await axios.post(api, input);
      if (res.data.success) {
        const userData = await axios.get(`http://localhost:5050/users/${input.email}`);
        updateUser(userData.data);
        navigate("/");
      } else {
        setResult(res.data.message);
        return;
      }
    } catch (err) {
      setResult("Password or email is incorrect.");
    }
  };

  return (
    <form
      onSubmit={handleSubmit}
      className="p-5 my-5 text-bg-light w-50 mx-auto rounded"
    >
      <h3 className="text-center">Login</h3>
      <div className="mb-3">
        <label className="form-label" htmlFor="email">
          Email:{" "}
        </label>
        <input
          className="form-control"
          type="email"
          name="email"
          id="email"
          value={input.email}
          onChange={(e) => setInput({ ...input, email: e.target.value })}
        />
      </div>

      <div className="mb-3">
        <label className="form-label" htmlFor="password">
          Password:{" "}
        </label>
        <input
          className="form-control"
          type="password"
          name="password"
          id="password"
          value={input.password}
          onChange={(e) => setInput({ ...input, password: e.target.value })}
        />
      </div>

      <input className="btn btn-primary" type="submit" value="Login" />

      <span className="text-danger">{result}</span>
    </form>
  );
}

export default Login;
