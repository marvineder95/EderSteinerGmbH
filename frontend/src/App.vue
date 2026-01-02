<template>
  <v-app>
    <v-app-bar color="primary" scroll-behavior="inverted" elevation="0">
      <v-toolbar-title class="cursor-pointer ms-n8" @click="$router.push('/')">
        <v-img
            src="/es-logo.png"
            alt="Eder & Steiner GmbH"
            height="80"
        />
      </v-toolbar-title>
      <v-spacer />

      <!-- Desktop-Navigation -->
      <template v-if="!isMobile">
        <v-btn variant="text" to="/">Start</v-btn>

        <!-- Leistungen mit Dropdown -->
        <v-menu open-on-hover offset-y>
          <template #activator="{ props }">
            <v-btn variant="text" to="/services" v-bind="props" append-icon="mdi-chevron-down">
              Leistungen
            </v-btn>
          </template>

          <v-list density="comfortable">
            <v-list-item :to="'/services'" link>
              <v-list-item-title>Alle Leistungen</v-list-item-title>
            </v-list-item>
            <v-divider thickness="2px" color="black"/>
            <v-list-item
                v-for="item in serviceLinks"
                :key="item.to"
                :to="item.to"
                link
            >
              <v-list-item-title>{{ item.label }}</v-list-item-title>
            </v-list-item>
          </v-list>
        </v-menu>

        <v-btn variant="text" @click="$router.push('/aboutUs')">Über uns</v-btn>
        <v-btn variant="text" @click="$router.push('/contact')">Kontakt</v-btn>
        <v-btn variant="text" @click="$router.push('/reviews')">Kundenstimmen</v-btn>
      </template>

      <template v-else>
        <v-btn icon @click="handleDrawer"><v-icon>mdi-menu</v-icon></v-btn>
      </template>
    </v-app-bar>

    <!-- Mobile-Navigation -->
    <v-navigation-drawer class="bg-primary" v-model="drawer" location="right" temporary>
      <v-list>
        <v-list-item link :to="'/'" @click="drawer = false">Start</v-list-item>

        <!-- Leistungen als aufklappbare Gruppe -->
        <v-list-group value="leistungen">
          <template #activator="{ props }">
            <v-list-item v-bind="props" title="Leistungen"/>
          </template>

          <v-list-item :to="'/services'" link @click="drawer = false">
            <v-list-item-title>Alle Leistungen</v-list-item-title>
          </v-list-item>

          <v-list-item
              v-for="item in serviceLinks"
              :key="item.to"
              :to="item.to"
              link
              @click="drawer = false"
          >
            <v-list-item-title>{{ item.label }}</v-list-item-title>
          </v-list-item>
        </v-list-group>

        <v-list-item link :to="'/aboutUs'" @click="drawer = false">Über uns</v-list-item>
        <v-list-item link :to="'/contact'" @click="drawer = false">Kontakt</v-list-item>
        <v-btn variant="text" @click="$router.push('/reviews')">Kundenstimmen</v-btn>
      </v-list>
    </v-navigation-drawer>

    <v-main class="d-flex flex-column min-h-screen">
      <router-view class="flex-grow-1" />
      <Footer class="mt-auto" />
    </v-main>
  </v-app>
</template>

<script setup lang="ts">
import Footer from './components/Footer.vue'
import { ref, onMounted, onUnmounted } from 'vue'

const drawer = ref(false)
const isMobile = ref(false)

const serviceLinks = [
  { label: 'Umzüge',          to: '/leistungen/umzuege' },
  { label: 'Entrümpelungen',  to: '/leistungen/entruempelungen' },
  { label: 'Lagerung',        to: '/leistungen/lagerung' },
]

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
</script>