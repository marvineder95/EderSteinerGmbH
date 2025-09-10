<template>
  <v-footer class="bg-primary text-center" height="auto">
    <v-container class="footerValues">
      <v-row justify="center">
        <v-col cols="12" md="8">
          <div class="mb-4">
            <strong>Eder & Steiner GmbH</strong>
          </div>
          <v-row justify="center" no-gutters class="mb-4">
            <v-col cols="auto" class="px-3">
              <router-link to="/impressum" class="footer-link">Impressum</router-link>
            </v-col>
            <v-col cols="auto" class="px-3">
              <a href="#!" class="footer-link">AGB</a>
            </v-col>
            <v-col cols="auto" class="px-3">
              <a href="#!" class="footer-link">Datenschutz</a>
            </v-col>
          </v-row>
          <div class="text-body-2 mb-2">
            Kontakt: info@eder-steiner.at | Tel.: +43 660 1234567
          </div>
          <div class="text-caption">
            © {{ new Date().getFullYear() }} Eder & Steiner GmbH – Alle Rechte vorbehalten.
          </div>
        </v-col>
      </v-row>
    </v-container>
  </v-footer>
</template>

<script setup lang="ts">
</script>

<style scoped>
.footerValues {
  height: 18vh;
}
.footer-link {
  text-decoration: underline;
  color: inherit;
  font-weight: 500;
}

.footer-link:hover {
  text-decoration: underline;
  font-weight: 600;
}
</style>