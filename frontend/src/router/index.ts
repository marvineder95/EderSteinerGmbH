import { createRouter, createWebHistory } from 'vue-router'
import Home from '../components/Home.vue'
import Services from '../components/Services.vue'
import Contact from '../components/Contact.vue'
import Impressum from "../components/Impressum.vue";
import AboutUs from "../components/AboutUs.vue";
import Partner from "../components/Partner.vue";
import ServiceDetail from "../components/ServiceDetail.vue";
import Review from "../components/Review.vue";
import CreateReview from "../components/CreateReview.vue";

const routes = [
    { path: '/',          component: Home,      },
    { path: '/services',  component: Services,  },
    { path: '/leistungen/:slug', name: 'service-detail', component: ServiceDetail, props: true, },
    { path: '/contact',   component: Contact,   },
    { path: '/aboutUs',   component: AboutUs, },
    { path: '/partner',   component: Partner, },
    { path: '/impressum', component: Impressum, },
    { path: '/reviews', component: Review},
    { path: '/reviews/new', name: 'reviews-new', component: CreateReview},
]

const router = createRouter({
    history: createWebHistory(),
    routes,
})

export default router