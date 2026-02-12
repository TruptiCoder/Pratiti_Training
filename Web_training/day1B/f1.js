console.log("f1.js loaded")

const dotenv = require("dotenv");
const fs = require("fs").promises;

dotenv.config();

console.log(process.env.COMPANY)

// fs.readFile("profile.txt", "utf8", (err, data) => {
//     console.log(data);
// });

const data = async () => {
    const f = await fs.readFile("profile.txt", "utf8");
    console.log(f);
}

data()