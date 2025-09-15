import { createApp } from 'vue'
import pinia from "./plugins/pinia.ts";
import App from './App.vue'
import router from './router'

import vuetify from './plugins/vuetify'
import '@mdi/font/css/materialdesignicons.css'
import './styles/global.css'

createApp(App)
    .use(pinia)
    .use(router)
    .use(vuetify)
    .mount('#app')