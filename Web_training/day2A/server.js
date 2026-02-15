import express from 'express';
import dotenv from 'dotenv';

dotenv.config({
    quiet: true
});

const app = express();
const port = process.env.PORT || 3000;

app.use(express.json());

app.get("/", (req, res) => {
    res.send("Hello, This is response from Trupti's Server", req.query.uname);
})

app.post("/employees/:empname/id/:id", (req, res) => {
    let {empname, id} = req.params;
    res.send("Hello from post method for employee with employee:" + empname + " and id: " + id);
})

app.put("/employees/:id", (req, res) => {
    res.send("Hello from put method for employee with ID: " + req.params.id);
})

app.delete("/", (req, res) => {
    res.send("Hello from delete method")
})

app.get("/about", (req, res) => {
    res.send("This is about page")
})

app.listen(port, () => {
    console.log(`Server is listening on port ${port}`);
})