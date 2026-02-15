import express from 'express'
const router = express.Router()

router.get("/", (req, res) => {
    res.send("<h1>Items routes response, GET method</h1>")
})

router.post("/", (req, res) => {
    res.send("<h1>Items routes response, POST method</h1>")
})

export default router;