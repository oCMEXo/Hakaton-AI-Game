import React, { useState } from "react";
import { useNavigate } from "react-router-dom";


import Lupo from "../../assets/Frame10.svg";

export default function ContentMainPage() {
    const [titles, setTitles] = useState([]); // Для хранения списка тем
    const [newDialogueTitle, setNewDialogueTitle] = useState(""); // Поле ввода новой темы
    const navigate = useNavigate(); // Хук для переходов

    const handleCreateDialogue = async () => {
        if (!newDialogueTitle.trim()) {
            alert("Введите тему!");
            return;
        }

        // Добавляем тему в список
        const updatedTitles = [...titles, newDialogueTitle];
        setTitles(updatedTitles);

        // Переход на другую страницу с передачей данных
        navigate("/page-question-receipt", { state: { titles: updatedTitles } });

        // Очищаем поле
        setNewDialogueTitle("");
    };

    return (
        <main>
            <div className="section-gpt-prompt">
                <h1>Что вы хотите узнать?</h1>
                <form
                    onSubmit={(e) => {
                        e.preventDefault();
                        handleCreateDialogue();
                    }}
                >
                    <label htmlFor="prompt">
                        <img src={Lupo} alt="" />
                    </label>
                    <input
                        type="text"
                        name="prompt"
                        id="prompt"
                        placeholder="Спроси меня..."
                        value={newDialogueTitle}
                        onChange={(e) => setNewDialogueTitle(e.target.value)}
                    />
                </form>
            </div>
        </main>
    );
}