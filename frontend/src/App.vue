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
        <v-list-item link :to="'/'"          @click="drawer = false">Start</v-list-item>
        <v-list-item link :to="'/services'"  @click="drawer = false">Leistungen</v-list-item>
        <v-list-item link :to="'/aboutUs'"   @click="drawer = false">Über uns</v-list-item>
        <v-list-item link :to="'/contact'"   @click="drawer = false">Kontakt</v-list-item>
      </v-list>
    </v-navigation-drawer>
    <v-main>
        <router-view/>
    </v-main>
    <Partner v-if="$route.meta.showPartners" />
    <Footer />
  </v-app>
</template>

<script setup lang="ts">
import Footer from "./components/Footer.vue";
import Partner from "./components/Partner.vue";
import {ref, onMounted, onUnmounted} from 'vue'
import router from "./router";

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

</script>

<style scoped>

</style>