<template>
  <section id="services" class="section">
    <v-container class=" align-center justify-center text-center">
      <h2 class="text-h4 mb-10">Unsere Leistungen</h2>
      <v-row>
        <v-col
            v-for="service in services"
            :key="service.title"
            cols="12"
            sm="6"
            md="3"
        >
          <v-card class="pa-4 text-center" variant="elevated">
            <v-icon
                :icon="service.icon"
                size="48"
                color="black"
                class="mb-4"
            />
            <h3 class="text-h6 mb-2">{{ service.title }}</h3>
            <p class="text-body-2">{{ service.description }}</p>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </section>
</template>

<script setup lang="ts">
const services = [
  {
    title: 'Umzüge',
    icon: 'mdi-truck-fast',
    description:
        'Zuverlässige Umzüge für Privat- und Firmenkunden – sicher, pünktlich und stressfrei.'
  },
  {
    title: 'Entrümpelungen',
    icon: 'mdi-delete-variant',
    description:
        'Komplette Entrümpelungen von Wohnungen, Häusern und Büros – schnell und diskret.'
  },
  {
    title: 'Lagerung',
    icon: 'mdi-warehouse',
    description:
        'Flexible und sichere Lagerflächen für Möbel, Akten oder komplette Einrichtungen.'
  },
  {
    title: 'Sicherungsposten',
    icon: 'mdi-shield-account',
    description:
        'Ausgebildete Sicherungsposten für Baustellen zur Gewährleistung von Sicherheit vor Ort.'
  }
]
</script>

<style scoped>
.section {
  min-height: 100vh;
  padding: 80px 20px;
}
</style>