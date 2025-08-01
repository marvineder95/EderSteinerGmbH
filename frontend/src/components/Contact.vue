<template>
  <section id="contact" class="section">
    <v-container max-width="700px">
      <h2 class="text-h4 mb-6 text-center">Kontakt</h2>
      <v-form v-model="valid" ref="formRef">
        <v-text-field
            v-model="form.name"
            label="Ihr Name"
            :rules="[rules.required]"
            variant="outlined"
            class="mb-4"
        />
        <v-text-field
            v-model="form.email"
            label="E-Mail"
            :rules="[rules.required, rules.email]"
            variant="outlined"
            class="mb-4"
        />
        <v-text-field
            v-model="form.phone"
            label="Telefonnummer"
            variant="outlined"
            class="mb-4"
        />
        <v-textarea
            v-model="form.message"
            label="Nachricht"
            :rules="[rules.required]"
            variant="outlined"
            rows="5"
            class="mb-4"
        />
        <div class="text-center">
          <v-btn color="black" size="large" @click="submit">Absenden</v-btn>
        </div>
      </v-form>
    </v-container>
  </section>
</template>

<script setup lang="ts">
import { ref } from 'vue'

const valid = ref(false)
const formRef = ref()

const form = ref({
  name: '',
  email: '',
  phone: '',
  message: ''
})

const rules = {
  required: (value: string) => !!value || 'Pflichtfeld',
  email: (value: string) => {
    const pattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/
    return pattern.test(value) || 'Bitte gültige E-Mail eingeben'
  }
}

function submit() {
  if (!formRef.value) return
  formRef.value.validate().then((success: boolean) => {
    if (success) {
      console.log('Formular abgesendet:', form.value)
      // Später hier: API Call an dein Spring Boot Backend
      alert('Vielen Dank für Ihre Nachricht! Wir melden uns bald bei Ihnen.')
    }
  })
}
</script>

<style scoped>
.section {
  min-height: 100vh;
  padding: 80px 20px;
}
</style>