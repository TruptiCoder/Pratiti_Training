var { addUser, getAllUsers, getUser, deleteUser } = require("../dao/Userdao.js");

const registerUser = async (user) => {
    return await addUser(user);
}

const loginUser = async (username, password) => {
    const user = await getUser(username);
    if (user && user.password === password) {
        return { success: true, message: "Login successful" };
    } else {
        return { success: false, message: "Invalid username or password" };
    }
}

const fetchAllUsers = async () => {
    return await getAllUsers();
}

const fetchUser = async (username) => {
    return await getUser(username);
}

const removeUser = async (username) => {
    return await deleteUser(username);
}

module.exports = { fetchUser, fetchAllUsers, removeUser, loginUser, registerUser }