import axios from "axios";
import cookie from "react-cookies";

const BASE_URL = 'http://localhost:8080/DemoAppWeb/';

export const endpoints = {
    'categories': '/api/categories/', 
    'journeys': '/api/journeys/',
    'register': '/api/users/',
    'login': '/api/login/',
}

export const authApi = () => {
    return axios.create({
        baseURL: BASE_URL,
        headers: {
            'Authorization': `${cookie.load('token')}`
        }
    });
}

export default axios.create({
    baseURL: BASE_URL
});