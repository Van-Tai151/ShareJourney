import axios from "axios";
const BASE_URL = "http://localhost:8080/DemoAppWeb/";

export const endpoints = {
    'categories': '/api/categories/'
}
export default axios.create({
    baseURL:BASE_URL
}

);