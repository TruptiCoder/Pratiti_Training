import React from "react";
import { useNavigate } from "react-router-dom";
import { useStore } from "../store.js";
import axios from "axios";

function Info({ employee }) {
  const navigate = useNavigate();
  const user = useStore((state) => state.user);
  const api = "http://localhost:5050/users/";
  const removeEmployee = useStore((state) => state.removeEmployee);

  const handleDelete = async () => {
    const res = await axios.delete(api + employee.id);

    if (res.data.success) {
      alert("User deleted successfully");
      removeEmployee(employee.id); 
      navigate("/");
    } else {
      alert("Failed to delete user");
    }
  };

  const handleUpdate = () => {
    navigate("/update");
  };

  return (
    <div>
      <h5>{employee.fullname}</h5>
      <p>Company: Pratiti Technologies</p>
      <p>Email: {employee.email}</p>
      <p>Mobile No. {employee.mobile}</p>
      <p>City: {employee.city}</p>
      <p>Age: {employee.age}</p>
      <p>Designation: {employee.designation}</p>

      {user.role == "admin" ? (
        <button className="btn btn-outline-danger" onClick={handleDelete}>
          Delete
        </button>
      ) : (
        <button className="btn btn-outline-danger" onClick={handleUpdate}>
          Update
        </button>
      )}
    </div>
  );
}

export default Info;
