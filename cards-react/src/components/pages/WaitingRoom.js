import React, { useEffect, useState } from 'react'
import Lottie from 'react-lottie';
import animationData from '../../resources/lotties/96855-pokeball-loading-animation.json';
import { useNavigate } from 'react-router';
import {
    BrowserRouter as Router,
    useParams
} from "react-router-dom";
import { getGame } from '../../core/services/GameService';

export const WaitingRoom = () => {

    const { id } = useParams();
    const navigate = useNavigate();
    const [game, setGame] = useState();

    useEffect(() => {
        const fetchCards = async () => {
            const game = await getGame(id);
            if(game.status === 2){
                console.log('GAME STARTING...', game)
                navigate('/room/play/'+id);
            }else{
                console.log('GAME WAITING...', game)
            }
            setGame(game)
        }
        fetchCards();

        const interval = setInterval(() => {
            fetchCards()
        }, 3000);
        return () => clearInterval(interval)
    }, []);

    

    const defaultOptions = {
        loop: true,
        autoplay: true,
        animationData: animationData,
        rendererSettings: {
            preserveAspectRatio: "xMidYMid slice"
        }
    };

    return (
        <div className="container">
            <Lottie
                options={defaultOptions}
                height={400}
                width={400}
            />
            <h2 className="mt-5 text-center">Waiting player...</h2>
        </div>
    )
}

export default WaitingRoom;