<template>
  <div class="hero" id="home">
    <div class="overlay">
      <div class="hero-content">
        <p class="mt-8 hero-text">Bewegen. Räumen. Lagern. – Ihr Partner für Umzüge & Entrümpelungen.</p>
        <v-btn variant="outlined" @click="scrollToContact" color="white" class="mt-6"  append-icon="mdi-arrow-right">
          Kostenloses Angebot anfordern
        </v-btn>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
function scrollToContact() {
  const contactSection = document.getElementById('contact')
  if (contactSection) {
    contactSection.scrollIntoView({ behavior: 'smooth' })
  }
}
</script>

<style scoped>
.hero {
  position: relative;
  min-height: 75vh;
  width: 100vw;
  background-image: url('/images/backGroundImgLkwInGreen.png');
  background-size: cover;
  background-position: center;
}

.overlay {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.7); /* dunkler Filter */
  display: flex;
  align-items: center;
  justify-content: center;
}

.hero-content {
  color: white;
  text-align: center;
}

.hero-content h1 {
  font-size: 3rem;
  margin-bottom: 20px;
  font-weight: bold;
}

.hero-content p {
  line-height: 1.4;
}

.hero-text {
  font-size: 1.5rem;
  font-weight: 600;
  letter-spacing: 1px;
}

@media (min-width: 600px) {
  .hero-text {
    font-size: 1.5rem;
  }
}

@media (min-width: 800px) {
  .hero-text {
    font-size: 2.5rem;
    font-weight: 700;
    text-shadow: 0 2px 4px rgba(0,0,0,0.6);
  }
}
</style>