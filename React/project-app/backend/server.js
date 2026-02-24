import express, { urlencoded } from 'express';
import cors from 'cors';

import authRouter from './src/routes/auth.routes.js';
import userRouter from "./src/routes/user.routes.js";

const app = express();
const port = 5050;

app.use(cors({
    origin: "*",
    methods: ["POST", "GET", "DELETE", "PUT"]
}))
app.use(express.urlencoded({extended: true}));
app.use(express.json());
app.use("/auth", authRouter);
app.use("/users", userRouter);

app.listen(port, () => {
    console.log(`Server started at port ${port}`);
})