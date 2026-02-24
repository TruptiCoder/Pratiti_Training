import { connectDB, connection } from "../util/db.js";

connectDB();

const createUsersTable = async () => {
  const query = `
    CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    fullname VARCHAR(100) NOT NULL,
    mobile BIGINT NOT NULL,
    city VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    age INT,
    designation VARCHAR(100),
    image LONGBLOB,
    role VARCHAR(50) DEFAULT 'user'
    );`;
  try {
    await connection.query(query);
    console.log("Users table ready");
  } catch (err) {
    console.error("Error creating users table:", err);
  }
};

const addUser = async (user) => {
  const query = `
    INSERT INTO employees 
    (fullname, mobile, city, email, password, age, designation, image, role)
    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
  `;

  try {
    await connection.query(query, [
      user.fullname,
      user.mobile,
      user.city,
      user.email,
      user.password,
      user.age,
      user.designation,
      user.image,
      user.role || "user",
    ]);

    return { success: true, message: "User inserted successfully" };
  } catch (err) {
    return { success: false, message: "Error inserting user", error: err };
  }
};

const getAllUsers = async () => {
  const query = "SELECT * FROM employees";
  const [rows] = await connection.query(query);
  const users = rows.map((user) => {
    if (user.image) {
      user.image = `data:image/jpeg;base64,${user.image.toString("base64")}`;
    }
    return user;
  });
  return users;
};

const getUser = async (email) => {
  const query = "SELECT * FROM employees WHERE email = ?";
  const [rows] = await connection.query(query, [email]);
  return rows[0];
};

const deleteUser = async (id) => {
  const query = "DELETE FROM employees WHERE id = ?";
  const [result] = await connection.query(query, [id]);
  return result.affectedRows > 0;
};

const updateUser = async (id, user) => {
  const query = `
    UPDATE employees 
    SET 
      fullname = ?, 
      mobile = ?, 
      city = ?, 
      age = ?, 
      designation = ?, 
      image = ?
    WHERE id = ?
  `;

  try {
    const [result] = await connection.query(query, [
      user.fullname,
      user.mobile,
      user.city,
      user.age,
      user.designation,
      user.image,
      id,
    ]);

    return result.affectedRows > 0;
  } catch (err) {
    console.error("Error updating user:", err);
    return false;
  }
};

export {
  addUser,
  getAllUsers,
  getUser,
  deleteUser,
  createUsersTable,
  updateUser,
};
