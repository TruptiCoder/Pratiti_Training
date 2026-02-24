import express from "express";
import { registerUser, loginUser } from "../service/userService.js";

const router = express.Router();

router.post("/signup", async (req, res) => {
  try {
    const user = req.body;

    if (!user.email || !user.password) {
      return res.status(400).json({
        success: false,
        message: "Email and password are required",
      });
    }

    const result = await registerUser(user);

    if (result.success) {
      return res.status(201).json(result);
    } else {
      return res.status(400).json(result);
    }

  } catch (error) {
    return res.status(500).json({
      success: false,
      message: "Server error during signup",
    });
  }
});

router.post("/login", async (req, res) => {
  try {
    const { email, password } = req.body;

    if (!email || !password) {
      return res.status(400).json({
        success: false,
        message: "Email and password are required",
      });
    }

    const result = await loginUser(email, password);

    if (result.success) {
      return res.status(200).json(result);
    } else {
      return res.status(401).json(result);
    }

  } catch (error) {
    console.log(error)
    return res.status(500).json({
      success: false,
      message: "Server error during login",
    });
  }
});

export default router;