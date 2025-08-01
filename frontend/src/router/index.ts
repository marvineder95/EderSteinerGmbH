import { createRouter, createWebHistory } from 'vue-router'
import Home from '../components/Home.vue'
import Services from '../components/Services.vue'
import Contact from '../components/Contact.vue'

const routes = [
    { path: '/', component: Home },
    { path: '/services', component: Services },
    { path: '/contact', component: Contact },
]

const router = createRouter({
    history: createWebHistory(),
    routes,
})

export default router