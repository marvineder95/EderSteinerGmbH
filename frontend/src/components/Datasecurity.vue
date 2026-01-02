<template>
  <section id="services" class="section bg-primary">
    <v-container class="services-wrap align-center justify-center text-center">
      <h2 class="services-title mb-5">Datenschutz</h2>
      <v-row justify="center">
        <v-col cols="12" md="10" lg="8">
          <v-card class="glass-card" variant="outlined" rounded="xl">
            <v-card-text class="card-inner">
              <div class="intro">
                <v-icon icon="mdi-shield-lock-outline" class="ic-lg" />
                <div>
                  <div class="intro-title">Datenschutzerklärung</div>
                  <div class="intro-text">
                    Diese Seite enthält allgemeine Textbausteine. Bitte vor Livegang rechtlich prüfen und
                    mit euren echten Daten ergänzen.
                  </div>
                </div>
              </div>

              <v-divider class="my-6" />

              <div class="content">
                <h3 class="h">1. Verantwortlicher</h3>
                <p class="p">
                  Eder &amp; Steiner GmbH<br />
                  Obersdorferstraße 5, 2201 Seyring, Österreich<br />
                  E-Mail: office@es-gmbh.at<br />
                  Tel.: +43 660 977 81 57
                </p>

                <h3 class="h">2. Allgemeines</h3>
                <p class="p">
                  Wir verarbeiten personenbezogene Daten ausschließlich im Einklang mit der DSGVO und den
                  geltenden österreichischen Datenschutzbestimmungen. Personenbezogene Daten sind alle
                  Informationen, die sich auf eine identifizierte oder identifizierbare Person beziehen.
                </p>

                <h3 class="h">3. Kontaktformular</h3>
                <p class="p">
                  Wenn Sie unser Kontaktformular nutzen, verarbeiten wir die von Ihnen eingegebenen Daten
                  (z. B. Name, E-Mail, Telefonnummer, Thema, Wunschdatum und Nachricht), um Ihre Anfrage zu
                  bearbeiten und mit Ihnen Kontakt aufzunehmen.
                </p>
                <ul class="list">
                  <li><strong>Zweck:</strong> Bearbeitung Ihrer Anfrage und Kommunikation</li>
                  <li><strong>Rechtsgrundlage:</strong> Art. 6 Abs. 1 lit. b DSGVO (vorvertragliche Maßnahmen) bzw. Art. 6 Abs. 1 lit. f DSGVO (berechtigtes Interesse)</li>
                  <li><strong>Empfänger:</strong> ausschließlich intern; Versand der Anfrage per E-Mail an unser Postfach</li>
                  <li><strong>Speicherdauer:</strong> so lange wie erforderlich zur Bearbeitung, anschließend gemäß gesetzlicher Aufbewahrungspflichten bzw. bis zur Klärung des Sachverhalts</li>
                </ul>

                <h3 class="h">4. Server-Logfiles</h3>
                <p class="p">
                  Beim Besuch unserer Website können durch den Hosting-Provider technische Informationen
                  (z. B. IP-Adresse, Datum/Uhrzeit, aufgerufene Seite, Browser/OS) in Server-Logfiles
                  gespeichert werden. Diese Daten dienen der technischen Sicherheit und Fehleranalyse.
                </p>
                <ul class="list">
                  <li><strong>Rechtsgrundlage:</strong> Art. 6 Abs. 1 lit. f DSGVO</li>
                  <li><strong>Speicherdauer:</strong> abhängig vom Hosting-Provider (typisch wenige Tage/Wochen)</li>
                </ul>

                <h3 class="h">5. Cookies &amp; Tracking</h3>
                <p class="p">
                  Derzeit verwenden wir keine Tracking-Tools. Falls in Zukunft Cookies/Tools (z. B. Analytics)
                  eingesetzt werden, erfolgt dies nur mit entsprechender Information und – sofern erforderlich –
                  Ihrer Einwilligung.
                </p>

                <h3 class="h">6. Weitergabe von Daten</h3>
                <p class="p">
                  Eine Weitergabe Ihrer Daten erfolgt nur, wenn dies zur Vertragserfüllung erforderlich ist,
                  wir gesetzlich dazu verpflichtet sind oder Sie eingewilligt haben.
                </p>

                <h3 class="h">7. Ihre Rechte</h3>
                <p class="p">
                  Sie haben insbesondere das Recht auf Auskunft, Berichtigung, Löschung, Einschränkung der
                  Verarbeitung, Datenübertragbarkeit sowie Widerspruch gegen die Verarbeitung.
                </p>
                <ul class="list">
                  <li><strong>Kontakt:</strong> info@eder-steiner.at</li>
                  <li><strong>Beschwerde:</strong> Österreichische Datenschutzbehörde</li>
                </ul>

                <h3 class="h">8. Datensicherheit</h3>
                <p class="p">
                  Wir setzen geeignete technische und organisatorische Maßnahmen ein, um Ihre Daten gegen
                  Verlust, Missbrauch und unbefugten Zugriff zu schützen.
                </p>

                <h3 class="h">9. Änderungen</h3>
                <p class="p">
                  Wir behalten uns vor, diese Datenschutzerklärung bei Bedarf anzupassen (z. B. bei neuen
                  Funktionen oder gesetzlichen Änderungen).
                </p>

                <div class="meta">
                  <v-icon icon="mdi-calendar-clock" class="ic-sm" />
                  <span>Stand: {{ lastUpdated }}</span>
                </div>
              </div>
            </v-card-text>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </section>
</template>

<script setup lang="ts">
const lastUpdated = '02.01.2026'
</script>

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

.intro {
  display: flex;
  gap: 14px;
  align-items: flex-start;
}

.ic-lg {
  font-size: 28px;
  opacity: 0.95;
}

.intro-title {
  font-size: 18px;
  font-weight: 800;
  margin-bottom: 4px;
}

.intro-text {
  font-size: 13px;
  opacity: 0.85;
  line-height: 1.5;
}

.content {
  line-height: 1.7;
}

.h {
  font-size: 16px;
  font-weight: 800;
  margin: 18px 0 8px;
}

.p {
  font-size: 14px;
  opacity: 0.92;
  margin: 0 0 10px;
}

.list {
  margin: 0 0 10px;
  padding-left: 18px;
  font-size: 14px;
  opacity: 0.92;
}

.meta {
  margin-top: 18px;
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