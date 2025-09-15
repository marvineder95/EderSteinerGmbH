<template>
  <section class="section bg-primary">
    <v-container class="align-center justify-center text-center">
      <v-icon start :icon="svc.icon" size="72" color="white" class="mb-4"/>
      <h1 class="services-title">{{ svc.title }}</h1>
      <v-row justify="center">
        <v-col cols="12" md="10" lg="8" class="text-center">
          <p class="text-body-1 mt-4">{{ svc.pitch }}</p>

          <v-btn class="mt-6" color="white" variant="outlined" @click="goContact"
                 append-icon="mdi-arrow-right">Kostenloses Angebot anfordern
          </v-btn>
        </v-col>
      </v-row>

      <!-- Ablauf -->
      <v-row class="mt-10" align="stretch">
        <v-col v-for="(step, i) in svc.steps" :key="i" cols="12" md="6" lg="3">
          <v-card class="pa-5 h-100 text-center" variant="outlined">
            <v-icon :icon="step.icon" size="40" class="mb-3"/>
            <h3 class="text-subtitle-1 font-weight-bold mb-2">{{ step.title }}</h3>
            <p class="text-body-2">{{ step.text }}</p>
          </v-card>
        </v-col>
      </v-row>

      <!-- FAQ -->
      <p class="services-title mt-12">Häufig gestellte Fragen</p>
      <p class="text-body-2 mb-6">Hier beantworten wir die wichtigsten Fragen rund um unseren Service.</p>
      <v-expansion-panels elevation="24" bg-color="primary" variant="default" class="mt-10">
        <v-expansion-panel v-for="(f, i) in svc.faq" :key="i" class="mb-2">
          <v-expansion-panel-title color="primary" class="font-weight-light ">{{ f.q }}</v-expansion-panel-title>
          <v-expansion-panel-text>{{ f.a }}</v-expansion-panel-text>
        </v-expansion-panel>
      </v-expansion-panels>

      <!-- Abschluss-CTA -->
      <div class="text-center mt-12">
        <v-btn color="white" variant="outlined" size="large" @click="goContact"
               append-icon="mdi-email">Jetzt unverbindlich anfragen
        </v-btn>
      </div>
    </v-container>
  </section>
</template>

<script setup lang="ts">
import {computed} from 'vue'
import {useRoute, useRouter} from 'vue-router'

const route = useRoute()
const router = useRouter()

