import express from 'express';
import { registerUser, loginUser } from "../service/userService.js";

const router = express.Router();

router.post("/signup", async (req, res) => {
    const user = req.body;
    const result = await registerUser(user);
    res.send(result);
});

router.post("/login", async (req, res) => {
    const {username, password} = req.body;
    const result = await loginUser(username, password);
    res.send(result);
})

export default router;