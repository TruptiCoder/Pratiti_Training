import http from "http";
import fs from "fs";
import url from "url";
import * as service from "./service/userService.js";
const PORT = 5555;

const server = http.createServer( async (req, res) => {
    const parseUrl = url.parse(req.url, true);
    const pathName = parseUrl.pathname;
    const query = parseUrl.query;

    if (pathName === "/") {
        res.writeHead(200, { "Content-Type": "text/html" });
        const data = fs.readFileSync("./view/index.html", "utf-8");
        res.write(data);
        res.end();
    } else if (pathName === "/register") {
        res.writeHead(200, { "Content-Type": "text/html" });
        const user = {
            username: query.username,
            password: query.password,
            email: query.email
        }
        await service.registerUser(user).then((message) => {
            const data = fs.readFileSync("./view/login.html", "utf-8");
            res.write(data);
            res.end();
        });
    } else if (pathName === "/check") {
        res.writeHead(200, { "Content-Type": "text/html" });
        const username = query.username;
        const password = query.password;
        const result = await service.loginUser(username, password);
        if (result.success) {
            const data = fs.readFileSync("./view/welcome.html", "utf-8");
            res.write(data);
        } else {
            const data = fs.readFileSync("./view/failed.html", "utf-8");
            res.write(data);
        }

        res.end();
    } else if (pathName === "/style.css") {
        res.writeHead(200, { "Content-Type": "text/css" });
        const data = fs.readFileSync("./view/style.css", "utf-8");
        res.write(data);
        res.end();
    } else if (pathName === "/signup") {
        res.writeHead(200, { "Content-Type": "text/html" });
        const data = fs.readFileSync("./view/signup.html", "utf-8");
        res.write(data);
        res.end();
    }  else if (pathName === "/login") {
        res.writeHead(200, { "Content-Type": "text/html" });
        const data = fs.readFileSync("./view/login.html", "utf-8");
        res.write(data);
        res.end();
    } else {
        res.writeHead(404, { "Content-Type": "text/plain" });
        res.write("404 Not Found");
        res.end();
    }
});

server.listen(PORT, "localhost", () => {
    console.log(`Server started at port ${PORT}`);
});
