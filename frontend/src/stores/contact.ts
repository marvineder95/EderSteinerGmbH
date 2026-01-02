import { defineStore } from 'pinia'
import { api } from '../service/api.ts'

export type ContactPayload = {
    name: string
    email: string
    phone?: string
    topic: string
    date?: string | null
    message: string
}

export const useContactStore = defineStore('contact', {
    state: () => ({
        sending: false,
        error: null as string | null,
        ok: false,
    }),

    actions: {
        async send(payload: ContactPayload): Promise<void> {
            this.sending = true
            this.error = null
            this.ok = false

            try {
                await api.post('/contact', payload)
                this.ok = true
            } catch (e: any) {
                this.error =
                    e?.response?.data?.message ??
                    e?.message ??
                    'Senden fehlgeschlagen'
            } finally {
                this.sending = false
            }
        },

        reset(): void {
            this.sending = false
            this.error = null
            this.ok = false
        },
    },
})