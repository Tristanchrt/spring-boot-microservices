import axios from 'axios';


export class BaseService {

    static instance = axios;
    static token;

    static getInstance() {
        const token = localStorage.getItem('token');
        if (BaseService.instance === undefined || token !== BaseService.token) {
            BaseService.instance.interceptors.request.handlers = [];
            BaseService.instance.interceptors.request.use((config) => {
                if (token) {
                    BaseService.token = token;
                    config.headers["Authorization"] = token
                }
                return config;
            });
        }

        return BaseService.instance;
    }



}

export default BaseService;