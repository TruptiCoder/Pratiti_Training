import { useEffect } from "react";
import { useStore } from "../store.js";
import Card from "./Card";
import { useState } from "react";
import axios from "axios";

function Home() {
  const user = useStore((state) => state.user);
  const employees = useStore((state) => state.employees);
  const setEmployees = useStore((state) => state.setEmployees);
  const api = "http://localhost:5050/users";

  useEffect(() => {
    const fetchEmployees = async () => {
      try {
        const response = await axios.get(api);
        setEmployees(response.data);
      } catch (error) {
        console.error("Error fetching employees:", error);
      }
    };

    if (user) {
      fetchEmployees();
    }
  }, [user]);

  return (
    <div className="p-5">
      {!user && (
        <div className="d-flex align-items-center justify-content-center flex-column">
          <h1 className="text-center">
            Welcome to the Employee Management System
          </h1>
          <p>Please Login</p>
        </div>
      )}

      {user && (
        <div>
          <h3>Employees</h3>
          <div className="d-flex flex-wrap">
            {employees.map((ele, idx) => (
              ele.role != "admin" && <Card key={idx} user={user} employee={ele} />
            ))}
          </div>
        </div>
      )}
    </div>
  );
}

export default Home;
