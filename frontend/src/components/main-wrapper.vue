<template>
    <div class="main-wrapper">
        <nav class="navbar navbar-expand navbar-dark bg-dark">
            <div class="navbar-brand" @click.prevent>
                <router-link to="/catalog" class="nav-link">
                    Primo
                </router-link>
            </div>
            <div class="navbar-nav mr-auto">
                <li class="nav-item">
                    <router-link to="/home" class="nav-link">
                        <font-awesome-icon icon="home" /> Home
                    </router-link>
                </li>
                <li v-if="showAdminBoard" class="nav-item">
                    <router-link to="/admin" class="nav-link"> Admin Board</router-link>
                </li>
                <li v-if="showModeratorBoard" class="nav-item">
                    <router-link to="/moder" class="nav-link"> Moderator Board</router-link>
                </li>
                <li class="nav-item">
                    <router-link v-if="currentUser" to="/client" class="nav-link"> Client</router-link>
                </li>
            </div>

            <div v-if="!currentUser" class="navbar-nav ml-auto">
                <li class="nav-item">
                    <router-link to="/sign_up" class="nav-link">
                        <font-awesome-icon icon="user-plus" /> Sign Up
                    </router-link>
                </li>
                <li class="nav-item">
                    <router-link to="/sign_in" class="nav-link">
                        <font-awesome-icon icon="sign-in-alt" /> Sign In
                    </router-link>
                </li>
            </div>

            <div v-if="currentUser" class="navbar-nav ml-auto">
                <li class="nav-item">
                    <router-link to="/profile" class="nav-link">
                        <font-awesome-icon icon="user" />
                        {{ currentUser.firstName }}
                    </router-link>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href @click.prevent="logOut">
                        <font-awesome-icon icon="sign-out-alt" /> Sign Out
                    </a>
                </li>
            </div>
        </nav>
<!--        <keep-alive>-->
<!--            <router-view></router-view>-->
<!--        </keep-alive>-->
        <div class="container">
            <router-view />
        </div>
    </div>
</template>

<script>
    export default {
        name: 'main-wrapper',
        props: {},
        data() {
            return {
                title: 'Main wrapper'
            }
        },
        computed: {
            currentUser() {
                return this.$store.state.auth.client;
            },
            showAdminBoard() {
                if (this.currentUser && this.currentUser.roles) {
                    return this.currentUser.roles.includes('ROLE_ADMIN');
                }

                return false;
            },
            showModeratorBoard() {
                if (this.currentUser && this.currentUser.roles) {
                    return this.currentUser.roles.includes('ROLE_MODERATOR');
                }

                return false;
            }
        },
        methods: {
            logOut() {
                this.$store.dispatch('auth/logout');
                this.$router.push('/sign_in');
            }
        }
    }
</script>

<style>
    .main-wrapper {
        /*max-width: 900px;*/
        /*margin: 0 auto;*/
    }
</style>