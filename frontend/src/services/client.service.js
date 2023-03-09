import axios from 'axios';
import authHeader from './auth-header';

class ClientService {
    getPublicContent() {
        return axios.get('/all');
    }

    getClientBoard() {
        return axios.get('/client', { headers: authHeader() });
    }

    getModeratorBoard() {
        return axios.get('/moder', { headers: authHeader() });
    }

    getAdminBoard() {
        return axios.get('/admin', { headers: authHeader() });
    }
}

export default new ClientService();