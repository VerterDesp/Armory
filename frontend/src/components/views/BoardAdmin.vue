<template>
    <div class="container">
        <header class="jumbotron">
            <h3>{{content}}</h3>
        </header>
    </div>
</template>

<script>
    import ClientService from '@/services/client.service';

    export default {
        name: 'Admin',
        data() {
            return {
                content: ''
            };
        },
        mounted() {
          ClientService.getAdminBoard().then(
                response => {
                    this.content = response.data;
                },
                error => {
                    this.content =
                        (error.response && error.response.data && error.response.data.message) ||
                        error.message ||
                        error.toString();
                }
            );
        }
    };
</script>