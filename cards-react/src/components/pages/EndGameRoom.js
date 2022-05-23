import React, { useEffect, useState } from 'react'
import Lottie from 'react-lottie';
import WinLottie from '../../resources/lotties/confetti.json';
import LoseLottie from '../../resources/lotties/lose.json';
import { useSelector } from "react-redux";
import { useNavigate } from 'react-router';
import { getGame, updateRoom } from '../../core/services/GameService';
import {
    BrowserRouter as Router,
    useParams
} from "react-router-dom";

export const EndGameRoom = () => {

    const [isWin, setIsWin] = useState(true)
    const current_user = useSelector(state => state.userReducer.user);
    const { id } = useParams();
    const [game, setGame] = useState();


    useEffect(() => {
        if (current_user) {
            const fetchCards = async () => {
                const game = await getGame(id);
                setGame(game);
                if (game.cardPlayer1 == null && game.player1 == current_user.id) {
                    setIsWin(false)
                    console.log(game.cardPlayer1, game.player1, current_user.id)
                } else {
                    console.log(game.cardPlayer1, game.player1, current_user.id)
                    setIsWin(true)
                }
            }
            fetchCards();
        }
    }, current_user.id)

    console.log(current_user.id)


    const defaultOptions = {
        loop: true,
        autoplay: true,
        animationData: true ? WinLottie : LoseLottie,
        rendererSettings: {
            preserveAspectRatio: "xMidYMid slice"
        }
    };

    return (
        <div className="container">
            <div className="d-flex justify-content-around align-items-center">
                <Lottie
                    options={defaultOptions}
                    height={240}
                    width={240}
                />
                <div className="d-flex flex-column align-items-center">
                    {isWin
                        ?
                        <>
                            <h1>You win !  </h1>a
                        </>

                        :
                        <>
                            <h1>You loose !   </h1>
                        </>
                    }

                    <br></br>
                </div>
                <Lottie
                    options={defaultOptions}
                    height={240}
                    width={240}
                />
            </div>
        </div>
    )
}

export default EndGameRoom;