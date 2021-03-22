import axios from 'axios';
import authHeader from './auth-header';

class UserService {
    getPublicContent() {
        return axios.get('/all');
    }

    getUserBoard() {
        return axios.get('/user', { headers: authHeader() });
    }

    getModeratorBoard() {
        return axios.get('/moder', { headers: authHeader() });
    }

    getAdminBoard() {
        return axios.get('/admin', { headers: authHeader() });
    }
}

export default new UserService();