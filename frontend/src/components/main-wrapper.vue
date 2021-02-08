<template>
    <div class="main-wrapper">
        <keep-alive>
            <router-view></router-view>
        </keep-alive>
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
        computed: {},
        methods: {},
        watch: {},
    }
</script>

<style>
    .main-wrapper {
        max-width: 900px;
        margin: 0 auto;
    }
</style>