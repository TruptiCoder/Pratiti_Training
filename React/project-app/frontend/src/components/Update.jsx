import React, { useState } from "react";
import { useStore } from "../store.js";
import axios from "axios";
import { use } from "react";
import { useNavigate } from "react-router-dom";

function Update() {
  const user = useStore((state) => state.user);
  const [newUser, setNewUser] = useState(user);
  const api = "http://localhost:5050/users/";
  const navigate = useNavigate();

  const handleChange = (e) => {
    if (e.target.name === "image") {
      setNewUser({
        ...newUser,
        image: e.target.files[0],
      });
    } else {
      setNewUser({
        ...newUser,
        [e.target.name]: e.target.value,
      });
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const formData = new FormData();
    formData.append("fullname", newUser.fullname);
    formData.append("city", newUser.city);
    formData.append("mobile", newUser.mobile);
    formData.append("age", newUser.age);
    formData.append("designation", newUser.designation);

    if (newUser.image) {
      formData.append("image", newUser.image);
    }

    const res = await axios.put(api + user.id, formData, {
      headers: {
        "Content-Type": "multipart/form-data",
      },
    });

    if (res.data.success) {
      alert("User details updated successfully");
    } else {
      alert("Failed to update user details");
    }
    navigate("/");
  };

  return (
    <form
      onSubmit={handleSubmit}
      className="form p-5 my-2 text-bg-light w-50 mx-auto rounded"
    >
      <label className="form-label" htmlFor="fullname">
        Full Name:{" "}
      </label>
      <input
        className="form-control mb-2"
        type="text"
        name="fullname"
        value={newUser.fullname || ""}
        onChange={handleChange}
      />

      <label className="form-label" htmlFor="city">
        City:{" "}
      </label>
      <input
        className="form-control mb-2"
        type="text"
        name="city"
        value={newUser.city || ""}
        onChange={handleChange}
      />

      <label className="form-label" htmlFor="mobile">
        Mobile:{" "}
      </label>
      <input
        className="form-control mb-2"
        type="number"
        name="mobile"
        value={newUser.mobile || ""}
        onChange={handleChange}
      />

      <label className="form-label" htmlFor="age">
        Age:{" "}
      </label>
      <input
        className="form-control mb-2"
        type="number"
        name="age"
        value={newUser.age || ""}
        onChange={handleChange}
      />

      <label className="form-label" htmlFor="designation">
        Designation:{" "}
      </label>
      <input
        className="form-control mb-2"
        type="text"
        name="designation"
        value={newUser.designation || ""}
        onChange={handleChange}
      />

      <label className="form-label" htmlFor="image">
        Profile Image:{" "}
      </label>
      <input
        className="form-control mb-2"
        type="file"
        name="image"
        onChange={handleChange}
      />

      <button className="btn btn-danger" type="submit">
        Update
      </button>
    </form>
  );
}

export default Update;
