import axios from "axios";

const API = axios.create({
  baseURL: "http://localhost:8080/api",
});

// 🔹 Register
export const registerUser = (data) => API.post("/auth/register", data);

// 🔹 Login
export const loginUser = (data) => API.post("/auth/login", data);

// 🔹 Usage Analysis
export const analyzeUsage = (data) => API.post("/usage/analyze", data);

export default API;