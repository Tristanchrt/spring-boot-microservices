import React, { useState,useEffect } from 'react'
import { Card, Tag, Button, Skeleton, Badge, Modal, InputNumber, Typography, notification } from 'antd';
import { useDispatch, useSelector } from "react-redux";
import { buyCard, sellCard } from '../../core/services/TransactionService';
import { currentUser } from '../../core/services/AuthService';
import { updateCurrentUser } from '../../core/actions/userAction';
import { getBuyableCards, getMyCards } from '../../core/services/CardService';
import { updateCardsList } from '../../core/actions/cardAction';

export const CardTemplate = (props) => {
    const [price, setPrice] = useState(0);
    const [isModalVisible, setIsModalVisible] = useState(false);
    const dispatch = useDispatch();

    function getRandomColor() {
        var letters = '0123456789ABCDEF';
        var color = '#';
        for (var i = 0; i < 6; i++) {
            color += letters[Math.floor(Math.random() * 16)];
        }
        return color;
    }

    const selectedCard = useSelector(state => state.cardReducer.card);

    useEffect(() => {
        if(selectedCard != null) setPrice(selectedCard.price)
    })

    const changeCardPrice = (e) => {
        setPrice(e);
        console.log(e);
        console.log(price);
    }

    // eslint-disable-next-line no-unused-vars
    const openModal = () => {
        Modal.confirm(
            {
                width: "40vw",
                content: (
                    props.buy ?
                        (
                            <>
                                <Typography.Paragraph>Do you confirm buying this card ?</Typography.Paragraph>
                            </>
                        )
                        :
                        (
                            <>
                                <Typography.Paragraph>Price : </Typography.Paragraph>
                                <InputNumber addonBefore="+" addonAfter="$" defaultValue={selectedCard.price} value={selectedCard.price} onChange={changeCardPrice.bind(this)} />
                            </>
                        )


                ),
                title: props.buy ? "Please confirm this transaction" : "Sell your card",
                onOk: async () => {
                    if (props.buy) {
                        await confirmBuyCard()
                    } else {
                        await confirmSellCard()

                    }

                    Modal.destroyAll()
                }
            }
        )
    }

    const confirmSellCard = async () => {
        
        if (price) {
            try {
                await sellCard(selectedCard.id, price);
                notification.success({ message: "Success", description: `Your card in now in the shop for $${price}` })
                const cards = await getMyCards();
                dispatch(updateCardsList(cards))
                dispatchCurrentUserBalance();
            } catch (e) {
                notification.error({ message: "Error", description: `An error has occured while trying to sell your card` });
            }
        }
        setIsModalVisible(false);
    }

    const confirmBuyCard = async () => {
        try {
            await buyCard(selectedCard.id);
            notification.success({ message: "Success", description: `You are now the owner of this card` });
            const cards = await getBuyableCards();
            dispatch(updateCardsList(cards))
            dispatchCurrentUserBalance();
        } catch (e) {
            notification.error({ message: "Error", description: `An error has occured while trying to buy this card` });
        }
        setIsModalVisible(false);
    }

    const dispatchCurrentUserBalance = async () => {
        const user = await currentUser();
        dispatch(updateCurrentUser(user));
    }

    return (
        <>
            {
                selectedCard ?
                    <>

                        <Badge.Ribbon text={selectedCard.family} color="blue">
                            <Card
                                hoverable
                                className="w-100"
                                cover={<img alt="example" className="p-3" src={selectedCard.image_url} />}
                            >
                                <h4>{selectedCard.name}</h4>
                                <div className="d-flex mb-4">
                                    <div className="align-item center">
                                        <Tag color={getRandomColor()}><b>HP</b> : {selectedCard.hp}</Tag>
                                        <Tag color={getRandomColor()}><b>Energy</b> : {selectedCard.energy}</Tag>
                                    </div>
                                    <div>
                                        <Tag color={getRandomColor()}><b>Attack</b> : {selectedCard.attack}</Tag>
                                        <Tag color={getRandomColor()}><b>Defense</b> : {selectedCard.defense}</Tag>
                                    </div>
                                </div>
                                <Card.Meta description={selectedCard.description} />
                                {(!props.buy && props.btnCard) && <Button className="login-form-button mt-4" type="primary" onClick={() => setIsModalVisible(true)}>Sell this card</Button>}
                                {(props.buy && props.btnCard) && <Button className="login-form-button mt-4" type="primary" onClick={() => setIsModalVisible(true)}>Buy this card $({selectedCard.price})</Button>}
                            </Card></Badge.Ribbon>
                        <Modal title={props.buy ? "Please confirm this transaction" : "Sell your card"} visible={isModalVisible} onOk={props.buy ? confirmBuyCard : confirmSellCard} onCancel={() => setIsModalVisible(false)}>
                            {
                                props.buy ?
                                    <Typography.Paragraph>Do you confirm buying this card ?</Typography.Paragraph>

                                    :
                                    <>
                                        <Typography.Paragraph>Price : </Typography.Paragraph>
                                        <InputNumber addonBefore="+" addonAfter="$" defaultValue={selectedCard.price} onChange={setPrice} />
                                    </>
                            }
                        </Modal>
                    </>
                    :
                    <Skeleton className="w-100" size={"large"} loading={true} avatar active>
                        <CardTemplate />
                    </Skeleton>
            }

        </>
    )



}



export default CardTemplate;