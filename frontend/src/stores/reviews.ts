import { defineStore } from 'pinia'
import { api} from "../service/api.ts";
import type {CreateReviewRequest, ReviewDto} from "../types/reviews.ts";

type PagePayload<T> =
    | T[]
    | { content?: T[]; page?: number; totalPages?: number }
    | { items?: T[]; page?: number; total_pages?: number }

function normalizePage<T>(data: PagePayload<T>) {
    const items: T[] =
        Array.isArray(data) ? data
            : Array.isArray((data as any)?.content) ? (data as any).content
                : Array.isArray((data as any)?.items) ? (data as any).items
                    : []

    const page =
        typeof (data as any)?.page === 'number' ? (data as any).page : 0

    const totalPages =
        typeof (data as any)?.totalPages === 'number' ? (data as any).totalPages
            : typeof (data as any)?.total_pages === 'number' ? (data as any).total_pages
                : 1

    return { items, page, totalPages }
}

export const useReviewsStore = defineStore('reviews', {
    state: () => ({
        list: [] as ReviewDto[],
        page: 0,
        size: 10,
        totalPages: 1,
        loading: false,
        error: null as string | null,
    }),

    getters: {
        hasMore: (s) => s.page + 1 < s.totalPages,
        count: (s) => s.list.length,
    },

    actions: {
        reset() {
            this.list = []
            this.page = 0
            this.totalPages = 1
            this.error = null
        },

        async fetchPage(page = 0) {
            this.loading = true
            this.error = null
            try {
                const res = await api.get(`/reviews`, { params: { page, size: this.size } })
                const { items, page: srvPage, totalPages } = normalizePage<ReviewDto>(res.data)

                this.list = page === 0 ? items : [...this.list, ...items]
                this.page = srvPage
                this.totalPages = totalPages
            } catch (e: any) {
                this.error = e?.message ?? 'Fehler beim Laden der Bewertungen'
                if (page === 0) this.list = []
            } finally {
                this.loading = false
            }
        },

        async create(payload: Omit<CreateReviewRequest, 'id' | 'createdAt'>) {
            this.loading = true
            this.error = null
            try {
                const created = await api.post('/reviews', payload) as ReviewDto
                if (created?.id) this.list = [created, ...this.list]
                else await this.fetchPage(0)
            } catch (e: any) {
                this.error = e?.message ?? 'Bewertung konnte nicht gespeichert werden'
                throw e
            } finally {
                this.loading = false
            }
        },
    },
})