import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import ContentMainPage from "./Components/Page/MainPage";
import PageQuestionReceipt from "./Components/Page/PageQuestionReceipt";

function App() {
    return (
        <Router>
            <Routes>
                {/* Указываем маршруты */}
                <Route path="/" element={<ContentMainPage />} />
                <Route path="/page-question-receipt" element={<PageQuestionReceipt />} />
            </Routes>
        </Router>
    );
}

export default App;