<template>
  <v-app>
      <v-app-bar color="white" scroll-behavior="fully-hide">
        <v-toolbar-title class="font-bold">Eder & Steiner GmbH</v-toolbar-title>
        <v-spacer></v-spacer>

        <!-- Desktop -->
        <template v-if="!isMobile">
          <v-btn variant="text" @click="scrollTo('home')">Start</v-btn>
          <v-btn variant="text" @click="scrollTo('services')">Leistungen</v-btn>
          <v-btn variant="text" @click="scrollTo('about')">Über uns</v-btn>
          <v-btn variant="text" @click="scrollTo('contact')">Kontakt</v-btn>
        </template>

        <!-- Mobile -->
        <template v-else>
          <v-btn icon @click="drawer = true">
            <v-icon>mdi-menu</v-icon>
          </v-btn>
        </template>
      </v-app-bar>

    <v-navigation-drawer v-model="drawer" location="right" temporary>
      <v-list>
        <v-list-item @click="navAndClose('home')">Start</v-list-item>
        <v-list-item @click="navAndClose('services')">Leistungen</v-list-item>
        <v-list-item @click="navAndClose('about')">Über uns</v-list-item>
        <v-list-item @click="navAndClose('contact')">Kontakt</v-list-item>
      </v-list>
    </v-navigation-drawer>

    <v-main>
      <Home/>
      <Services/>
      <Contact/>
      <Footer/>
    </v-main>
  </v-app>
</template>

<script setup lang="ts">
import Home from './components/Home.vue'
import Contact from "./components/Contact.vue";
import Services from "./components/Services.vue";
import Footer from "./components/Footer.vue";
import {ref, onMounted, onUnmounted} from 'vue'

const drawer = ref(false)
const isMobile = ref(false)

function handleResize() {
  isMobile.value = window.innerWidth < 900
}
onMounted(() => {
  handleResize()
  window.addEventListener('resize', handleResize)
})

onUnmounted(() => {
  window.removeEventListener('resize', handleResize)
})

function scrollTo(id: string) {
  const el = document.getElementById(id)
  if (el) {
    el.scrollIntoView({behavior: 'smooth'})
  }
}

function navAndClose(id: string) {
  drawer.value = false
  setTimeout(() => scrollTo(id), 300)
}
</script>

<style scoped>
[v-cloak] {
  display: none;
}
</style>