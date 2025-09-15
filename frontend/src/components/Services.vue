<template>
  <section id="services" class="section bg-primary">
    <v-container class="services-wrap align-center justify-center text-center">
      <h2 class="services-title">Unsere Leistungen</h2>
      <v-row>
        <v-col
            v-for="service in services"
            :key="service.slug"
            cols="12"
            sm="6"
            md="3"
        >
          <!-- v-card kann direkt als Router-Link verwendet werden -->
          <v-card
              class="pa-4 d-flex flex-column align-center justify-center text-center service-card"
              variant="outlined"
              min-height="400"
              :to="{ name: 'service-detail', params: { slug: service.slug } }"
              hover
          >
            <v-icon :icon="service.icon" size="72" color="white" class="mb-4" />
            <h3 class="text-h6 mb-2">{{ service.title }}</h3>
            <p class="text-body-2">{{ service.description }}</p>

            <v-btn variant="text" class="mt-3" append-icon="mdi-arrow-right">
              Mehr erfahren
            </v-btn>
          </v-card>
        </v-col>
      </v-row>

      <h2 class="services-titleInline mt-8">
        Firmen mit welchen wir heute schon erfolgreich zusammen arbeiten!
      </h2>
    </v-container>

    <Partner />
  </section>
</template>

<script setup lang="ts">
import Partner from './Partner.vue'

const services = [
  {
    slug: 'umzuege',
    title: 'Umzüge',
    icon: 'mdi-truck-fast',
    description:
        'Wir bringen Sie sicher an Ihr Ziel – reibungslos, termingerecht und ohne Stress. Ob privat oder geschäftlich: Unser erfahrenes Team sorgt dafür, dass Ihr Umzug entspannt und professionell abläuft.'
  },
  {
    slug: 'entruempelungen',
    title: 'Entrümpelungen',
    icon: 'mdi-dump-truck',
    description:
        'Mehr Platz. Mehr Klarheit. Wir kümmern uns diskret und effizient um Entrümpelungen aller Art – vom Keller bis zum Bürogebäude – und hinterlassen Räume, die bereit für Neues sind.'
  },
  {
    slug: 'lagerung',
    title: 'Lagerung',
    icon: 'mdi-warehouse',
    description:
        'Sicher, flexibel, jederzeit zugänglich – unsere modernen Lagerflächen bieten den perfekten Platz für Ihre Möbel, Akten oder kompletten Hausrat. Mit uns bleibt alles bestens geschützt und organisiert.'
  },
  {
    slug: 'sicherungsposten',
    title: 'Sicherungsposten',
    icon: 'mdi-shield-account',
    description:
        'Unsere geschulten Sicherungsposten überwachen Baustellen und Verkehrsflächen zuverlässig und sorgen dafür, dass Abläufe geschützt und reibungslos funktionieren.'
  }
]
</script>

<style scoped>
.section {
  min-height: 80vh;
}

/* kleines UX-Detail: „klickbar“-Cursor auf Karten */
.service-card {
  cursor: pointer;
}
</style>