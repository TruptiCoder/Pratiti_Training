import express from 'express';
import itemsRouter from "./src/routes/items.js";
import productRouter from './src/routes/products.js'

const app = express();
const port = 5050;

app.use((req, res, next) => {
    console.log("I am middleware");
    next();
})

app.use("/items", itemsRouter);
app.use("/items", productRouter);


app.get("/", (req, res) => {
    res.send("<h1>Hello from server</h1>");
})

app.listen(port, () => {
    console.log("Server started at port", port);
});