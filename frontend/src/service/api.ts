// src/service/api.ts
import axios, { type AxiosInstance, type AxiosResponse } from 'axios'

export const api: AxiosInstance = axios.create({
    baseURL: import.meta.env.VITE_API_BASE_URL || '/api',
    timeout: 10000,
    withCredentials: false,
    headers: { 'Content-Type': 'application/json' },
})

api.interceptors.response.use(
    (res: AxiosResponse) => res.data,
    (err) => Promise.reject(err)
)