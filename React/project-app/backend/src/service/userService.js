import {
  addUser,
  getAllUsers,
  getUser,
  deleteUser,
  updateUser,
  createUsersTable,
} from "../dao/Userdao.js";

export const initializeUsersTable = async () => {
  return await createUsersTable();
};

export const registerUser = async (user) => {
  return await addUser(user);
};

export const loginUser = async (email, password) => {
  const user = await getUser(email);

  if (!user) {
    return { success: false, message: "User not found" };
  }

  if (user.password === password) {
    return { success: true, message: "Login successful", user };
  } else {
    return { success: false, message: "Invalid credentials" };
  }
};

export const fetchAllUsers = async () => {
  return await getAllUsers();
};

export const fetchUser = async (email) => {
  return await getUser(email);
};

export const removeUser = async (id) => {
  return await deleteUser(id);
};

export const updateUserDetails = async (id, userData) => {
  return await updateUser(id, userData);
};