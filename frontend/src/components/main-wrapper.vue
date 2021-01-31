<template>
    <div class="main-wrapper">
        <p>Main Wrapper</p>
        <catalog />
        <cart />
    </div>
</template>

<script>
    import catalog from "@/components/catalog";
    import cart from "@/components/cart";

    export default {
        name: 'main-wrapper',
        components: {
            catalog,
            cart
        },
        data() {},
        computed: {},
        methods: {},
        watch: {},
        mounted() {
            console.log("i am main wrapper")
        }
    }
</script>

<style>
    .main-wrapper {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        max-width: 900px;
        margin: 0 auto;
    }
</style>