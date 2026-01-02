<template>
  <section class="section bg-primary">
    <v-container class="reviews-wrap align-center justify-center">
      <div class="d-flex align-center justify-space-between mb-6 flex-wrap ga-3">
        <h1 class="services-title mb-0">Kundenstimmen</h1>

        <div class="d-flex ga-2">
          <v-btn
              color="white"
              variant="outlined"
              append-icon="mdi-plus"
              @click="$router.push('/reviews/new')"
          >
            Bewertung schreiben
          </v-btn>
        </div>
      </div>

      <!-- Fehler -->
      <v-alert
          v-if="store.error"
          type="error"
          variant="tonal"
          class="mb-6"
      >
        {{ store.error }}
        <template #append>
          <v-btn size="small" variant="text" @click="reload">Erneut versuchen</v-btn>
        </template>
      </v-alert>

      <!-- Leerzustand -->
      <v-alert
          v-if="!store.loading && !store.error && store.list.length === 0"
          color="white"
          variant="tonal"
          class="mb-6"
      >
        Noch keine Bewertungen vorhanden. Sei die/der Erste!
      </v-alert>

      <!-- Liste -->
      <v-row v-if="store.list.length" align="stretch">
        <v-col
            v-for="r in store.list"
            :key="r.id ?? r.createdAt"
            cols="12"
            sm="6"
            md="4"
            lg="3"
        >
          <v-card class="h-100 d-flex flex-column" variant="outlined">
            <v-card-text class="pb-1">
              <div class="d-flex align-center justify-space-between mb-2">
                <div class="text-subtitle-1 font-weight-600">
                  {{ r.name || 'Anonym' }}
                </div>
                <div class="text-caption text-medium-emphasis">
                  {{ formatDate(r.createdAt) }}
                </div>
              </div>

              <v-rating
                  :model-value="r.rating"
                  color="amber"
                  density="compact"
                  size="18"
                  readonly
              />

              <p class="mt-3 mb-0 text-body-2">
                {{ r.text }}
              </p>
            </v-card-text>

            <v-spacer />

            <!-- Optionaler Footer, z.B. Herkunft -->
            <v-card-actions class="pt-0">
              <v-chip
                  v-if="r.source"
                  size="small"
                  label
                  class="ms-n1"
                  variant="text"
              >
                {{ r.source }}
              </v-chip>
            </v-card-actions>
          </v-card>
        </v-col>
      </v-row>

      <!-- Paginator / Load more -->
      <div class="text-center mt-8">
        <v-btn
            v-if="hasMore"
            color="white"
            variant="outlined"
            :loading="store.loading"
            append-icon="mdi-chevron-down"
            @click="loadMore"
        >
          Mehr laden
        </v-btn>
      </div>

      <!-- Progress beim ersten Laden -->
      <div v-if="store.loading && store.list.length === 0" class="text-center mt-8">
        <v-progress-circular indeterminate size="36" />
      </div>
    </v-container>
  </section>
</template>

<script setup lang="ts">
import { onMounted, computed } from 'vue'
import { useReviewsStore} from "../stores/reviews.ts";
const store = useReviewsStore()

onMounted(() => {
  // erste Seite laden
  store.fetchPage(0)
})

const hasMore = computed(() => store.page < store.totalPages - 1)

function reload() {
  store.fetchPage(0)
}

function loadMore() {
  if (store.loading || !hasMore.value) return
  store.fetchPage(store.page + 1)
}

function formatDate(d?: string | Date) {
  if (!d) return ''
  const date = typeof d === 'string' ? new Date(d) : d
  try {
    return new Intl.DateTimeFormat('de-AT', {
      day: '2-digit',
      month: '2-digit',
      year: 'numeric'
    }).format(date)
  } catch {
    return ''
  }
}
</script>

<style scoped>
.section{
  min-height: 80vh;
}
.reviews-wrap {
  max-width: 1200px;
}
</style>