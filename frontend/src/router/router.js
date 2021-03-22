import Vue from 'vue'
import Router from 'vue-router'
import Home from "@/components/views/Home";
import Login from "@/components/views/Login";
import Register from "@/components/views/Register";

import catalog from "@/components/catalog/catalog";
import cart from "@/components/cart/cart";

Vue.use(Router);

let router = new Router({
    mode: 'history',
    routes: [
        {
            path: '/',
            name: 'home',
            component: Home
        },
        {
            path: '/home',
            component: Home
        },
        {
            path: '/sign_in',
            component: Login
        },
        {
            path: '/sign_up',
            component: Register
        },
        {
            path: '/profile',
            name: 'profile',
            // lazy-loaded
            component: () => import('@/components/views/Profile.vue')
        },
        {
            path: '/admin',
            name: 'admin',
            // lazy-loaded
            component: () => import('@/components/views/BoardAdmin.vue')
        },
        {
            path: '/moder',
            name: 'moderator',
            // lazy-loaded
            component: () => import('@/components/views/BoardModerator.vue')
        },
        {
            path: '/user',
            name: 'user',
            // lazy-loaded
            component: () => import('@/components/views/BoardUser.vue')
        },
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

router.beforeEach((to, from, next) => {
    const publicPages = ['/sign_in', '/sign_up', '/home'];
    const authRequired = !publicPages.includes(to.path);
    const loggedIn = localStorage.getItem('user');

    // trying to access a restricted page + not logged in
    // redirect to login page
    if (authRequired && !loggedIn) {
        next('/sign_in');
    } else {
        next();
    }
});