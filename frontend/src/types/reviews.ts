export interface ReviewDto {
    id: string
    name: string
    rating: number     // 1..5
    text: string
    createdAt: string  // ISO-8601
}

export interface CreateReviewRequest {
    token: string
    name?: string
    rating: number
    text: string
}

export interface PagedResponse<T> {
    content: T[]
    page: number
    size: number
    totalElements: number
    totalPages: number
}

export interface RatingSummary {
    average: number
    count: number
}