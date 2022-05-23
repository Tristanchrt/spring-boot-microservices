import React from 'react'
import { Form, Input, Button } from 'antd';
import { NavLink } from 'react-router-dom';
import { useNavigate } from 'react-router';
import { useSelector } from 'react-redux';
import { createGames } from '../../core/services/GameService';

export const CreateRoomPage = () => {

    const navigate = useNavigate();

    const current_user = useSelector(state => state.userReducer.user);
    
    const onFinish = async (values) => {
        const game = {
            name: values.name,
            bet: values.bet,
            player1: current_user.id
        };
        const res = await createGames(game);
        navigate("/room/prepare/"+res.id);
    };

    const onFinishFailed = (errorInfo) => {
        console.log('Failed:', errorInfo);
    };

    return (
        <div className="container">
            <h2 className="text-center">Create Page</h2>
            <Form
                name="basic"
                initialValues={{ remember: true }}
                onFinish={onFinish}
                onFinishFailed={onFinishFailed}
                autoComplete="off"
                layout="horizontal"
            >
                <Form.Item
                    name="name"
                    rules={[{ required: true, message: 'Please input your name !' }]}

                >
                    <Input
                        type="text"
                        placeholder="Name"
                    />

                </Form.Item>
                <Form.Item
                    name="bet"
                    rules={[{ required: true, message: 'Please input your bet!' }]}
                >
                    <Input
                        type="number"
                        placeholder="Bet"
                    />
                </Form.Item>

                <Form.Item>
                    <Button type="primary" htmlType="submit" className="login-form-button">
                        Create Room
                    </Button>
                    <NavLink to="/room" exact="true">
                        <Button type="default" className="login-form-button">
                            Cancel
                        </Button>
                    </NavLink>
                </Form.Item>
            </Form>
        </div>
    )
}

export default CreateRoomPage;