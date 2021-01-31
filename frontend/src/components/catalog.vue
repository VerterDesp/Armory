<template>
    <div class="catalog">
        <h1>Catalog</h1>
        <catalog-item />
    </div>
</template>

<script>
    import catalogItem from "@/components/catalog-item"

    export default {
        name: "catalog",
        components: {
            catalogItem
        }
    }
</script>

<style scoped>

</style>