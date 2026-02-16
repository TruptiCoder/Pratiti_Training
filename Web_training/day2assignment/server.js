import express, { urlencoded } from 'express';
import dotenv from 'dotenv';
import cors from 'cors';

import authRouter from './src/routes/auth.routes.js';
import userRouter from "./src/routes/user.routes.js";

const app = express();
const port = process.env.PORT || 5050;

dotenv.config({
    quiet: true
});

app.use(cors({
    origin: "*"
}))
app.use(express.urlencoded({extended: true}));
app.use(express.json());
app.use("/auth", authRouter);
app.use("/users", userRouter);

app.listen(port, () => {
    console.log(`Server started at port ${port}`);
})