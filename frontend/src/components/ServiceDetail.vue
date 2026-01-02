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
          a: 'Nach Ihrer Anfrage vereinbaren wir einen kostenlosen Besichtigungstermin, um Ihre individuellen Anforderungen einschätzen zu können. Anschließend erhalten Sie ein transparentes Pauschalangebot. Entscheiden Sie sich dafür, führen wir Ihren Umzug zuverlässig und stressfrei durch. Sollten Sie unser Angebot nicht annehmen, entstehen für Sie selbstverständlich keinerlei Kosten.'
        },
        {
          q: 'Wie viel kostet ein Umzug?',
          a: 'Die Kosten eines Umzugs hängen stark von Ihren individuellen Anforderungen ab. Deshalb bieten wir Ihnen eine kostenlose Besichtigung an, um Ihre Situation vor Ort einschätzen zu können. So erhalten Sie ein transparentes und faires Angebot, das genau auf Ihre Bedürfnisse zugeschnitten ist.'
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
          q: 'Sie müssen den Transport absagen – welche Stornobedingungen gelten bei Ihnen?',
          a: 'Wir wissen, dass sich Pläne manchmal ändern können. Bei einer Stornierung bis 4 Wochen vor dem Umzugstermin entstehen für Sie keine Kosten. Erfolgt die Absage zwischen 2 und 4 Wochen vor dem Termin, berechnen wir 50 % des vereinbarten Pauschalpreises. Bei einer Stornierung innerhalb von 2 Wochen vor dem Umzug müssen wir den vollen Preis in Rechnung stellen. Vielen Dank für Ihr Verständnis.'
        },
        {
          q: 'Bieten Sie Umzugskartons an?',
          a: 'Ja, wir stellen Ihnen gerne Umzugskartons und weiteres Verpackungsmaterial zur Verfügung. Welche Materialien Sie benötigen, klären wir am besten direkt bei der Besichtigung. Unsere Kartons geben wir gegen eine kleine Leihgebühr aus – sie können also schon einmal benutzt sein, sind aber selbstverständlich in gutem Zustand. Natürlich dürfen Sie die Kartons nach Belieben beschriften.'
        },
        {
          q: 'Bei Ihnen gibt es keinerlei Parkplätze – was nun?',
          a: 'Ein reservierter Parkplatz vor Ort ist entscheidend für einen reibungslosen Ablauf. Sollte in Ihrer Nähe keine Parkmöglichkeit vorhanden sein, kümmern wir uns gerne um die Einrichtung einer Halteverbotszone. So müssen Sie sich um nichts kümmern und wir können Ihr Umzugsgut sicher und schnell be- und entladen.'
        },
        {
          q: 'Wie gehen Sie mit besonders schweren oder sperrigen Transportgütern um?',
          a: 'Auch besonders schwere oder sperrige Möbelstücke und Gegenstände sind für uns kein Problem. Dank unserer Erfahrung und dem passenden Equipment (z. B. Tragegurte, Transporthilfen, Spezialfahrzeuge) stellen wir sicher, dass Ihr Umzugsgut sicher und professionell bewegt wird. Sprechen Sie uns einfach auf Ihr spezielles Transportstück an – wir erstellen Ihnen ein faires Angebot und sorgen dafür, dass auch außergewöhnliche Herausforderungen zuverlässig gemeistert werden.'
        },
        {
          q: 'Führen Sie Umzüge auch am Wochenende oder an Feiertagen durch?',
          a: 'Ja, wir führen Umzüge selbstverständlich auch an Wochenenden und Feiertagen durch. Gerade diese Termine sind sehr gefragt, daher empfehlen wir eine möglichst frühzeitige Anfrage, damit wir Ihren Wunschtermin berücksichtigen können.'
        },
        {
          q: 'Übernehmen Sie auch das Verpacken sowie die Möbelmontage?',
          a: 'Gerne! Auf Wunsch übernehmen wir das fachgerechte Verpacken Ihres Umzugsguts sowie die Demontage und Montage Ihrer Möbel. Welche Leistungen Sie benötigen, besprechen wir gemeinsam bei der Besichtigung.'
        },
        {
          q: 'Was passiert, wenn während des Umzugs etwas beschädigt wird?',
          a: 'Sollte trotz größter Sorgfalt ein Schaden entstehen, sind Sie selbstverständlich über unsere Transportversicherung abgesichert. Wir klären jeden Schaden transparent und unkompliziert mit Ihnen.'
        },
        {
          q: 'Bieten Sie auch kurzfristige oder Notfall-Umzüge an?',
          a: 'Ja, wir versuchen auch bei kurzfristigen Anfragen eine Lösung zu finden. Rufen Sie uns am besten direkt an – gemeinsam prüfen wir, was zeitnah möglich ist.'
        }
      ]
  },
  entruempelungen: {
    title: 'Entrümpelungen',
    icon: 'mdi-dump-truck',
    pitch:
        'Mehr Platz. Mehr Klarheit. Wir entrümpeln Wohnungen, Häuser, Keller, Dachböden und Gewerbeflächen – diskret, effizient und sauber.',
    steps: [
      {
        icon: 'mdi-home-search-outline',
        title: 'Besichtigung',
        text: 'Kostenlose Einschätzung vor Ort oder per Video. Wir klären Aufwand, Zugänge und Entsorgung.',
      },
      {
        icon: 'mdi-recycle',
        title: 'Sortierung & Entsorgung',
        text: 'Wir trennen Materialien fachgerecht und entsorgen direkt bei der Energie AG (1220 Wien).',
      },
      {
        icon: 'mdi-truck-fast-outline',
        title: 'Abtransport',
        text: 'Schneller Abtransport mit Fachkräften und Kleintransporter – je nach Aufwand im Angebot.',
      },
      {
        icon: 'mdi-broom',
        title: 'Übergabe',
        text: 'Besenreine Übergabe damit die Fläche sofort wieder nutzbar ist!',
      },
    ],
    faq: [
      {
        q: 'Wie läuft eine Entrümpelung oder Entsorgung bei Ihnen ab?',
        a: 'Nach Ihrer Anfrage vereinbaren wir einen kostenlosen Besichtigungstermin. Vor Ort verschaffen wir uns einen Überblick über Art und Umfang der zu entsorgenden Gegenstände. Anschließend erhalten Sie ein transparentes Pauschalangebot. Nach Ihrer Zusage führen wir die Entrümpelung zuverlässig, sauber und termingerecht durch.'
      },
      {
        q: 'Was kostet eine Entrümpelung oder Entsorgung?',
        a: 'Die Kosten hängen vom Volumen, der Art des Materials sowie dem Aufwand ab. Deshalb arbeiten wir mit einer kostenlosen Besichtigung und erstellen danach ein fixes Pauschalangebot. So haben Sie volle Kostensicherheit – ohne versteckte Gebühren.'
      },
      {
        q: 'Wo entsorgen Sie das Material?',
        a: 'Die Entsorgung erfolgt fachgerecht bei der Energie AG in 1220 Wien. Dort können auch größere Mengen ordnungsgemäß entsorgt werden. Eine kostenlose Entsorgung über MA48-Mistplätze ist leider nicht möglich, da diese nur für Kleinmengen vorgesehen sind.'
      },
      {
        q: 'Ist die Entsorgung bei Ihnen kostenlos?',
        a: 'Nein. Da wir größere Mengen entsorgen und diese bei der Energie AG kostenpflichtig abgegeben werden müssen, fallen Entsorgungskosten an. Diese sind jedoch bereits im Pauschalangebot enthalten – Sie erhalten vorab volle Transparenz.'
      },
      {
        q: 'Welche Arten von Gegenständen entsorgen Sie?',
        a: 'Wir entsorgen nahezu alle Arten von Gegenständen, darunter Möbel, Hausrat, Elektrogeräte, Sperrmüll, Keller- und Dachbodeninhalte sowie Büro- und Geschäftsauflösungen. Sonderfälle klären wir gerne im Rahmen der Besichtigung.'
      },
      {
        q: 'Übernehmen Sie auch komplette Wohnungs- oder Haushaltsauflösungen?',
        a: 'Ja, wir führen vollständige Wohnungs-, Haus- und Geschäftsauflösungen durch. Dabei kümmern wir uns um Demontage, Abtransport, fachgerechte Entsorgung und hinterlassen die Räumlichkeiten besenrein.'
      },
      {
        q: 'Was passiert mit verwertbaren oder brauchbaren Gegenständen?',
        a: 'Verwertbare oder noch brauchbare Gegenstände berücksichtigen wir selbstverständlich bei der Angebotserstellung. Dadurch kann sich der Gesamtpreis entsprechend reduzieren.'
      },
      {
        q: 'Wie kurzfristig können Sie eine Entrümpelung durchführen?',
        a: 'Je nach Auslastung sind auch kurzfristige Termine möglich. Kontaktieren Sie uns am besten direkt – wir prüfen umgehend, wie schnell wir Ihre Entrümpelung umsetzen können.'
      },
      {
        q: 'Muss ich bei der Entrümpelung anwesend sein?',
        a: 'Nein, Ihre Anwesenheit ist nicht zwingend erforderlich. Nach der Besichtigung und Angebotsannahme können wir die Entrümpelung auch selbstständig durchführen. Auf Wunsch erhalten Sie danach eine Rückmeldung oder Fotodokumentation.'
      },
      {
        q: 'Gibt es versteckte Zusatzkosten?',
        a: 'Nein. Unser Pauschalangebot umfasst alle vereinbarten Leistungen inklusive Transport, Arbeitszeit und Entsorgungskosten. Zusätzliche Kosten entstehen nur, wenn sich der Umfang nachträglich wesentlich ändert.'
      }
    ],
  },
  lagerung: {
    title: 'Lagerung',
    icon: 'mdi-warehouse',
    pitch:
        'Flexible und sichere Lagerlösungen in Zusammenarbeit mit unserem Partner Boxroom in 1220 Wien – individuell auf Ihren Bedarf abgestimmt.',
    steps: [
      {
        icon: 'mdi-ruler-square',
        title: 'Bedarfsermittlung',
        text: 'Wir schätzen kostenlos die benötigte Lagerfläche anhand Ihres Hausrats oder Ihrer Möbel ab.',
      },
      {
        icon: 'mdi-domain',
        title: 'Organisation des Lagerraums',
        text: 'Auf Wunsch organisieren wir für Sie einen passenden Lagerraum bei unserem Partner Boxroom (Franz-Reitlinger-Gasse 6, 1220 Wien).',
      },
      {
        icon: 'mdi-lock',
        title: 'Einlagerung',
        text: 'Übernehmen wir die Einlagerung, ist kein direkter Zugriff möglich – so stellen wir Ordnung, Sicherheit und vollständige Lagerung sicher.',
      },
      {
        icon: 'mdi-shield-check-outline',
        title: 'Versicherung',
        text: 'Optional kann der Lagerraum versichert werden. Sprechen Sie uns an – wir klären alle Details für Sie.',
      },
    ],
    faq: [
      {
        q: 'Wo lagern Sie Möbel und Hausrat?',
        a: 'Die Lagerung erfolgt bei unserem Partnerunternehmen Boxroom in der Franz-Reitlinger-Gasse 6, 1220 Wien. Dort stehen moderne und saubere Lagerräume für Möbel und Hausrat zur Verfügung.'
      },
      {
        q: 'Übernehmen Sie die Organisation der Lagerung für mich?',
        a: 'Ja. Auf Wunsch übernehmen wir die komplette Organisation der Einlagerung für Sie – inklusive Einschätzung der benötigten Lagerfläche und Koordination mit unserem Partnerunternehmen Boxroom.'
      },
      {
        q: 'Ist der Transport zur Lagerung im Preis enthalten?',
        a: 'Nein. Der Transport zur Einlagerung wird separat angeboten und im Angebot unter dem Punkt Transport transparent ausgewiesen. So behalten Sie jederzeit den Überblick über alle Kosten.'
      },
      {
        q: 'Was kostet die Lagerung?',
        a: 'Die Lagerung selbst wird monatlich verrechnet und richtet sich nach der Größe des gewählten Lagerraums. Gerne informieren wir Sie vorab über die zu erwartenden monatlichen Kosten.'
      },
      {
        q: 'Kann ich mein Lager auch selbst bei Boxroom anmieten?',
        a: 'Ja. Sie können Ihren Lagerraum direkt selbst bei Boxroom anmieten und alle Details vor Ort mit den Mitarbeitern klären. In diesem Fall haben Sie jederzeit Zugang zu Ihrem Lager.'
      },
      {
        q: 'Habe ich Zugriff auf meine Sachen während der Lagerung?',
        a: 'Wenn Sie den Lagerraum selbst anmieten, haben Sie jederzeit Zugriff auf Ihre eingelagerten Gegenstände. Übernehmen wir die Einlagerung für Sie, ist ein Zugriff während der Lagerzeit nicht möglich, da wir sicherstellen müssen, dass alle Gegenstände fachgerecht verstaut sind und unverändert bleiben.'
      },
      {
        q: 'Wie groß sollte mein Lagerraum sein?',
        a: 'Die benötigte Lagerfläche hängt vom Umfang Ihres Hausrats oder Ihrer Möbel ab. Gerne schätzen wir den Platzbedarf im Rahmen einer kostenlosen Besichtigung realistisch für Sie ein, damit Sie weder zu klein noch unnötig groß anmieten.'
      },
      {
        q: 'Ist mein Lagergut versichert?',
        a: 'Es besteht die Möglichkeit, den Lagerraum bzw. das Lagergut zu versichern. Sprechen Sie uns einfach darauf an – wir klären die Versicherungsoptionen gerne gemeinsam mit Ihnen ab.'
      },
      {
        q: 'Wie lange kann ich mein Lager nutzen?',
        a: 'Die Lagerdauer ist flexibel und richtet sich nach Ihrem individuellen Bedarf. Ob kurzfristige Zwischenlagerung oder längerfristige Aufbewahrung – wir finden eine passende Lösung.'
      },
      {
        q: 'Lässt sich ein Umzug mit einer Lagerung kombinieren?',
        a: 'Ja. Umzug und Lagerung lassen sich ideal kombinieren, etwa bei Verzögerungen beim Einzug oder Renovierungsarbeiten. Wir unterstützen Sie gerne bei der Planung und Koordination.'
      }
    ],
  },
  /**sicherungsposten: {
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
  },**/
}

const svc = computed(() => CONTENT[route.params.slug as string] ?? {
  title: 'Leistung', icon: 'mdi-information', pitch: '', steps: [], faq: []
})

function goContact() {
  router.push('/contact')
}
</script>