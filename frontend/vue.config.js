module.exports = {
    devServer: {
        proxy: "http://localhost:8000"
    },
    css: {
        loaderOptions: {
            sass: {
                additionalData: `@import "@/assets/styles/variables.scss";`
            }
        }
    }
};