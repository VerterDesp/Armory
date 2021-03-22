import Vue from 'vue'
import Vuex from 'vuex'
import commonActions from './actions/actions'
import apiRequests from './actions/api-requests'
import mutations from "@/vuex/mutations/mutations";
import getters from "@/vuex/getters/getters";
import  { auth } from "@/vuex/auth.module";

const actions = {...commonActions, ...apiRequests}

Vue.use(Vuex);

let store = new Vuex.Store( {
    state: {
        products: [],
        cart: []
    },
    mutations,
    actions,
    getters,
    modules: {
        auth
    }
});

export default store;