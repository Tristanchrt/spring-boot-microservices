import axios from "axios"
import { environment } from "../../environments/environment"
import BaseService from "./BaseService"

export const login = (credentials) => {
    return axios.post(`${environment.apiUrl}/auth/login`, credentials).then((res) => res.data);
}

export const register = (form) => {
    return axios.post(`${environment.apiUrl}/auth/register`, form).then((res) => res.data);
}

export const currentUser = () => {
    return BaseService.getInstance().get(`${environment.apiUrl}/auth/current`).then((res) => res.data);
}

export const logOut = () => {
    localStorage.removeItem('token');
}