import express from 'express';
import dotenv from 'dotenv';
import cors from 'cors';

dotenv.config({
    quiet: true
});

const app = express();
const port = process.env.PORT || 3000;

app.use(express.json());
app.use(cors())
app.use(express.static("src/public"));

app.get("/", (req, res) => {
    res.sendFile("index.html");
})

app.listen(port, () => {
    console.log(`Server is listening on port ${port}`);
})