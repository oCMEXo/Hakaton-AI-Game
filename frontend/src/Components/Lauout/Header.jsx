import { React } from 'react';

import Logo from '../../assets/Frame.svg'
import LogoUser from '../../assets/Frame9.svg'

export default function Header() {
    return (
        <>
            <header>
                <div className="logo-site">

                    <img src={Logo} alt="logo"/>
                    <h1>
                        Mnemos Ai
                    </h1>

                </div>
                <div className="info-user">
                    <img src={LogoUser} alt=""/>
                    <div className="email-block">
                        superpochta@gmail.com
                    </div>
                </div>
            </header>
        </>
    )
}