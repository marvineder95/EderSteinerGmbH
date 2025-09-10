import 'vuetify/styles'
import { createVuetify } from 'vuetify'
import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'
import { aliases, mdi } from 'vuetify/iconsets/mdi'

const esTheme = {
    dark: false,
    colors: {
        primary: '#73a04b',
        secondary: '#1f2937',
        surface: '#ffffff',
        background: '#f5f5f7',

        error: '#FF5252',
        info: '#2196F3',
        success: '#4CAF50',
        warning: '#FB8C00',
    },
}

export default createVuetify({
    components,
    directives,
    icons: {
        defaultSet: 'mdi',
        aliases,
        sets: { mdi },
    },
    theme: {
        defaultTheme: 'esTheme',
        themes: {
            esTheme,
        },
    },
})