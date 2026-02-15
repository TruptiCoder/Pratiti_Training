var express = require("express")
var router = express.Router();
var { loginUser } = require("../service/userService.js");

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index');
});

router.get("/login", (req, res) => {
  res.render("login", {error: null});
})

router.post("/validate", (req, res) => {
  let {username, password} = req.body;
  console.log(username, password);
  if(loginUser(username, password).success) {
    res.render("welcome", {username});
  } else {
    res.render("login", {error: "Invalid username or password"})
  }
})

module.exports = router;
