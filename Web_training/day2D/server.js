import express from 'express';
import itemsRouter from "./routes/items.js";
import productRouter from './routes/products.js'

const app = express();
const port = 5050;

app.use(express.urlencoded({extended: true}));
app.use(express.json());
app.set("view engine", "ejs");
app.use("/items", itemsRouter);
app.use("/items", productRouter);


app.get("/", (req, res) => {
    res.render("index");
})

app.get("/login", (req, res) => {
    res.render("login", {error: null});
})

app.post("/validate", (req, res) => {
    let {username, password} = req.body;
    if(username == "admin" && password == "password") {
        res.render("welcome", {username})
    } else {
        res.render("login", {error: "Invalid username or password"})
    }
})

app.listen(port, () => {
    console.log("Server started at port", port);
});