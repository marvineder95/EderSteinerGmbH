<template>
  <section id="services" class="section bg-primary">
    <v-container class="services-wrap align-center justify-center text-center">
      <h2 class="services-title mb-5">Über uns</h2>

      <!-- Team -->
      <v-row justify="center" class="mb-12">
        <v-col
            v-for="person in team"
            :key="person.name"
            cols="12"
            md="6"
        >
          <v-card variant="outlined" class="person-card bg-primary" rounded="xl">
            <v-img :src="person.image" height="220" class="mt-5" />

            <div class="person-content">
              <h3 class="person-name">{{ person.name }}</h3>
              <div class="person-role">{{ person.role }}</div>

              <p class="person-text">
                {{ person.text }}
              </p>

              <div class="person-tags" aria-label="Schwerpunkte">
                <v-chip v-for="(tag, i) in person.points" :key="`${person.name}-${i}`" class="person-chip" variant="outlined" size="small">
                  {{ tag }}
                </v-chip>
              </div>
            </div>
          </v-card>
        </v-col>
      </v-row>

      <!-- Werte / Statement -->
      <v-row justify="center">
        <v-col cols="12" md="10">
          <v-card variant="outlined" class="values-card" elevation="3" rounded="xl">
            <h3 class="values-title">Unsere Arbeitsweise</h3>

            <p class="values-text">
              Für uns bedeutet ein Auftrag mehr, als Dinge von A nach B zu bringen.
              Wir stehen für saubere Arbeit, transparente Angebote und einen respektvollen Umgang
              mit Ihrem Eigentum.
            </p>

            <v-row class="values-grid">
              <v-col cols="12" sm="6">
                <div class="value-item">
                  <v-icon icon="mdi-check-circle-outline" />
                  <span>Zuverlässig & termingerecht</span>
                </div>
              </v-col>

              <v-col cols="12" sm="6">
                <div class="value-item">
                  <v-icon icon="mdi-cash-check" />
                  <span>Transparente Pauschalangebote</span>
                </div>
              </v-col>

              <v-col cols="12" sm="6">
                <div class="value-item">
                  <v-icon icon="mdi-package-variant-closed" />
                  <span>Sorgfältiger Umgang mit Ihrem Eigentum</span>
                </div>
              </v-col>

              <v-col cols="12" sm="6">
                <div class="value-item">
                  <v-icon icon="mdi-account-group-outline" />
                  <span>Persönliche Ansprechpartner</span>
                </div>
              </v-col>
            </v-row>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </section>
</template>

<script setup lang="ts">
type TeamMember = {
  name: string
  role: string
  image: string
  text: string
  points: string[]
}

const team: TeamMember[] = [
  {
    name: 'Thomas Steiner',
    role: 'Gesellschafter',
    image: '/images/SteinerBild.png',
    text:
        'Mit jahrelanger Erfahrung im Bereich Umzüge und Logistik sorgt Thomas für strukturierte Abläufe, verlässliche Planung und eine saubere Umsetzung.',
    points: ['Organisation & Ablaufplanung', 'Logistik & Transport', 'Termintreue']
  },
  {
    name: 'Marvin Eder',
    role: 'Geschäftsführer',
    image: '/images/EderBild.png',
    text:
        'Marvin ist Ihr direkter Ansprechpartner – von der ersten Anfrage bis zur Umsetzung. Klar, lösungsorientiert und immer erreichbar.',
    points: ['Kundenbetreuung', 'Angebotserstellung', 'Qualitätssicherung']
  }
]
</script>

<style scoped>
/* Team Cards */
.person-card {
  height: 100%;
  display: flex;
  flex-direction: column;
  background: rgba(255, 255, 255, 0.92);
  backdrop-filter: blur(6px);
}

.person-content {
  padding: 20px;
  display: flex;
  flex-direction: column;
  flex-grow: 1;
}

.person-name {
  font-size: 18px;
  font-weight: 700;
  margin-bottom: 4px;
}

.person-role {
  font-size: 13px;
  opacity: 0.75;
  margin-bottom: 12px;
}

.person-text {
  font-size: 14px;
  margin-bottom: 14px;
}

.person-tags {
  display: flex;
  flex-wrap: wrap;
  gap: 8px;
  margin-top: 10px;
  justify-content: center; /* horizontal zentrieren */
}

.person-chip {
  font-size: 12.5px;
  font-weight: 600;
  opacity: 0.95;
}

/* Werte */
.values-card {
  padding: 28px;
}

.values-title {
  font-size: 18px;
  font-weight: 700;
  margin-bottom: 10px;
}

.values-text {
  margin-bottom: 20px;
}

.value-item {
  display: flex;
  align-items: center;
  gap: 10px;
  font-size: 14px;
}
</style>