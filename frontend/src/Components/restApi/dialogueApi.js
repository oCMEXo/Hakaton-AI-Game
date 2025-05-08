// dialogueApi.js
import apiRequest from "./apiService.js";

/**
 * Получить список диалогов.
 * @param {number} page - Номер страницы.
 * @param {number} size - Количество элементов на странице.
 * @returns {Promise<Array>} Список диалогов.
 */
export const getDialogues = async (page = 0, size = 10) => {
    const endpoint = `/dialogue?page=${page}&size=${size}`;
    return await apiRequest(endpoint, "GET");
};

/**
 * Создать новый диалог.
 * @param {string} topic - Тема диалога.
 * @returns {Promise<Object>} Созданный диалог.
 */
export const createDialogue = async (topic) => {
    const endpoint = `/dialogue`;
    return await apiRequest(endpoint, "POST", topic);
};

/**
 * Получить список заголовков по диалогу.
 * @param {number} dialogueId - ID диалога.
 * @returns {Promise<Array>} Список заголовков.
 */
export const getHeaders = async (dialogueId) => {
    const endpoint = `/header/${dialogueId}`;
    return await apiRequest(endpoint, "GET");
};

/**
 * Получить содержимое заголовка.
 * @param {number} headerId - ID заголовка.
 * @returns {Promise<Object>} Детали контента.
 */
export const getContentByHeader = async (headerId) => {
    const endpoint = `/content/${headerId}`;
    return await apiRequest(endpoint, "GET");
};