<template>
  <section class="partners-banner">
    <v-container class="h-100 d-flex align-center">
      <div class="partners-slider" :class="{'reduce-motion': prefersReducedMotion}">
        <div v-for="(p,i) in partnersDoubled" :key="i" class="partner-card">
          <v-card variant="text" class="pa-4 d-flex align-center justify-center" elevation="2" :href="p.url"
          target="_blank"
          rel="noopener noreferrer"
          :aria-label="`Partner: ${p.name}`">
            <v-img
                :src="p.logo"
                :alt="p.name"
                width="160" height="90"
                lazy-src="/images/placeholder-logo.png"
                cover
            />
          </v-card>
        </div>
      </div>
    </v-container>
  </section>
</template>

<script setup lang="ts">
const partners = [
  { name: 'Wirth & Koll', logo: '/images/Wirth&KollLogo.png', url: 'https://www.wirthundkoll.at' },
  { name: 'Boxroom',      logo: '/images/BoxroomLogo.png',    url: 'https://boxroom.at' },
  { name: 'Wohnfee',      logo: '/images/WohnfeeLogo.png',    url: 'https://www.wohnfee.at' },
  { name: 'sinceToday',   logo: '/images/sincetodayLogo.png', url: 'https://www.sincetoday.at' },
]
const partnersDoubled = [...partners, ...partners]
const prefersReducedMotion = window.matchMedia('(prefers-reduced-motion: reduce)').matches
</script>

<style scoped>
.partners-banner{ background:#fff; height:120px; overflow:hidden }
.partners-slider{ display:flex; gap:24px; width:max-content; animation:scroll 25s linear infinite }
.partners-slider.reduce-motion{ animation:none }
.partner-card{ flex:0 0 auto; width:200px }
@keyframes scroll{
  from{ transform: translateX(0) }
  to  { transform: translateX(-50%) }
}
</style>