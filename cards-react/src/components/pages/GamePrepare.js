import React, { useEffect, useState } from 'react'
import ProfilPage from "./ProfilPage";
import { Button, notification, Modal } from 'antd';
import { useSelector } from "react-redux";
import { useNavigate } from 'react-router';
import { getGame, updateRoom } from '../../core/services/GameService';
import {
    BrowserRouter as Router,
    useParams
  } from "react-router-dom";
  
export const GamePrepare = (props) => {

    const navigate = useNavigate();
    const current_user = useSelector(state => state.userReducer.user);
    const [game, setGame] = useState();
    const { id } = useParams();

    useEffect(() => {
        const fetchCards = async () => {
            const game = await getGame(id);
            setGame(game)
        }
        fetchCards();
    }, [])

    console.log(game);

    const selectedCard = useSelector(state => state.cardReducer.card);
    
    const pickCard = () => {
        if (selectedCard != null) {
            Modal.confirm(
                {
                    width: "40vw",
                    content: (
                        <div>
                            <h5>Are you sure you want to pick this card ?</h5>
                        </div>
                    ),
                    title: 'Select card : '+selectedCard.name,
                    onOk: async () => {

                        if(game.player1 == current_user.id){
                            game.cardPlayer1 = selectedCard.id;
                        }else{
                            game.player2 = current_user.id;
                            game.cardPlayer2 = selectedCard.id;
                        }

                        const res = await updateRoom(id, game);
                        console.log(res);
                        navigate('/room/waiting/'+id);
                        // console.log('selected card', props.match.params)
                        Modal.destroyAll()
                    }
                }
            )
        } else {
            notification.error({ message: "Error", description: `You need to pick a card first !` });
        }
    }

    return (
        <>
            <div className="container">
                <h1>Select your card for the battle !</h1> 
                <Button type="primary" onClick={() => pickCard()} className="login-form-button">
                    SELECT FOR THE BATTLE
                </Button>
            </div>

            <ProfilPage isGame={true} btnCard={false}></ProfilPage>
        </>
    )
}

export default GamePrepare;