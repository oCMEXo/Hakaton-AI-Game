import { React } from 'react';


import Lyp from '../assets/Frame10.svg'
export default function ContentMainPage() {
    return (
        <main>
            <div className="section-histore-prompt">
                <ul>
                    <li>
                        Предыдущий запрос
                    </li>

                </ul>
            </div>
            <div className="section-gpt-prompt">
                <h1>
                    Что вы хотите узнать?
                </h1>
                <form action="" method="get">
                    <label htmlFor="prompt"><img src={Lyp} alt=""/></label>
                    <input type="text" name="prompt" id="prompt" placeholder="Спроси меня..."/>
                </form>
            </div>
        </main>
    )
}