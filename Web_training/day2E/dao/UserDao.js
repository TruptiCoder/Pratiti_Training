var { connectDB, connection} = require("../util/db.js");

connectDB();

const createUsersTable = async () => {
    const query = `
    CREATE TABLE IF NOT EXISTS users (
        id INT AUTO_INCREMENT PRIMARY KEY,
        username VARCHAR(50) NOT NULL,
        password VARCHAR(100) NOT NULL,
        email VARCHAR(100) NOT NULL
    )`;
    try {
        await connection.query(query);
        console.log("Users table ready");
    } catch (err) {
        console.error("Error creating users table:", err);
    }
}

// createUsersTable()


const addUser = async (user) => {
    const query = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
    let message;
    try {
        await connection.query(query, [user.username, user.password, user.email]);
        message = {success: true, message: "User inserted successfully"};
        return message;
    } catch (err) {
        message = {success: false, message: "Error inserting user"};
        return message;
    }
}

let user = { username: "Trupti", password: "pass@123", email: "trupti@example.com" };

// addUser(user).then((data) => {
//     console.log(data);
// });

const getAllUsers = async () => {
    const query = "SELECT * FROM users";
    const [rows] = await connection.query(query);
    return rows;
}

const getUser = async (username) => {
    const query = "SELECT * FROM users WHERE username = ?";
    const [rows] = await connection.query(query, [username]);
    return rows[0];
}

const deleteUser = async (username) => {
    const query = "DELETE FROM users WHERE username = ?";
    const [result] = await connection.query(query, [username]);
    return result.affectedRows > 0;
}

// getUser("Trupti").then((user) => {
//     console.log(user);
// });

// getAllUsers().then((users) => {
//     console.log(users);
// });

module.exports = { addUser, getAllUsers, getUser, deleteUser, createUsersTable };