<template>
    <div class='cart-item'>
        <div class="cart-item__info">
            <p>{{cart_item_data.brand}}</p>
            <p>{{cart_item_data.price}}</p>
            <p>{{cart_item_data.id}}</p>
        </div>
        <div class="cart-item__quantity">
            <p>Qty:</p>
            {{cart_item_data.quantity}}
        </div>
        <button @click="deleteFromCart">Delete</button>
    </div>
</template>

<script>
    export default {
        name: "cart-item",
        props: {
            cart_item_data: {
                type: Object,
                default() {
                    return {}
                }
            }
        },
        data() {
            return {}
        },
        computed: {},
        methods: {
            deleteFromCart() {
                this.$emit('deleteFromCart')
            }
        },
        mounted() {}
    }
</script>

<style lang="scss">
    .cart-item {
        display: flex;
        flex-wrap: nowrap;
        justify-content: space-between;
        align-items: center;
        box-shadow: 0 0 8px 0 #e0e0e0;
        padding: $padding * 2;
        margin-bottom: $margin * 2;
        &__image {
            max-width: 50px;
        }
    }

</style>