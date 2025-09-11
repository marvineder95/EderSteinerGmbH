<template>
  <section id="services" class="section section--center bg-primary">
    <v-container class="services-wrap align-center justify-center text-center">
        <h2 class="services-title">Unsere Leistungen</h2>
        <v-row>
          <v-col
              v-for="service in services"
              :key="service.title"
              cols="12"
              sm="6"
              md="3"
          >
            <v-card class="pa-4 text-center" variant="outlined" min-height="300px">
              <v-icon
                  :icon="service.icon"
                  size="72"
                  color="white"
                  class="mb-4"
              />
              <h3 class="text-h6 mb-2">{{ service.title }}</h3>
              <p class="text-body-2">{{ service.description }}</p>
            </v-card>
          </v-col>
        </v-row>
      <h2 class="services-titleInline mt-8 mb-n8">Firmen mit welchen wir heute schon erfolgreich zusammen arbeiten!</h2>
    </v-container>
  </section>
</template>

<script setup lang="ts">
const services = [
  {
    title: 'Umzüge',
    icon: 'mdi-truck-fast',
    description:
        'Wir bringen Sie sicher an Ihr Ziel – reibungslos, termingerecht und ohne Stress.' +
        ' Ob privat oder geschäftlich: Unser erfahrenes Team sorgt dafür, dass Ihr Umzug entspannt und professionell abläuft.'
  },
  {
    title: 'Entrümpelungen',
    icon: 'mdi-delete-variant',
    description:
        'Mehr Platz. Mehr Klarheit. Wir kümmern uns diskret und effizient um Entrümpelungen aller Art –' +
        ' vom Keller bis zum Bürogebäude – und hinterlassen Räume, die bereit für Neues sind.'
  },
  {
    title: 'Lagerung',
    icon: 'mdi-warehouse',
    description:
        'Sicher, flexibel, jederzeit zugänglich – unsere modernen Lagerflächen bieten den perfekten Platz für Ihre Möbel,' +
        ' Akten oder kompletten Hausrat. Mit uns bleibt alles bestens geschützt und organisiert.'
  },
  {
    title: 'Sicherungsposten',
    icon: 'mdi-shield-account',
    description:
        'Sicherheit, auf die Sie bauen können. Unsere geschulten Sicherungsposten überwachen Baustellen und' +
        ' Verkehrsflächen zuverlässig und sorgen dafür, dass Abläufe geschützt und reibungslos funktionieren.'
  }
]
</script>

<style scoped>
.section--center {
  min-height: 60vh;
  display: flex;
  align-items: center;
}

.services-wrap {
  margin-inline: auto;
  padding-block: 40px;
}

.services-title {
  margin: 0 0 24px;
}

.v-card {
  transition: transform .3s ease, box-shadow .3s ease;
}

.v-card:hover {
  transform: scale(1.05);
  box-shadow: 0 8px 16px rgba(0, 0, 0, .2);
}

</style>