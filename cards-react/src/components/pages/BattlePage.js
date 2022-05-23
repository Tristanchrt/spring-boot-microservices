import React, { useEffect, useState } from 'react'
import CardTemplate from "../shared/CardTemplate";
import { useNavigate } from 'react-router';
import { Card, Tag, Button, Skeleton, Badge, Modal, InputNumber, Typography, notification } from 'antd';
import {
    BrowserRouter as Router,
    useParams
} from "react-router-dom";
import { useDispatch, useSelector } from "react-redux";
import { getGame, startBattle } from '../../core/services/GameService';
import { getCard } from '../../core/services/CardService';

export const BattlePage = () => {

    function getRandomColor() {
        var letters = '0123456789ABCDEF';
        var color = '#';
        for (var i = 0; i < 6; i++) {
            color += letters[Math.floor(Math.random() * 16)];
        }
        return color;
    }

    const current_user = useSelector(state => state.userReducer.user);

    const { id } = useParams();
    const navigate = useNavigate();
    const [game, setGame] = useState();
    const [myCard, setMyCard] = useState();
    const [otherCard, setOtherCard] = useState();

    useEffect(() => {
        notification.warning({ message: "Warning", description: `La partie à commencer ! Bonne chance !` })
    },[])

    useEffect(() => {

        const fetchCards = async () => {
            const game = await getGame(id);
            setGame(game)
            const card1 = await getCard(game.cardPlayer1)
            setMyCard(card1)
            const card2 = await getCard(game.cardPlayer2)
            setOtherCard(card2)

            setTimeout(() => {
                const start = startBattle(game)
                navigate('/room/end/'+id)
            }, 4000);
        }
        fetchCards();
    }, game)

    console.log(otherCard);


    // const a = setTimeout(async () => {
    //     console.log('EEEOLA '+ game)
    //     const game = await startBattle(game);
    // }, 2000)

    // a()

    return (
        <div className="container">
            <h3>Play room</h3>
            <div className="mt-5 w-50 d-flex justify-content-center align-items-center flex-column">
                {
                    myCard

                        ?
                        <div className="d-flex flex-column">
                            <h2>YOU</h2>
                            <Badge.Ribbon text={myCard.family} color="blue">
                                <Card
                                    hoverable
                                    className="w-40"
                                    cover={<img alt="example" className="p-3" src={myCard.image_url} />}
                                >
                                    <h4>{myCard.name}</h4>
                                    <div className="d-flex mb-4">
                                        <div className="align-item center">
                                            <Tag color={getRandomColor()}><b>HP</b> : {myCard.hp}</Tag>
                                            <Tag color={getRandomColor()}><b>Energy</b> : {myCard.energy}</Tag>
                                        </div>
                                        <div>
                                            <Tag color={getRandomColor()}><b>Attack</b> : {myCard.attack}</Tag>
                                            <Tag color={getRandomColor()}><b>Defense</b> : {myCard.defense}</Tag>
                                        </div>
                                    </div>
                                    <Card.Meta description={myCard.description} />
                                </Card>
                            </Badge.Ribbon>
                        </div>
                        :
                        <Skeleton className="w-100" size={"large"} loading={true} avatar active>
                            <CardTemplate />
                        </Skeleton>

                }

                <h1 className="my-4">VS</h1>
                {
                    otherCard ?

                        <Badge.Ribbon text={otherCard.family} color="blue">
                            <Card
                                hoverable
                                className="w-40"
                                cover={<img alt="example" className="p-3" src={otherCard.image_url} />}
                            >
                                <h4>{otherCard.name}</h4>
                                <div className="d-flex mb-4">
                                    <div className="align-item center">
                                        <Tag color={getRandomColor()}><b>HP</b> : {otherCard.hp}</Tag>
                                        <Tag color={getRandomColor()}><b>Energy</b> : {otherCard.energy}</Tag>
                                    </div>
                                    <div>
                                        <Tag color={getRandomColor()}><b>Attack</b> : {otherCard.attack}</Tag>
                                        <Tag color={getRandomColor()}><b>Defense</b> : {otherCard.defense}</Tag>
                                    </div>
                                </div>
                                <Card.Meta description={otherCard.description} />
                            </Card>
                        </Badge.Ribbon>

                        :
                        <Skeleton className="w-100" size={"large"} loading={true} avatar active>
                            <CardTemplate />
                        </Skeleton>

                }
            </div>

        </div>
    )
}

export default BattlePage;