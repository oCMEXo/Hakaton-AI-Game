import React from "react";

export default function QueryTopicExplorer({ titles }) {
    return (
        <main>
            <div className="section-histore-prompt">
                <ul>
                    {titles.length > 0 ? (
                        titles.map((title, index) => (
                            <li key={index} className={index === titles.length - 1 ? "active" : ""}>
                                {title}
                            </li>
                        ))
                    ) : (
                        <p>Нет предыдущих запросов.</p>
                    )}
                </ul>
            </div>
            <div className="section-block-prompt">
                <div className="section-block-currentTemp">
                    {titles.length > 0 ? titles[titles.length - 1] : "Интересующий запрос не задан"}
                </div>
                <div className="subtopics">
                    <ul>
                        {titles.map((title, index) => (
                            <li key={index}>
                                <h3>{title}</h3>
                                <p>Краткая информация о теме</p>
                            </li>
                        ))}
                    </ul>
                </div>
                <div className="next-tem">
                    <button>
                        Давай третью тему
                    </button>
                </div>
            </div>
        </main>
    );
}