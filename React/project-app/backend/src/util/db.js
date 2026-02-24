import mysql from "mysql2/promise";
import dotenv from "dotenv";

dotenv.config();

let connection;

const connectDB = async () => {
    try {
        connection = await mysql.createConnection({
            host: process.env.DB_HOST,
            user: process.env.DB_USER,
            password: process.env.DB_PASSWORD,
            database: process.env.DB_NAME,
            port: process.env.DB_PORT
        });

        console.log("Database connected successfully");
    } catch (err) {
        console.log("Error connecting to database:", err);
    }
};

export { connectDB, connection };