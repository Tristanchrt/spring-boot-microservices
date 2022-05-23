import React, { useEffect } from 'react'
import { getBuyableCards } from '../../core/services/CardService';
import List from "../shared/List";
import CardTemplate from "../shared/CardTemplate";
import { useDispatch, useSelector } from 'react-redux';
import { updateCardsList } from '../../core/actions/cardAction';

export const ShopPage = (props) => {
    const dispatch = useDispatch();
    const cards = useSelector(state => state.cardReducer.cards);
    console.log('cards updated', cards);
    useEffect(() => {
        const fetchCards = async () => {
            const cardsList = await getBuyableCards();
            console.log(cardsList)
            dispatch(updateCardsList(cardsList))
        }
        fetchCards();
    // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [])


    return (
        <div>
            <h2 className="text-center">Shop</h2>
            <div className="row mt-5 mx-auto">
                <div className="col-md-10 mx-auto d-block">
                    <div className="row">
                        <div className="col-md-9">
                            <List dataSource={cards} />
                        </div>
                        <div className="col-md-3">

                            <CardTemplate btnCard={true} buy={true}/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default ShopPage;