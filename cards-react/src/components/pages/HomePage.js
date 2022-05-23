import React from 'react'
import { Card } from 'antd';
import { ShopFilled, DollarCircleFilled, TrophyFilled } from '@ant-design/icons';
import { useNavigate } from 'react-router';
export const HomePage = (props) => {

    const navigate = useNavigate();

    return (

        <div className="row mx-0">
            <div className="col-md-4 p-5">
                <Card
                    hoverable
                    style={{ width: "100%" }}
                    cover={
                        <ShopFilled className="homepage-icon" />
                    }
                    onClick={() => navigate("/shop")}
                >
                    <Card.Meta title="Buy" description="Buy cards from other users" />
                </Card>
            </div>
            <div className="col-md-4 p-5">
                <Card
                    hoverable
                    style={{ width: "100%" }}
                    cover={<DollarCircleFilled className="homepage-icon" />}
                    onClick={() => navigate("/profil")}
                >
                    <Card.Meta title="Sell" description="Sell your cards in the shop to earn money" />
                </Card>
            </div>

            <div className="col-md-4 p-5">
                <Card
                    hoverable
                    style={{ width: "100%" }}
                    cover={<TrophyFilled className="homepage-icon" />}
                    onClick={() => navigate("/room")}
                >
                    <Card.Meta title="Play" description="Click here to play against one user" />
                </Card>
            </div>

        </div>

    )
}

export default HomePage