import { createRouter, createWebHistory } from 'vue-router'
import Home from '../components/Home.vue'
import Services from '../components/Services.vue'
import Contact from '../components/Contact.vue'
import Impressum from "../components/Impressum.vue";
import AboutUs from "../components/AboutUs.vue";
import Partner from "../components/Partner.vue";

const routes = [
    { path: '/',          component: Home,      meta: { showPartners: true  } },
    { path: '/services',  component: Services,  meta: { showPartners: true  } },
    { path: '/contact',   component: Contact,   meta: { showPartners: true  } },
    { path: '/aboutUs',   component: AboutUs, meta:{ showPartners: true } },
    { path: '/partner',   component: Partner, meta:{ showPartners: false } },
    { path: '/impressum', component: Impressum, meta:{ showPartners: false } },
]

const router = createRouter({
    history: createWebHistory(),
    routes,
})

export default router