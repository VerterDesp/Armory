<template>
    <div class="col-md-12">
        <div class="card card-container">
            <img
                    id="profile-img"
                    src="//ssl.gstatic.com/accounts/ui/avatar_2x.png"
                    class="profile-img-card"
            />
            <form name="form" @submit.prevent="handleRegister">
                <div v-if="!successful">
                    <div class="form-group">
                        <label for="firstName">First Name</label>
                        <input
                                v-model="client.firstName"
                                v-validate="'min:3|max:30'"
                                type="text"
                                class="form-control"
                                name="firstName"
                        />
                        <div
                                v-if="submitted && errors.has('firstName')"
                                class="alert-danger"
                        >{{errors.first('firstName')}}</div>
                    </div>
                    <div class="form-group">
                        <label for="lastName">Last Name</label>
                        <input
                                v-model="client.lastName"
                                v-validate="'min:3|max:30'"
                                type="text"
                                class="form-control"
                                name="lastName"
                        />
                        <div
                                v-if="submitted && errors.has('lastName')"
                                class="alert-danger"
                        >{{errors.first('lastName')}}</div>
                    </div>
<!--                    <div class="form-group">-->
<!--                        <label for="photo">Client photo</label>-->
<!--                        <input-->
<!--                                v-model="client.photo"-->
<!--                                type="file"-->
<!--                                class="form-control"-->
<!--                                name="photo"-->
<!--                        />-->
<!--                        <div-->
<!--                                v-if="submitted && errors.has('photo')"-->
<!--                                class="alert-danger"-->
<!--                        >{{errors.first('photo')}}</div>-->
<!--                    </div>-->
                    <div class="form-group">
                        <label for="phoneNumber">Phone Number</label>
                        <input
                                v-model="client.phoneNumber"
                                v-validate="'numeric|required|min:10|max:13'"
                                type="text"
                                class="form-control"
                                name="phoneNumber"
                        />
                        <div
                                v-if="submitted && errors.has('phoneNumber')"
                                class="alert-danger"
                        >{{errors.first('phoneNumber')}}</div>
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input
                                v-model="client.email"
                                v-validate="{required: false, email: true, max:50}"
                                type="email"
                                class="form-control"
                                name="email"
                        />
                        <div
                                v-if="submitted && errors.has('email')"
                                class="alert-danger"
                        >{{errors.first('email')}}</div>
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input
                                v-model="client.password"
                                v-validate="'required|min:6|max:40'"
                                type="password"
                                class="form-control"
                                name="password"
                        />
                        <div
                                v-if="submitted && errors.has('password')"
                                class="alert-danger"
                        >{{errors.first('password')}}</div>
                    </div>
                    <div class="form-group">
                        <button class="btn btn-primary btn-block">Sign Up</button>
                    </div>
                </div>
            </form>

            <div
                    v-if="message"
                    class="alert"
                    :class="successful ? 'alert-success' : 'alert-danger'"
            >{{message}}</div>
        </div>
    </div>
</template>

<script>
    import Client from '@/models/client';

    export default {
        name: 'Register',
        data() {
            return {
                client: new Client('', '', '', '', '', ''),
                submitted: false,
                successful: false,
                message: ''
            };
        },
        computed: {
            loggedIn() {
                return this.$store.state.auth.status.loggedIn;
            }
        },
        mounted() {
            if (this.loggedIn) {
                this.$router.push('/profile');
            }
        },
        methods: {
            handleRegister() {
                this.message = '';
                this.submitted = true;
                this.$validator.validate().then(isValid => {
                    if (isValid) {
                        this.$store.dispatch('auth/register', this.client).then(
                            data => {
                                this.message = data.message;
                                this.successful = true;
                            },
                            error => {
                                this.message =
                                    (error.response && error.response.data) ||
                                    error.message ||
                                    error.toString();
                                this.successful = false;
                            }
                        );
                    }
                });
            }
        }
    };
</script>

<style scoped>
    label {
        display: block;
        margin-top: 10px;
    }

    .card-container.card {
        max-width: 350px !important;
        padding: 40px 40px;
    }

    .card {
        background-color: #f7f7f7;
        padding: 20px 25px 30px;
        margin: 50px auto 25px;
        -moz-border-radius: 2px;
        -webkit-border-radius: 2px;
        border-radius: 2px;
        -moz-box-shadow: 0 2px 2px rgba(0, 0, 0, 0.3);
        -webkit-box-shadow: 0 2px 2px rgba(0, 0, 0, 0.3);
        box-shadow: 0 2px 2px rgba(0, 0, 0, 0.3);
    }

    .profile-img-card {
        width: 96px;
        height: 96px;
        margin: 0 auto 10px;
        display: block;
        -moz-border-radius: 50%;
        -webkit-border-radius: 50%;
        border-radius: 50%;
    }
</style>