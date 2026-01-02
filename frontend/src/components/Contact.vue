<template>
  <section id="services" class="section bg-primary">
    <v-container class="services-wrap align-center justify-center text-center">
      <h2 class="services-title mb-5">Kontakt</h2>
      <v-row justify="center">
        <v-col cols="12" md="8" lg="6">
          <v-card class="contact-card" variant="outlined" rounded="xl">
            <v-card-text class="contact-inner">

              <!-- Fehler -->
              <v-expand-transition>
                <v-alert
                    v-if="errText && !success"
                    type="error"
                    variant="tonal"
                    class="mb-4 text-left"
                    :text="errText"
                />
              </v-expand-transition>

              <!-- Erfolg -->
              <v-expand-transition>
                <div v-if="success" class="success-wrap">
                  <v-icon size="54" icon="mdi-check-circle-outline" class="mb-2" />
                  <div class="text-h6 mb-1">Danke! Wir melden uns in Kürze.</div>
                  <div class="text-body-2 mb-6">Ihre Anfrage wurde erfolgreich übermittelt.</div>

                  <div class="text-body-2 mb-3" aria-live="polite">
                    Weiterleitung zur Startseite in <strong>{{ countdown }}</strong> Sekunden …
                  </div>

                  <v-btn
                      color="white"
                      variant="outlined"
                      class="btn-cta"
                      @click="goHome"
                      append-icon="mdi-arrow-right"
                  >
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
                          autocomplete="off"
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
                          autocomplete="off"
                      />
                    </v-col>

                    <v-col cols="12" class="text-left">
                      <v-text-field
                          v-model="model.phone"
                          label="Telefonnummer"
                          prepend-inner-icon="mdi-phone"
                          variant="outlined"
                          hint="Optional – für schnellere Rückfragen"
                          persistent-hint
                          clearable
                          autocomplete="off"
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
                        <v-date-picker :min="tomorrow" v-model="model.date" @update:model-value="dateMenu = false" />
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
                          autocomplete="off"
                      />
                    </v-col>

                    <v-col cols="12" class="text-left">
                      <v-checkbox
                          v-model="consent"
                          :rules="[v => v || 'Bitte stimmen Sie der Verarbeitung zu.']"
                          label="Ich habe die Datenschutzinformationen gelesen und stimme der Verarbeitung meiner Daten zu."
                      />
                    </v-col>

                    <v-col cols="12" class="text-center">
                      <v-btn
                          type="submit"
                          color="white"
                          variant="outlined"
                          size="large"
                          class="btn-cta"
                          :loading="loading"
                          :disabled="loading || !valid || !consent"
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

      <!-- Snackbars -->
      <v-snackbar v-model="snack" color="success" timeout="3000" location="top">
        Anfrage gesendet – vielen Dank!
      </v-snackbar>

      <v-snackbar v-model="errorSnack" color="error" timeout="4000" location="top">
        {{ errText }}
      </v-snackbar>
    </v-container>
  </section>
</template>

<script setup lang="ts">
import { ref, computed, watch, onUnmounted } from 'vue'
import { useRouter } from 'vue-router'
import { useContactStore } from '../stores/contact'

const router = useRouter()
const contact = useContactStore()

const form = ref<any>()
const valid = ref(false)
const consent = ref(false)

const loading = computed(() => contact.sending)
const success = computed(() => contact.ok)

const errText = computed(() => {
  const msg = contact.error
  if (!msg) return null
  const m = msg.toLowerCase()
  if (m.includes('too many') || m.includes('rate')) return 'Zu viele Anfragen. Bitte warte kurz und versuche es erneut.'
  return msg
})

const snack = ref(false)
const errorSnack = ref(false)

const countdown = ref(5)
let timer: number | undefined

function clearTimer() {
  if (timer) {
    clearInterval(timer)
    timer = undefined
  }
}
function goHome() {
  router.push('/')
}
function startRedirectTimer() {
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

watch(success, (v) => {
  if (v) {
    snack.value = true
    startRedirectTimer()
  }
})

watch(errText, (v) => {
  if (v && !success.value) errorSnack.value = true
})

onUnmounted(() => {
  clearTimer()
  contact.reset()
})

const topics = ['Umzug (privat)', 'Umzug (gewerblich)', 'Entrümpelung', 'Lagerung', 'Allgemeine Anfrage']

const model = ref({
  name: '',
  email: '',
  phone: '',
  topic: '',
  date: null as string | null,
  message: '',
})

const r = {
  required: (v: any) => !!v || 'Pflichtfeld',
  email: (v: string) => !v || /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(v) || 'Bitte gültige E-Mail eingeben',
}

const d = new Date()
d.setDate(d.getDate() + 1)
const tomorrow = d.toISOString().split('T')[0]

const dateMenu = ref(false)
const dateText = computed(() => (model.value.date ? new Date(model.value.date).toLocaleDateString() : ''))

async function submit() {
  const res = await form.value?.validate()
  if (!res?.valid) return

  await contact.send({
    name: model.value.name,
    email: model.value.email,
    phone: model.value.phone || undefined,
    topic: model.value.topic,
    date: model.value.date,
    message: model.value.message,
  })
}
</script>

<style scoped>
.section {
  min-height: 80vh;
  display: flex;
  align-items: center;
}

/* Breite wie About/Services */
.contact-wrap {
  max-width: 1100px;
}

/* Card wie Team-Cards: leichtes „Glass“-Feeling aber im grünen Stil */
.contact-card {
  height: 100%;
  background: rgba(255, 255, 255, 0.12);
  backdrop-filter: blur(6px);
}

/* Innenabstand + gute Lesbarkeit */
.contact-inner {
  padding: 28px;
}

/* Success Layout */
.success-wrap {
  text-align: center;
  padding: 28px 0 10px;
}

/* CTA Buttons im Stil */
.btn-cta {
  border-width: 2px;
}

/* Optional: ein bisschen „ruhiger“ wirken lassen */
:deep(.v-field) {
  border-radius: 14px;
}
</style>