const CONTENT: Record<string, any> = {
  umzuege: {
    title: 'Umzüge', icon: 'mdi-truck-fast',
    pitch: 'Privat- und Firmenumzüge – sicher, pünktlich, stressfrei. Feste Ansprechpartner & Fixtermine.',
    steps: [
      {
        icon: 'mdi-clipboard-text',
        title: 'Besichtigung',
        text: 'Durch unsere kostenlose Besichtigung erhalten Sie ein faires, transparentes und auf Ihre Bedürfnisse abgestimmtes Angebot.'
      },
      {
        icon: 'mdi-package-variant',
        title: 'Verpackung',
        text: 'Von Kartons über Luftpolsterfolie bis hin zu speziellem Verpackungsmaterial: Wir liefern alles, was Sie brauchen. Keine Zeit zum Packen? Gerne übernehmen wir mit unserem professionellen Einpackservice.'
      },
      {
        icon: 'mdi-truck',
        title: 'Transport',
        text: 'Pünktlich, sicher und zuverlässig bringen wir Ihr Hab und Gut an den gewünschten Ort. Haben Sie besonders wertvolle Stücke? Gerne informieren wir Sie über unseren erweiterten Versicherungsschutz.'
      },
      {
        icon: 'mdi-home',
        title: 'Möbelmontage',
        text: 'Ob Schränke, Betten oder andere Möbelstücke – wir kümmern uns um die fachgerechte Demontage und Montage. So brauchen Sie sich keine Gedanken zu machen und können entspannt umziehen.'
      },
    ],
    faq: [
      {
        q: 'Wie läuft ein Umzug mit Ihnen ab?',
        a: 'Nach Ihrer Anfrage vereinbaren wir einen kostenlosen Besichtigungstermin, um Ihre individuellen Anforderungen einschätzen zu können. ' +
            'Anschließend erhalten Sie ein transparentes Pauschalangebot. Entscheiden Sie sich dafür, führen wir Ihren Umzug zuverlässig und stressfrei durch. Sollten Sie unser Angebot nicht annehmen, entstehen für Sie selbstverständlich keinerlei Kosten.'
      },
      {
        q: 'Wie viel kostet ein Umzug?',
        a: 'Die Kosten eines Umzugs hängen stark von Ihren individuellen Anforderungen ab. Deshalb bieten wir Ihnen eine kostenlose Besichtigung an, um Ihre Situation vor Ort einschätzen zu können.' +
            ' So erhalten Sie ein transparentes und faires Angebot, das genau auf Ihre Bedürfnisse zugeschnitten ist.'
      },
      {
        q: 'Wie lange im Voraus sollte man für einen Umzug anfragen?',
        a: 'Idealerweise etwa 4 Wochen im Voraus, da wir bei Bedarf Halteverbotszonen einrichten und Verpackungsmaterial rechtzeitig bereitstellen können. Wir verstehen jedoch, dass es manchmal kurzfristig gehen muss – rufen Sie uns in diesem Fall einfach an, und wir finden gemeinsam eine passende Lösung.'
      },
      {
        q: 'Ist unser Hab & Gut bei einem Transport mit Ihnen versichert?',
        a: 'Selbstverständlich! Ihr Umzugsgut ist bei jedem Transport automatisch bis zu einem Wert von 500 € versichert. Wenn Sie zusätzlichen Schutz wünschen, bieten wir Ihnen gerne eine erweiterte Transportversicherung an – sprechen Sie uns einfach darauf an.'
      },
      {
        q: 'Sie müssen den Transport absagen, welche Stornobedingungen gelten bei Ihnen?',
        a: 'Wir wissen, dass sich Pläne manchmal ändern können. Bei einer Stornierung bis 4 Wochen vor dem Umzugstermin entstehen für Sie keine Kosten. Erfolgt die Absage zwischen 2 und 4 Wochen vor dem Termin, berechnen wir 50 % des vereinbarten Pauschalpreises. Bei einer Stornierung innerhalb von 2 Wochen vor dem Umzug müssen wir den vollen Preis in Rechnung stellen. Vielen Dank für Ihr Verständnis.'
      },
      {
        q: 'Bieten Sie Umzugskartons an?',
        a: 'Ja, wir stellen Ihnen gerne Umzugskartons und weiteres Verpackungsmaterial zur Verfügung. Welche Materialien Sie benötigen, klären wir am besten direkt bei der Besichtigung. Unsere Kartons geben wir gegen eine kleine Leihgebühr aus – sie können also schon einmal benutzt sein, sind aber selbstverständlich in gutem Zustand. Natürlich dürfen Sie die Kartons nach Belieben beschriften.'
      },
      {
        q: 'Bei Ihnen gibt es keinerlei Parkplätze, was nun?',
        a: 'Ein reservierter Parkplatz vor Ort ist entscheidend für einen reibungslosen Ablauf. Sollte in Ihrer Nähe keine Parkmöglichkeit vorhanden sein, kümmern wir uns gerne um die Einrichtung einer Halteverbotszone. So müssen Sie sich um nichts kümmern und wir können Ihr Umzugsgut sicher und schnell be- und entladen.'
      },
      {
        q: 'Wie gehen Sie mit besonders schweren oder sperrigen Transportgütern um?',
        a: 'Auch besonders schwere oder sperrige Möbelstücke und Gegenstände sind für uns kein Problem. Dank unserer Erfahrung und dem passenden Equipment (z. B. Tragegurte, Transporthilfen, Spezialfahrzeuge) stellen wir sicher, dass Ihr Umzugsgut sicher und professionell bewegt wird. Sprechen Sie uns einfach auf Ihr spezielles Transportstück an – wir erstellen Ihnen ein faires Angebot und sorgen dafür, dass auch außergewöhnliche Herausforderungen zuverlässig gemeistert werden.'

},
    ],
  },
  entruempelungen: {
    title: 'Entrümpelungen', icon: 'mdi-dump-truck',
    pitch: 'Privat- und Firmenumzüge – sicher, pünktlich, stressfrei. Feste Ansprechpartner & Fixtermine.',
    steps: [
      {icon: 'mdi-clipboard-text', title: 'Besichtigung', text: 'Kostenlose Einschätzung vor Ort oder per Video.'},
      {icon: 'mdi-package-variant', title: 'Verpackung', text: 'Schutzmaterial & Demontage nach Bedarf.'},
      {icon: 'mdi-truck', title: 'Transport', text: 'Versichert, schonend, termingerecht.'},
      {icon: 'mdi-home', title: 'Aufbau', text: 'Aufstellen, Montage, Entsorgung des Packmaterials.'},
    ],
    faq: [
      {
        q: 'Wie viel kostet ein Umzug?',
        a: 'Die Kosten eines Umzugs hängen stark von Ihren individuellen Anforderungen ab. Deshalb bieten wir Ihnen eine kostenlose Besichtigung an, um Ihre Situation vor Ort einschätzen zu können.' +
            ' So erhalten Sie ein transparentes und faires Angebot, das genau auf Ihre Bedürfnisse zugeschnitten ist.'
      },
      {
        q: 'Wie lange im Voraus sollte man für einen Umzug anfragen',
        a: 'Idealerweise etwa 4 Wochen im Voraus, da wir bei Bedarf Halteverbotszonen einrichten und Verpackungsmaterial rechtzeitig bereitstellen können. Wir verstehen jedoch, dass es manchmal kurzfristig gehen muss – rufen Sie uns in diesem Fall einfach an, und wir finden gemeinsam eine passende Lösung.'
      },
      {q: 'Bietet ihr Halteverbotszonen?', a: 'Ja, inklusive Behördengang auf Wunsch.'},
    ],
  },
  lagerung: {
    title: 'Lagerung', icon: 'mdi-warehouse',
    pitch: 'Privat- und Firmenumzüge – sicher, pünktlich, stressfrei. Feste Ansprechpartner & Fixtermine.',
    steps: [
      {icon: 'mdi-clipboard-text', title: 'Besichtigung', text: 'Kostenlose Einschätzung vor Ort oder per Video.'},
      {icon: 'mdi-package-variant', title: 'Verpackung', text: 'Schutzmaterial & Demontage nach Bedarf.'},
      {icon: 'mdi-truck', title: 'Transport', text: 'Versichert, schonend, termingerecht.'},
      {icon: 'mdi-home', title: 'Aufbau', text: 'Aufstellen, Montage, Entsorgung des Packmaterials.'},
    ],
    faq: [
      {
        q: 'Wie viel kostet ein Umzug?',
        a: 'Die Kosten eines Umzugs hängen stark von Ihren individuellen Anforderungen ab. Deshalb bieten wir Ihnen eine kostenlose Besichtigung an, um Ihre Situation vor Ort einschätzen zu können.' +
            ' So erhalten Sie ein transparentes und faires Angebot, das genau auf Ihre Bedürfnisse zugeschnitten ist.'
      },
      {
        q: 'Wie lange im Voraus sollte man für einen Umzug anfragen',
        a: 'Idealerweise etwa 4 Wochen im Voraus, da wir bei Bedarf Halteverbotszonen einrichten und Verpackungsmaterial rechtzeitig bereitstellen können. Wir verstehen jedoch, dass es manchmal kurzfristig gehen muss – rufen Sie uns in diesem Fall einfach an, und wir finden gemeinsam eine passende Lösung.'
      },
      {q: 'Bietet ihr Halteverbotszonen?', a: 'Ja, inklusive Behördengang auf Wunsch.'},
    ],
  },
  sicherungsposten: {
    title: 'Sicherungsposten', icon: 'mdi-shield-account',
    pitch: 'Privat- und Firmenumzüge – sicher, pünktlich, stressfrei. Feste Ansprechpartner & Fixtermine.',
    steps: [
      {icon: 'mdi-clipboard-text', title: 'Besichtigung', text: 'Kostenlose Einschätzung vor Ort oder per Video.'},
      {icon: 'mdi-package-variant', title: 'Verpackung', text: 'Schutzmaterial & Demontage nach Bedarf.'},
      {icon: 'mdi-truck', title: 'Transport', text: 'Versichert, schonend, termingerecht.'},
      {icon: 'mdi-home', title: 'Aufbau', text: 'Aufstellen, Montage, Entsorgung des Packmaterials.'},
    ],
    faq: [
      {
        q: 'Wie viel kostet ein Umzug?',
        a: 'Die Kosten eines Umzugs hängen stark von Ihren individuellen Anforderungen ab. Deshalb bieten wir Ihnen eine kostenlose Besichtigung an, um Ihre Situation vor Ort einschätzen zu können.' +
            ' So erhalten Sie ein transparentes und faires Angebot, das genau auf Ihre Bedürfnisse zugeschnitten ist.'
      },
      {
        q: 'Wie lange im Voraus sollte man für einen Umzug anfragen',
        a: 'Idealerweise etwa 4 Wochen im Voraus, da wir bei Bedarf Halteverbotszonen einrichten und Verpackungsmaterial rechtzeitig bereitstellen können. Wir verstehen jedoch, dass es manchmal kurzfristig gehen muss – rufen Sie uns in diesem Fall einfach an, und wir finden gemeinsam eine passende Lösung.'
      },
      {q: 'Bietet ihr Halteverbotszonen?', a: 'Ja, inklusive Behördengang auf Wunsch.'},
    ],
  },
}

const svc = computed(() => CONTENT[route.params.slug as string] ?? {
  title: 'Leistung', icon: 'mdi-information', pitch: '', steps: [], faq: []
})

function goContact() {
  router.push('/contact')
}
</script>