<template>
  <section id="about" class="section bg-white">
    <v-container class="text-center">
      <h2 class="titleDesign text-primary">Über uns</h2>
      <p class="text-subtitle-1 mb-12">
        Persönlich. Zuverlässig. Mit Leidenschaft für unseren Beruf.
      </p>

      <v-row class="justify-center align-center mb-10">
        <v-col cols="12" md="4">
          <v-card elevation="2" class="pa-4">
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

        <v-col cols="12" md="4">
          <v-card elevation="2" class="pa-4">
            <v-img
                src="/images/EderBild.png"
                aspect-ratio="1"
                class="mb-4"
                cover
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
        <v-col cols="12" md="8">
          <p class="text-body-1">
            Gemeinsam stehen wir hinter der Eder & Steiner GmbH. Für uns bedeutet ein Auftrag mehr,
            als nur Dinge von A nach B zu bringen. Wir wollen unseren Kunden das Gefühl geben,
            in den besten Händen zu sein – mit Zuverlässigkeit, Sorgfalt und Respekt.
          </p>
        </v-col>
      </v-row>
    </v-container>
  </section>
</template>

<style scoped>
.section {
  min-height: 100vh;
  padding: 80px 20px;
}

.titleDesign {
  font-size: 2.5rem; /* größer */
  font-weight: 700; /* fett */
  text-align: center;
  position: relative;
  display: inline-block;
  padding-bottom: 10px;
}

.titleDesign::after {
  content: "";
  display: block;
  width: 80%;
  margin: auto;
  border-bottom: 3px solid #000000; /* Vuetify-Primärfarbe */
  border-radius: 2px;
}
</style>