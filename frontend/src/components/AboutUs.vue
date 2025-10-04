<template>
  <section id="about" class="section bg-white">
    <v-container class="d-flex justify-center align-center text-center">
      <v-card class="about-card" color="primary" elevation="10">
        <v-card-text class="scrollable-content">
          <h2 class="services-title text-center mb-8">Über uns</h2>

          <v-row class="justify-center align-center mb-10">
            <v-col cols="12" md="6">
              <v-card elevation="2" class="pa-4" rounded="xl">
                <v-img
                    src="/images/SteinerBild.png"
                    aspect-ratio="1"
                    class="mb-4"
                />
                <h3 class="text-h6 mb-2">Thomas Steiner</h3>
                <p class="text-body-2">
                  Geschäftsführer – Mit jahrelanger Erfahrung im Bereich Umzüge und Logistik
                  kümmert er sich um reibungslose Abläufe und zufriedene Kunden.
                </p>
              </v-card>
            </v-col>

            <v-col cols="12" md="6">
              <v-card elevation="2" class="pa-4" rounded="xl">
                <v-img
                    src="/images/EderBild.png"
                    aspect-ratio="1"
                    class="mb-4"
                />
                <h3 class="text-h6 mb-2">Marvin Eder</h3>
                <p class="text-body-2">
                  Geschäftsführer – Organisiert, motiviert und immer nah an den Kundenwünschen,
                  sorgt er für Qualität und eine persönliche Betreuung.
                </p>
              </v-card>
            </v-col>
          </v-row>

          <v-row class="justify-center">
            <v-col cols="12" md="10">
              <p class="text-body-1">
                Gemeinsam stehen wir hinter der Eder & Steiner GmbH. Für uns bedeutet ein Auftrag mehr,
                als nur Dinge von A nach B zu bringen. Wir wollen unseren Kunden das Gefühl geben,
                in den besten Händen zu sein – mit Zuverlässigkeit, Sorgfalt und Respekt.
              </p>
            </v-col>
          </v-row>
        </v-card-text>
      </v-card>
    </v-container>
  </section>
</template>

<style scoped>
.section {
  min-height: 80vh;
  display: flex;
  align-items: center;
}

.about-card {
  max-width: 1000px;
  width: 100%;
  max-height: 70vh; /* Höhe begrenzen, damit man scrollen kann */
  border-radius: 20px;
  overflow: hidden; /* Scrollbar nur im Inneren */
}

</style>