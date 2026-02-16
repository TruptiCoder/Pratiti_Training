import { addUser, getAllUsers, getUser, deleteUser, updateUser } from "../dao/Userdao.js";

export const registerUser = async (user) => {
    return await addUser(user);
}

export const loginUser = async (username, password) => {
    const user = await getUser(username);
    if (user && user.password === password) {
        return { success: true, message: "Login successful" };
    } else {
        return { success: false, message: "Invalid username or password" };
    }
}

export const fetchAllUsers = async () => {
    return await getAllUsers();
}

export const fetchUser = async (username) => {
    return await getUser(username);
}

export const removeUser = async (username) => {
    return await deleteUser(username);
}

export const updateUserMail = async (username, email) => {
    return await updateUser(username, email);
}