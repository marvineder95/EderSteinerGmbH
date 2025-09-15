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
                  v-model="form.token"
                  label="Bewertungs-Code (z. B. ES-7K3Q-2M9A)"
                  prepend-inner-icon="mdi-key-variant"
                  variant="outlined"
                  :rules="[rules.required]"
                  @blur="checkToken"
                  :loading="checking"
                  :error="tokenTouched && !tokenValid"
                  :error-messages="tokenTouched && !tokenValid ? ['Code ungültig oder bereits verwendet'] : []"
                  class="mb-4"
              />

              <v-text-field
                  v-model="form.name"
                  label="Ihr Name (optional, z. B. Frau H.)"
                  prepend-inner-icon="mdi-account"
                  variant="outlined"
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
                  class="mb-6"
              />

              <v-btn
                  :disabled="!valid || !tokenValid || loading"
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
import { reactive, ref, onMounted } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import { useReviewsStore} from "../stores/reviews.ts";

const store = useReviewsStore()
const route = useRoute()
const router = useRouter()

const valid = ref(false)
const loading = ref(false)

const form = reactive({
  token: '',
  name: '',
  rating: 5,
  text: '',
})

const rules = { required: (v: any) => !!v || 'Pflichtfeld' }

const checking = ref(false)
const tokenValid = ref(false)
const tokenTouched = ref(false)

const snack = reactive({ ok: false, err: false })
const errorMsg = ref('')

onMounted(async () => {
  const qp = (route.query.code as string) || ''
  if (qp) {
    form.token = qp.toUpperCase()
    await checkToken()
  }
})

async function checkToken() {
  tokenTouched.value = true
  if (!form.token) { tokenValid.value = false; return }
  checking.value = true
  try {
    tokenValid.value = await store.validateToken(form.token)
  } catch {
    tokenValid.value = false
  } finally {
    checking.value = false
  }
}

async function submit() {
  try {
    loading.value = true
    await store.createReview({
      token: form.token.trim().toUpperCase(),
      name : form.name?.trim() || undefined,
      rating: form.rating,
      text: form.text.trim(),
    })
    snack.ok = true
    setTimeout(() => router.push('/reviews'), 800)
  } catch (e: any) {
    errorMsg.value = e?.response?.data?.message || 'Senden fehlgeschlagen.'
    snack.err = true
  } finally {
    loading.value = false
  }
}
</script>

<style scoped>
.review-card { border-radius: 16px; backdrop-filter: blur(6px); }
</style>