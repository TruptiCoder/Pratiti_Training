const http = require("http");
const PORT = 5555;
const fs = require("fs");
const { log } = require("console");

const server = http.createServer((req, res) => {
    const {url, method} = req;
    log(url);
    log(method)
    res.writeHead(200, {'content-type': 'text/html'})

    fs.readFile("./index.html", (err, data) => {
        if(err) {
            res.write("Error in reading file");
            res.end();
        } else {
            res.write(data);
            res.end();
        }
    })
});


server.listen(PORT, "localhost", () => {
    console.log(`Server started at port ${PORT}`)
});