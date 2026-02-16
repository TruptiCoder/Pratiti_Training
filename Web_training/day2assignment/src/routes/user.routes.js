import express from 'express';
import { fetchAllUsers, fetchUser, removeUser, updateUserMail } from '../service/userService.js';

const router = express.Router();

router.get("/", async (req, res) => {
    const users = await fetchAllUsers();
    res.send(users);
});

router.get("/:username", async (req, res) => {
    const { username } = req.params;
    const user = await fetchUser(username);
    res.send(user);
});

router.delete("/:username", async (req, res) => {
    const { username } = req.params;
    const result = await removeUser(username);
    res.send(result);
})

router.put("/:username", async (req, res) => {
    const {username} = req.params;
    const {email} = req.body;
    const result = await updateUserMail(username, email);
    res.send(result);
})

export default router;