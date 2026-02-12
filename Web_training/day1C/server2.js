const http = require("http");
const PORT = 5555;
const fs = require("fs");
const { log } = require("console");
const url = require("url");

const server = http.createServer((req, res) => {
    res.writeHead(200, {"content-type": "text/html"});
    const parseUrl = url.parse(req.url, true);
    const query = parseUrl.query;

    log("pathname:", parseUrl.pathname)
    log("query:", query)

    log("uname:", query.uname)

    res.end("Welcome! Welcome! Welcome!")
});


server.listen(PORT, "localhost", () => {
    console.log(`Server started at port ${PORT}`)
});