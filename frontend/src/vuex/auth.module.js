import AuthService from '../services/auth.service';

const client = JSON.parse(localStorage.getItem('client'));
const initialState = client
    ? { status: { loggedIn: true }, client }
    : { status: { loggedIn: false }, client: null };

export const auth = {
    namespaced: true,
    state: initialState,
    actions: {
        login({ commit }, client) {
            return AuthService.login(client).then(
                client => {
                    commit('loginSuccess', client);
                    return Promise.resolve(client);
                },
                error => {
                    commit('loginFailure');
                    return Promise.reject(error);
                }
            );
        },
        logout({ commit }) {
            AuthService.logout();
            commit('logout');
        },
        register({ commit }, client) {
            return AuthService.register(client).then(
                response => {
                    commit('registerSuccess');
                    return Promise.resolve(response.data);
                },
                error => {
                    commit('registerFailure');
                    return Promise.reject(error);
                }
            );
        }
    },
    mutations: {
        loginSuccess(state, client) {
            state.status.loggedIn = true;
            state.client = client;
        },
        loginFailure(state) {
            state.status.loggedIn = false;
            state.client = null;
        },
        logout(state) {
            state.status.loggedIn = false;
            state.client = null;
        },
        registerSuccess(state) {
            state.status.loggedIn = false;
        },
        registerFailure(state) {
            state.status.loggedIn = false;
        }
    }
};