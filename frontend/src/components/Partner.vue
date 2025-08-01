<template>
  <section id="partners" class="section">
    <v-container fluid class="pa-0 partners-banner">
      <div class="partners-slider">
        <!-- Erste Liste -->
        <div
            v-for="(partner, index) in partners"
            :key="'first-' + index"
            class="partner-card"
        >
          <v-card class="pa-4 d-flex align-center justify-center" elevation="2">
            <v-img
                :src="partner.logo"
                max-width="120"
                max-height="60"
                contain
            />
          </v-card>
        </div>

        <!-- Zweite Liste (Duplikat für Endlos-Loop) -->
        <div
            v-for="(partner, index) in partners"
            :key="'second-' + index"
            class="partner-card"
        >
          <v-card class="pa-4 d-flex align-center justify-center" elevation="2">
            <v-img
                :src="partner.logo"
                max-width="120"
                max-height="60"
                contain
            />
          </v-card>
        </div>
      </div>
    </v-container>
  </section>
</template>

<script setup lang="ts">
const partners = [
  { logo: '/images/BoxroomLogo.png' },
  { logo: '/images/Wirth&KollLogo.png' },
  { logo: '/images/WohnfeeLogo.png' },
  { logo: '/images/partner4.png' },
  { logo: '/images/partner5.png' },
]
</script>

<style scoped>
.partners-banner {
  background-color: #f9f9f9;
  overflow: hidden;
  height: 200px;
  position: relative;
}

.partners-slider {
  display: flex;
  gap: 24px;
  width: max-content;
  animation: scroll-left 25s linear infinite;
}

.partner-card {
  flex: 0 0 auto;
  width: 200px;
}

.partners-banner:hover .partners-slider {
  animation-play-state: paused;
}

@keyframes scroll-left {
  0% {
    transform: translateX(0);
  }
  100% {
    transform: translateX(-50%);
  }
}
</style>