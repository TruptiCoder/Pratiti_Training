const http = require("http");
const PORT = 5555;

const server = http.createServer((req, res) => {
    console.log(req.url)
    console.log(req.socket.remoteAddress)

    res.writeHead(200, {'content-type': 'text/plain'})
    res.write("Welcome to my server\n")
    res.end("Hello world from Trupti");
});


server.listen(PORT, "localhost", () => {
    console.log(`Server started at port ${PORT}`)
});