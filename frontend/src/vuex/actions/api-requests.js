import axios from "axios";

export default {
    GET_PRODUCTS_FROM_API({commit}) {
        return axios('/handgun',{
            method: "GET"
        })
            .then((products) => {
                commit('SET_PRODUCTS_TO_STATE', products.data)
                return products;
            })
            .catch((error => {
                console.log(error)
                return error;
            }))
    }
}