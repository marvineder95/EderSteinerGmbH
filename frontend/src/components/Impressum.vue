<template>
  <section id="services" class="section bg-primary">
    <v-container class="services-wrap align-center justify-center text-center">
      <h2 class="services-title mb-5">Impressum</h2>

      <v-row justify="center">
        <v-col cols="12" md="10" lg="8">
          <v-card class="glass-card" variant="outlined" rounded="xl">
            <v-card-text class="card-inner">
              <div class="block">
                <div class="block-title">Eder &amp; Steiner GmbH</div>

                <div class="lines">
                  <div>Obersdorferstraße 5</div>
                  <div>2201 Seyring</div>
                  <div>Österreich</div>
                </div>
              </div>

              <v-divider class="my-6" />

              <div class="grid">
                <div class="item">
                  <v-icon icon="mdi-phone" class="ic" />
                  <div>
                    <div class="label">Telefon</div>
                    <div class="value">+43 660 977 81 57</div>
                  </div>
                </div>

                <div class="item">
                  <v-icon icon="mdi-email" class="ic" />
                  <div>
                    <div class="label">E-Mail</div>
                    <div class="value">office@es-gmbh.at</div>
                  </div>
                </div>

                <div class="item">
                  <v-icon icon="mdi-file-document-outline" class="ic" />
                  <div>
                    <div class="label">Firmenbuchnummer</div>
                    <div class="value">FN 665860 g</div>
                  </div>
                </div>

                <div class="item">
                  <v-icon icon="mdi-scale-balance" class="ic" />
                  <div>
                    <div class="label">Firmenbuchgericht</div>
                    <div class="value">Landesgericht Korneuburg</div>
                  </div>
                </div>

                <div class="item">
                  <v-icon icon="mdi-card-account-details-outline" class="ic" />
                  <div>
                    <div class="label">UID-Nummer</div>
                    <div class="value">ATU82726169</div>
                  </div>
                </div>
              </div>

              <!-- optionaler Hinweis -->
              <v-divider class="my-6" />
              <div class="hint">
                <v-icon icon="mdi-information-outline" class="ic-sm" />
                <span>Angaben gemäß § 5 ECG / § 14 UGB.</span>
              </div>
            </v-card-text>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </section>
</template>

<script setup lang="ts"></script>

<style scoped>
.section {
  min-height: 80vh;
  display: flex;
  align-items: flex-start;
}

.page-wrap {
  max-width: 1100px;
  padding-top: 48px;
  padding-bottom: 48px;
}

.glass-card {
  background: rgba(255, 255, 255, 0.12);
  backdrop-filter: blur(6px);
}

.card-inner {
  padding: 28px;
}

.block-title {
  font-size: 18px;
  font-weight: 800;
}

.lines {
  margin-top: 6px;
  opacity: 0.9;
  line-height: 1.6;
}

.grid {
  display: grid;
  grid-template-columns: 1fr;
  gap: 18px;
}

@media (min-width: 700px) {
  .grid {
    grid-template-columns: 1fr 1fr;
    gap: 18px 22px;
  }
}

.item {
  display: flex;
  gap: 12px;
  align-items: flex-start;
}

.ic {
  margin-top: 2px;
  opacity: 0.95;
}

.label {
  font-size: 12px;
  opacity: 0.75;
  margin-bottom: 2px;
}

.value {
  font-size: 14px;
  font-weight: 600;
}

.hint {
  display: flex;
  align-items: center;
  gap: 10px;
  font-size: 13px;
  opacity: 0.85;
}

.ic-sm {
  opacity: 0.9;
}
</style>