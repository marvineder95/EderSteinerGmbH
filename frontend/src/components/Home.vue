<template>
  <div class="hero" id="home">
    <div class="overlay">
      <div class="hero-content">
        <h1 class="mt-8">Bewegen. Räumen. Lagern. – Ihr Partner für Umzüge & Entrümpelungen.</h1>
        <v-btn @click="scrollToContact" color="primary" class="mt-6" size="large">
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
  height: 100%;
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
  background: rgba(0, 0, 0, 0.6); /* dunkler Filter */
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
  font-size: 1.5rem;
  line-height: 1.4;
}
</style>