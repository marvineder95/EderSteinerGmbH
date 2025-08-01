<template>
  <section id="partners" class="section">
    <v-container fluid class="pa-0 partners-banner">
      <div class="partners-slider">
        <div
            v-for="(partner, index) in partners"
            :key="'first-' + index"
            class="partner-card"
        >
          <v-card class="pa-4 d-flex align-center justify-center" elevation="2">
            <v-img
                :src="partner.logo"
                width="180"
                height="100"
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
                width="180"
                height="100"
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
  { logo: '/images/Wirth&KollLogo.png' },
  { logo: '/images/BoxroomLogo.png' },
  { logo: '/images/WohnfeeLogo.png' },
  { logo: '/images/sincetodayLogo.png' },
  { logo: '/images/partner5.png' },
]
</script>

<style scoped>
.partners-banner {
  background-color: #ffffff;
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