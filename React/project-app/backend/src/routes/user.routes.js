import express from "express";
import multer from "multer";
import {
  fetchAllUsers,
  fetchUser,
  removeUser,
  updateUserDetails,
} from "../service/userService.js";

const router = express.Router();

router.get("/", async (req, res) => {
  try {
    const users = await fetchAllUsers();
    return res.status(200).json(users);
  } catch (error) {
    return res.status(500).json({ success: false, message: "Server error" });
  }
});

router.get("/:email", async (req, res) => {
  try {
    const { email } = req.params;
    const user = await fetchUser(email);

    if (!user) {
      return res.status(404).json({ success: false, message: "User not found" });
    }

    return res.status(200).json(user);
  } catch (error) {
    return res.status(500).json({ success: false, message: "Server error" });
  }
});

router.delete("/:id", async (req, res) => {
  try {
    const { id } = req.params;
    const result = await removeUser(id);

    if (result) {
      return res.status(200).json({ success: true, message: "User deleted" });
    }

    return res.status(404).json({ success: false, message: "User not found" });

  } catch (error) {
    return res.status(500).json({ success: false, message: "Server error" });
  }
});

const storage = multer.memoryStorage();
const upload = multer({ storage });

router.put("/:id", upload.single("image"), async (req, res) => {
  try {
    const { id } = req.params;

    const userData = {
      fullname: req.body.fullname,
      mobile: req.body.mobile,
      city: req.body.city,
      age: req.body.age,
      designation: req.body.designation,
    };

    if (req.file) {
      userData.image = req.file.buffer;
    }

    const result = await updateUserDetails(id, userData);

    if (result) {
      return res.status(200).json({
        success: true,
        message: "Profile updated successfully",
      });
    }

    return res.status(404).json({
      success: false,
      message: "User not found",
    });

  } catch (error) {
    console.error("Server error:", error);
    return res.status(500).json({
      success: false,
      message: "Server error",
    });
  }
});

export default router;