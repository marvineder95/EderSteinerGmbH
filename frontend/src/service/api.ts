import axios from 'axios'

export const api = axios.create({
    baseURL: import.meta.env.VITE_API_BASE_URL || '/api',
    timeout: 10000,
})

api.interceptors.response.use(
    (res) => res,
    (err) => Promise.reject(err)
)