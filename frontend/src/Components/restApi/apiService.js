// apiService.js

import CONFIG from "../../../configSettings.js";

const BASE_URL = CONFIG;

/**
 * Выполняет HTTP запрос.
 * @param {string} endpoint - Endpoint API (например, "/dialogue").
 * @param {string} method - HTTP метод (GET, POST и т.д.).
 * @param {Object} body - Тело запроса (для POST/PUT).
 * @returns {Promise<any>} Ответ сервера или выбрасывает ошибку.
 */
const apiRequest = async (endpoint, method = "GET", body = null) => {
    const headers = { "Content-Type": "application/json" };

    const options = {
        method,
        headers,
    };

    if (body) {
        options.body = JSON.stringify(body);
    }

    try {
        const response = await fetch(`${BASE_URL}${endpoint}`, options);

        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }

        return await response.json();
    } catch (error) {
        console.error("API Request Error:", error);
        throw error;
    }
};

export default apiRequest;