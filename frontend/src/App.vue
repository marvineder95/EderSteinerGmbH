<template>
  <v-app>
      <v-app-bar color="primary" scroll-behavior="inverted" elevation="0">
        <v-toolbar-title class="cursor-pointer" @click="scrollTo('home')">
          <v-img src="/images/Firmenlogo.png" width="50px" />
        </v-toolbar-title>
        <v-spacer></v-spacer>

        <template v-if="!isMobile">
          <v-btn variant="text" @click="$router.push('/')">Start</v-btn>
          <v-btn variant="text" @click="$router.push('/services')">Leistungen</v-btn>
          <v-btn variant="text" @click="$router.push('/aboutUs')">Über uns</v-btn>
          <v-btn variant="text" @click="$router.push('/contact')">Kontakt</v-btn>
        </template>

        <template v-else>
          <v-btn icon @click="handleDrawer">
            <v-icon>mdi-menu</v-icon>
          </v-btn>
        </template>
      </v-app-bar>

    <v-navigation-drawer class="bg-primary" v-model="drawer" location="right" temporary>
      <v-list>
        <v-list-item @click="navAndClose('home')">Start</v-list-item>
        <v-list-item @click="navAndClose('services')">Leistungen</v-list-item>
        <v-list-item @click="navAndClose('about')">Über uns</v-list-item>
        <v-list-item @click="navAndClose('contact')">Kontakt</v-list-item>
      </v-list>
    </v-navigation-drawer>
    <v-main>
      <router-view />
      <Partner v-if="$route.meta.showPartners" />
      <Footer />
    </v-main>
  </v-app>
</template>

<script setup lang="ts">
import Footer from "./components/Footer.vue";
import Partner from "./components/Partner.vue";
import {ref, onMounted, onUnmounted} from 'vue'

const drawer = ref(false)
const isMobile = ref(false)

function handleDrawer() {
  drawer.value = !drawer.value
}

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
.content-container {
  height: calc(100vh - 40vh); /* Platz für Navbar + Footer */
}
</style>