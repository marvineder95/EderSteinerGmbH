// src/stores/reviews.ts
import { defineStore } from 'pinia'
import { api} from "../service/api.ts";
import type { Review } from '@/types/reviews'

type PagePayload<T> =
    | T[]                                 // plain array
    | { content?: T[]; page?: number; totalPages?: number } // Spring Page
    | { items?: T[]; page?: number; total_pages?: number }   // alternative

function normalizePage<T>(raw: PagePayload<T>) {
    // Entpacken, falls Axios-Response gewrappt ist (z.B. { data: ... })
    const data: any = (raw as any)?.data ?? raw

    const items: T[] =
        Array.isArray(data) ? data :
            Array.isArray(data?.content) ? data.content :
                Array.isArray(data?.items) ? data.items :
                    []

    const page =
        typeof data?.page === 'number' ? data.page : 0

    const totalPages =
        typeof data?.totalPages === 'number' ? data.totalPages :
            typeof data?.total_pages === 'number' ? data.total_pages :
                1

    return { items, page, totalPages }
}

export const useReviewsStore = defineStore('reviews', {
    state: () => ({
        list: [] as Review[],
        page: 0,
        size: 10,
        totalPages: 1,
        loading: false,
        error: '' as string | null,
    }),

    actions: {
        async fetchPage(page = 0) {
            this.loading = true
            this.error = null
            try {
                const res = await api.get('/reviews', { params: { page, size: this.size } })
                const { items, page: srvPage, totalPages } = normalizePage<Review>(res)

                if (page === 0) {
                    this.list = items
                } else {
                    this.list = [...this.list, ...items]
                }
                this.page = srvPage
                this.totalPages = totalPages
            } catch (e: any) {
                this.error = e?.message ?? 'Fehler beim Laden der Bewertungen'
                // Bei Fehler nicht crashen lassen
                if (page === 0) this.list = []
            } finally {
                this.loading = false
            }
        },

        async create(payload: Omit<Review, 'id' | 'createdAt'>) {
            this.loading = true
            this.error = null
            try {
                const res = await api.post('/reviews', payload)
                // Viele APIs geben das erstellte Objekt zurück. Falls nicht, neu laden.
                const created: Review = (res as any)?.data ?? (res as any)
                if (created && created.id) {
                    this.list = [created, ...this.list]
                } else {
                    await this.fetchPage(0)
                }
            } catch (e: any) {
                this.error = e?.message ?? 'Bewertung konnte nicht gespeichert werden'
                throw e
            } finally {
                this.loading = false
            }
        }
    }
})