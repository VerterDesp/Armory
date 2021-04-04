import axios from 'axios';

const AUTH_URL = '/auth/';

class AuthService {
    login(user) {
        return axios
            .post(AUTH_URL + 'sign_in', {
                username: user.username,
                password: user.password
            })
            .then(response => {
                if (response.data.token) {
                    localStorage.setItem('user', JSON.stringify(response.data));
                }
                return response.data;
            });
    }

    logout() {
        localStorage.removeItem('user');
    }

    register(user) {
        return axios.post(AUTH_URL + 'sign_up', {
            fullName: user.fullName,
            photo: user.photo,
            phoneNumber: user.phoneNumber,
            email: user.email,
            password: user.password
        });
    }
}

export default new AuthService();