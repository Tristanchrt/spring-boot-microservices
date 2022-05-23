import React, { useEffect } from 'react'
import List from "../shared/List";
import CardTemplate from "../shared/CardTemplate";
import { getMyCards } from '../../core/services/CardService';
import { useDispatch, useSelector } from 'react-redux';
import { updateCardsList } from '../../core/actions/cardAction';

export const ProfilPage = (props) => {

    const dispatch = useDispatch();
    const cards = useSelector(state => state.cardReducer.cards);

    useEffect(() => {
        const fetchCards = async () => {
            let cards = await getMyCards();
            console.log(cards);
            dispatch(updateCardsList(cards));
        }
        fetchCards();
    }, [])

    return (
        <div>
            {
                !props.isGame
                    ?
                    <h2 className="text-center">My Profile</h2>
                    :
                    <></>
            }
            <div className="row mt-5 mx-auto">
                <div className="col-md-10 mx-auto d-block">
                    <div className="row">
                        <div className="col-md-9">
                            <List dataSource={cards} />
                        </div>
                        <div className="col-md-3">

                            <CardTemplate btnCard={props.btnCard} buy={false} />
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default ProfilPage;