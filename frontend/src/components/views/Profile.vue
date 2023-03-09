<template>
    <div class="container">
        <header class="jumbotron">
            <h3>
                <strong>{{currentClient.firstName}}</strong> Profile
            </h3>
        </header>
        <p>
            <strong>Token:</strong>
            {{currentClient.token.substring(0, 20)}} ... {{currentClient.token.substr(currentClient.token.length - 20)}}
        </p>
        <p>
            <strong>Client Number:</strong>
            {{currentClient.phoneNumber}}
        </p>
        <p>
            <strong>Email:</strong>
            {{currentClient.email}}
        </p>
        <strong>Authorities:</strong>
        <ul>
            <li v-for="(role,index) in currentClient.roles" :key="index">{{role}}</li>
        </ul>
    </div>
</template>

<script>
    export default {
        name: 'Profile',
        computed: {
            currentClient() {
                return this.$store.state.auth.client;
            }
        },
        mounted() {
            if (!this.currentClient) {
                this.$router.push('/sign_in');
            }
        }
    };
</script>