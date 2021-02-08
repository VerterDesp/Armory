import Vue from 'vue'
import Router from 'vue-router'

import catalog from "@/components/catalog/catalog";
import cart from "@/components/cart/cart";

Vue.use(Router);

let router = new Router({
    routes: [
        {
            path: '/',
            name: 'catalog',
            component: catalog
        },
        {
            path: '/cart',
            name: 'cart',
            component: cart,
            props: true
        }
    ]
})

export default router;