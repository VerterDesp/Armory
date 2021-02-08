<template>
  <div class="cart">
      <router-link :to="{name: 'catalog'}">
          <div class="catalog__link_to_cart">Back to Catalog</div>
      </router-link>
      <h1>Cart</h1>
      <p v-if="!cart_data.length">No products in cart...</p>
      <cart-item
              v-for="(item, index) in cart_data"
              :key="item.id"
              :cart_item_data="item"
              @deleteFromCart="deleteFromCart(index)"
      />
  </div>
</template>

<script>
    import cartItem from './cart-item'
    import {mapActions} from 'vuex'

    export default {
        name: "cart",
        components: {
            cartItem
        },
        props: {
            cart_data: {
                type: Array,
                default() {
                    return [];
                }
            }
        },
        data() {
            return {}
        },
        computed: {},
        methods: {
            ...mapActions([
               'DELETE_FROM_CART'
            ]),
            deleteFromCart(index) {
                this.DELETE_FROM_CART(index)
            }
        }
    }
</script>

<style>

</style>