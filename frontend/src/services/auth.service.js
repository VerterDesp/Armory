import axios from 'axios';

const AUTH_URL = '/auth/';

class AuthService {
    login(client) {
        return axios
            .post(AUTH_URL + 'sign_in', {
                username: client.username,
                password: client.password
            })
            .then(response => {
                if (response.data.token) {
                    localStorage.setItem('client', JSON.stringify(response.data));
                }
                return response.data;
            });
    }

    logout() {
        localStorage.removeItem('client');
    }

    register(client) {
        return axios.post(AUTH_URL + 'sign_up', {
            firstName: client.firstName,
            lastName: client.lastName,
            photo: client.photo,
            phoneNumber: client.phoneNumber,
            email: client.email,
            password: client.password
        });
    }
}

export default new AuthService();