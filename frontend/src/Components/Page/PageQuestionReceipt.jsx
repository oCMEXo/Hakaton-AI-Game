import React from "react";
import { useLocation } from "react-router-dom";
import QueryTopicExplorer from "../Component/QueryTopicExplorer.jsx";
import Header from "../Lauout/Header.jsx";

export default function PageQuestionReceipt() {
    const location = useLocation();
    const { titles = [] } = location.state || {}; // Получаем список тем или создаём пустой массив, если данные не переданы

    return (
        <div>
            <Header />
            <QueryTopicExplorer titles={titles} />
        </div>
    );
}