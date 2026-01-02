<template>
  <section class="section bg-primary">
    <v-container class="text-center">
      <h2 class="services-title mb-6">Bewertung abgeben</h2>
      <p class="mb-8">Sie haben unseren Service genutzt? Vielen Dank! Mit Ihrem individuellen Code können Sie eine verifizierte Bewertung hinterlassen.</p>

      <v-row justify="center">
        <v-col cols="12" md="7" lg="6">
          <v-card elevation="12" class="pa-6 review-card" variant="tonal">
            <v-form v-model="valid" @submit.prevent="submit">
              <v-text-field
                  v-model="form.code"
                  label="Bewertungs-Code (z. B. ES-7K3Q-2M9A)"
                  prepend-inner-icon="mdi-key-variant"
                  variant="outlined"
                  :error-messages="fieldError ? [fieldError] : []"
                  autocomplete="off"
                  class="mb-4"
              />

              <v-text-field
                  v-model="form.name"
                  label="Ihr Name (optional, z. B. Frau H.)"
                  prepend-inner-icon="mdi-account"
                  variant="outlined"
                  autocomplete="off"
                  class="mb-4"
              />

              <div class="mb-2 text-left font-medium">Ihre Bewertung</div>
              <v-rating v-model="form.rating" length="5" hover size="28" color="amber" class="mb-4"/>

              <v-textarea
                  v-model="form.text"
                  label="Ihre Erfahrung"
                  auto-grow
                  variant="outlined"
                  counter="800"
                  :rules="[rules.required]"
                  prepend-inner-icon="mdi-text"
                  autocomplete="off"
                  class="mb-6"
              />

              <v-btn
                  :disabled="!valid || loading"
                  :loading="loading"
                  color="white"
                  variant="outlined"
                  type="submit"
                  append-icon="mdi-send"
              >
                Bewertung senden
              </v-btn>
            </v-form>
          </v-card>

          <div class="mt-8">
            <v-btn variant="outlined" color="white" @click="$router.push('/reviews')" append-icon="mdi-arrow-right">
              Zu den Kundenstimmen
            </v-btn>
          </div>
        </v-col>
      </v-row>

      <v-snackbar v-model="snack.ok" color="success" timeout="3000">Danke! Ihre Bewertung wurde gespeichert.</v-snackbar>
      <v-snackbar v-model="snack.err" color="error" :timeout="5000">{{ errorMsg }}</v-snackbar>
    </v-container>
  </section>
</template>

<script setup lang="ts">
import { reactive, ref} from 'vue'
import { useRouter } from 'vue-router'
import { useReviewsStore} from "../stores/reviews.ts";

const store = useReviewsStore()
const router = useRouter()

const valid = ref(false)
const loading = ref(false)

const form = reactive({
  code: '',
  name: '',
  rating: 5,
  text: '',
})

const rules = { required: (v: any) => !!v || 'Pflichtfeld' }

const fieldError = ref<string>('')

const snack = reactive({ ok: false, err: false })
const errorMsg = ref<string>('')

async function submit() {
  try {
    loading.value = true
    fieldError.value = ''
    await store.create({
      code: form.code.trim().toUpperCase(),
      name : form.name.trim(),
      rating: form.rating,
      text: form.text.trim(),
    })
    snack.ok = true
    setTimeout(() => router.push('/reviews'), 800)
  } catch (e: any) {
    const status = e?.response?.status
    const reason = e?.response?.data?.reason || e?.response?.data?.error
    if (status === 400 && (reason === 'INVALID_CODE' || reason === 'CODE_USED' || reason === 'CODE_EXPIRED')) {
      fieldError.value = 'Code ungültig oder bereits verwendet'
    } else {
      errorMsg.value = e?.response?.data?.message || 'Senden fehlgeschlagen.'
      snack.err = true
    }
  } finally {
    loading.value = false
  }
}
</script>

<style scoped>
.review-card { border-radius: 16px; backdrop-filter: blur(6px); }
</style>