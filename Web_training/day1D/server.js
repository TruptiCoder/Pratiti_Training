import http from "http";
import fs from "fs";
import url from "url";
const PORT = 5555;

const server = http.createServer((req, res) => {
    const parseUrl = url.parse(req.url, true);
    const query = parseUrl.query;
    const pathName = parseUrl.pathname;

    if (pathName === "/") {
        fs.readFile("./index.html", (err, data) => {
            if (err) {
                res.writeHead(404, { "content-type": "text/html" });
                res.end("<h1>Page Not Found</h1>");
            } else {
                res.writeHead(200, { "content-type": "text/html" });
                res.end(data);
            }
        });
    } else if (pathName === "/login") {
        fs.readFile("./login.html", (err, data) => {
            if (err) {
                res.writeHead(404, { "content-type": "text/html" });
                res.end("<h1>Page Not Found</h1>");
            } else {
                res.writeHead(200, { "content-type": "text/html" });
                res.end(data);
            }
        });
    } else if (pathName === "/signup") {
        fs.readFile("./signup.html", (err, data) => {
            if (err) {
                res.writeHead(404, { "content-type": "text/html" });
                res.end("<h1>Page Not Found</h1>");
            } else {
                res.writeHead(200, { "content-type": "text/html" });
                res.end(data);
            }
        });
    } else if (pathName === "/welcome") {
        fs.readFile("./welcome.html", (err, data) => {
            if (err) {
                res.writeHead(404, { "content-type": "text/html" });
                res.end("<h1>Page Not Found</h1>");
            } else {
                res.writeHead(200, { "content-type": "text/html" });
                res.end(data);
            }
        });
    } else if (pathName === "/check") {
        if (query.username === query.password) {
            res.writeHead(302, {
                Location: "/welcome",
                "content-type": "text/html",
            });
            res.end();
        } else {
            fs.readFile("./failed.html", (err, data) => {
                if (err) {
                    res.writeHead(404, { "content-type": "text/html" });
                    res.end("<h1>Page Not Found</h1>");
                } else {
                    res.writeHead(200, { "content-type": "text/html" });
                    res.end(data);
                }
            });
        }
    } else if (req.url === "/style.css") {
        fs.readFile("./style.css", (err, css) => {
            res.writeHead(200, { "Content-Type": "text/css" });
            res.end(css);
        });
    } else {
        res.writeHead(404, { "content-type": "text/html" });
        res.end("<h1>Page Not Found</h1>");
    }
});

server.listen(PORT, "192.168.1.75", () => {
    console.log(`Server started at port ${PORT}`);
});
