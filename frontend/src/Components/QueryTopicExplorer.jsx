


export default function QueryTopicExplorer() {
    return (
        <main>
            <div className="section-histore-prompt">
                <ul>
                    <li className="active">
                        Предыдущий запрос
                    </li>
                    <li>
                        Предыдущий запрос
                    </li>

                    <li>
                        Предыдущий запрос
                    </li>

                </ul>
            </div>
            <div className="section-block-prompt">
                <div className="section-block-currentTemp">
                    Интересющий запрос
                </div>
                <div className="subtopics">
                    <ul>
                        <li>
                            <h3>Тема 1</h3>
                            <p>Краткая информация о теме </p>
                        </li>
                        <li>
                            <h3>Тема 1</h3>
                            <p>Краткая информация о теме </p>
                        </li>
                        <li>
                            <h3>Тема 1</h3>
                            <p>Краткая информация о теме </p>
                        </li>
                    </ul>
                </div>
                <div className="next-tem">
                    <button>
                    Давай третью тему
                    </button>
                </div>
            </div>
        </main>
    )
}