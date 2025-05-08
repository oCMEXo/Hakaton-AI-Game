// DialoguesList.jsx
import React, { useState, useEffect } from "react";
import { getDialogues, createDialogue } from "./dialogueApi.js";

const DialoguesList = () => {
    const [dialogues, setDialogues] = useState([]);
    const [page, setPage] = useState(0);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchDialogues = async () => {
            try {
                const result = await getDialogues(page);
                setDialogues(result);
            } catch (err) {
                setError(err.message);
            }
        };

        fetchDialogues();
    }, [page]);

    const handleCreateDialogue = async () => {
        try {
            const newDialogue = await createDialogue("Новая тема");
            alert(`Диалог создан: ${newDialogue.id}`);
        } catch (err) {
            alert("Ошибка создания диалога: " + err.message);
        }
    };

    return (
        <>
            <h1>Список диалогов</h1>
            {error && <p style={{ color: "red" }}>Ошибка: {error}</p>}
            <ul>
                {dialogues.map((dialogue) => (
                    <li key={dialogue.id}>{dialogue.title}</li>
                ))}
            </ul>
            <button onClick={() => setPage((prev) => Math.max(0, prev - 1))}>
                Назад
            </button>
            <button onClick={() => setPage((prev) => prev + 1)}>Вперед</button>
            <button onClick={handleCreateDialogue}>Создать диалог</button>
        </>
    );
};

export default DialoguesList;