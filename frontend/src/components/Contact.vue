<template>
  <section id="contact" class="section bg-primary">
    <v-container class="align-center justify-center text-center">
      <v-row justify="center">
        <v-col cols="12" md="8" lg="6">
          <v-card class="contact-card" elevation="16" variant="tonal">
            <v-card-text>
              <h2 class="services-title text-center mb-6">Kontakt</h2>

              <!-- Erfolg -->
              <v-expand-transition>
                <div v-if="success" class="text-center py-8">
                  <v-icon size="48" color="white" class="mb-2">mdi-check-circle</v-icon>
                  <div class="text-h6 mb-1">Danke! Wir melden uns in Kürze.</div>
                  <div class="text-body-2 mb-6">Ihre Anfrage wurde erfolgreich übermittelt.</div>

                  <!-- Countdown + Button -->
                  <div class="text-body-2 mb-3" aria-live="polite">
                    Weiterleitung zur Startseite in <strong>{{ countdown }}</strong> Sekunden …
                  </div>
                  <v-btn color="white" variant="outlined" @click="goHome" append-icon="mdi-arrow-right">
                    Zur Startseite
                  </v-btn>
                </div>
              </v-expand-transition>

              <!-- Formular -->
              <v-slide-y-transition>
                <v-form v-if="!success" ref="form" v-model="valid" @submit.prevent="submit">
                  <v-row>
                    <v-col cols="12">
                      <v-text-field
                          v-model="model.name"
                          label="Ihr Name"
                          prepend-inner-icon="mdi-account"
                          variant="outlined"
                          :rules="[r.required]"
                          clearable
                      />
                    </v-col>

                    <v-col cols="12">
                      <v-text-field
                          v-model="model.email"
                          label="E-Mail"
                          prepend-inner-icon="mdi-email"
                          variant="outlined"
                          :rules="[r.required, r.email]"
                          clearable
                      />
                    </v-col>

                    <v-col class="text-left" cols="12">
                      <v-text-field
                          v-model="model.phone"
                          label="Telefonnummer"
                          prepend-inner-icon="mdi-phone"
                          variant="outlined"
                          hint="Optional – für schnellere Rückfragen"
                          persistent-hint
                          clearable
                      />
                    </v-col>

                    <v-col cols="12">
                      <v-select
                          v-model="model.topic"
                          :items="topics"
                          label="Worum geht es?"
                          prepend-inner-icon="mdi-clipboard-text"
                          variant="outlined"
                          :rules="[r.required]"
                          chips
                          clearable
                      />
                    </v-col>

                    <v-col cols="12" sm="6">
                      <v-menu v-model="dateMenu" :close-on-content-click="false" transition="scale-transition">
                        <template #activator="{ props }">
                          <v-text-field
                              v-bind="props"
                              v-model="dateText"
                              label="Wunschtermin"
                              prepend-inner-icon="mdi-calendar"
                              variant="outlined"
                              readonly
                          />
                        </template>
                        <v-date-picker :min="tomorrow" v-model="model.date" @update:model-value="dateMenu=false" />
                      </v-menu>
                    </v-col>

                    <v-col cols="12">
                      <v-textarea
                          v-model="model.message"
                          label="Nachricht"
                          auto-grow
                          rows="4"
                          counter="1000"
                          variant="outlined"
                          :rules="[r.required]"
                          prepend-inner-icon="mdi-text"
                      />
                    </v-col>

                    <v-col class="text-left" cols="12">
                      <v-checkbox
                          v-model="consent"
                          :rules="[v => v || 'Bitte stimmen Sie der Verarbeitung zu.']"
                          :label="`Ich habe die Datenschutzinformationen gelesen und stimme der Verarbeitung meiner Daten zu.`"
                      />
                    </v-col>

                    <v-col cols="12" class="text-center">
                      <v-btn
                          type="submit"
                          color="primary"
                          size="large"
                          :loading="loading"
                          :disabled="!valid || !consent"
                          append-icon="mdi-send"
                      >
                        Absenden
                      </v-btn>
                    </v-col>
                  </v-row>
                </v-form>
              </v-slide-y-transition>
            </v-card-text>
          </v-card>
        </v-col>
      </v-row>

      <!-- Snackbar -->
      <v-snackbar v-model="snack" color="success" timeout="3000" location="top">
        Anfrage gesendet – vielen Dank!
      </v-snackbar>
    </v-container>
  </section>
</template>

<script setup lang="ts">
import { ref, computed, watch, onUnmounted } from 'vue'
import { useRouter } from 'vue-router'

const router = useRouter()

// form state
const form = ref()
const valid = ref(false)
const loading = ref(false)
const success = ref(false)
const consent = ref(false)
const snack = ref(false)

// countdown state (nur nach Erfolg aktiv)
const countdown = ref(5)
let timer: number | undefined

function startRedirectTimer() {
  // Sicherheitsreset
  clearTimer()
  countdown.value = 5
  timer = window.setInterval(() => {
    countdown.value -= 1
    if (countdown.value <= 0) {
      clearTimer()
      goHome()
    }
  }, 1000)
}
function clearTimer() {
  if (timer) {
    clearInterval(timer)
    timer = undefined
  }
}
function goHome() {
  router.push('/')
}

// wenn success -> Timer starten; bei Rückkehr/Unmount abbrechen
watch(success, v => {
  if (v) startRedirectTimer()
})
onUnmounted(clearTimer)

// UI-Daten
const topics = [
  'Umzug (privat)',
  'Umzug (gewerblich)',
  'Entrümpelung',
  'Lagerung',
  'Sicherungsposten',
  'Allgemeine Anfrage'
]

const model = ref({
  name: '',
  email: '',
  phone: '',
  topic: '',
  date: null as string | null,
  message: ''
})

const r = {
  required: (v: any) => !!v || 'Pflichtfeld',
  email: (v: string) =>
      !v || /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(v) || 'Bitte gültige E-Mail eingeben'
}

// DatePicker – keine Vergangenheit
const d = new Date()
d.setDate(d.getDate() + 1)
const tomorrow = d.toISOString().split('T')[0]

const dateMenu = ref(false)
const dateText = computed(() =>
    model.value.date ? new Date(model.value.date).toLocaleDateString() : ''
)

async function submit() {
  const ok = await form.value?.validate()
  if (!ok.valid) return

  loading.value = true
  try {
    // TODO: hier an dein Backend / E-Mail-Service senden
    await new Promise(res => setTimeout(res, 1200))
    loading.value = false
    success.value = true
    snack.value = true
  } catch (e) {
    loading.value = false
    // Optional: Fehlerbehandlung / Snackbar
  }
}
</script>

<style scoped>
.section {
  padding-bottom: 64px;
}

.contact-card {
  border-radius: 20px;
  backdrop-filter: blur(6px);
}

:deep(.v-field__input) {
  min-height: 52px;
}
</style>