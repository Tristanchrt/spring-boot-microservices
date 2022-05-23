import React, { useEffect, useState } from 'react'
import { Table, Button } from 'antd';
import { useNavigate } from 'react-router';
import { getGames } from "../../core/services/GameService";

export const RoomPage = () => {

    const navigate = useNavigate();
    const [rooms, setRooms] = useState();

    const goToRoom = (room) => {
        navigate('/room/prepare/'+room)
    }

    useEffect(() => {
        const fetchCards = async () => {
            const gamesList = await getGames();
            setRooms(gamesList)
        }
        fetchCards();
    }, [])

    console.log(rooms)

    const columns = [
        {
            title: 'Room',
            dataIndex: 'name',
            key: 'name',
        },
        {
            title: 'Bet',
            dataIndex: 'bet',
            key: 'bet',
        },
        {
            title: '',
            dataIndex: 'id',
            key: 'id',
            render : (room) =>  <Button danger size="large" onClick={() => goToRoom(room)} type="primary">JOIN ROOM</Button>
        },
    ];

    return (
        <div className="container">
            <div className="room-list d-flex justify-content-between">
                <h3>Room list</h3>
                <Button size="large" onClick={() => navigate("/room/create")} type="primary">Create room</Button>
            </div>
                <Table pagination={false} dataSource={rooms} columns={columns} />;
        </div>
    )
}

export default RoomPage;