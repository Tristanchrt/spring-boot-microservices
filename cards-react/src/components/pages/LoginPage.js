import React, { useEffect, useState }  from 'react';
import { NavLink } from 'react-router-dom';
import { UserOutlined, LockOutlined } from '@ant-design/icons';
import { login } from '../../core/services/AuthService';
import { useDispatch, useSelector } from 'react-redux';
import { updateCurrentUser } from '../../core/actions/userAction';
import { useNavigate } from "react-router-dom";
import { MinusOutlined } from "@ant-design/icons";
import { Form, Input, Button, Typography} from 'antd';
import { getUserById } from "../../core/services/UserService"

export const LoginPage = () => {
    const dispatch = useDispatch()
    const navigate = useNavigate();

    const current_user = useSelector(state => state.userReducer.user);
    
    
    const onFinish = (values) => {
        login(values).then(async res => {
            dispatch(updateCurrentUser(res));
        })
    };
    
    useEffect(() => {
        const fetchSold = async () => { 
            console.log('USER'+current_user.token)
            const user = await getUserById(current_user.id);
            console.log(user);
            dispatch(updateCurrentUser(user));
            // navigate("/home");
        }
        if(current_user.id)
            fetchSold()

    }, current_user.id)

    const onFinishFailed = (errorInfo) => {
        console.log('Failed:', errorInfo);
    };

    return (
        <div className="container">
            <Typography.Title className="text-center">Login</Typography.Title>
            <div className="row">
                <div className="col-md-10 mx-auto d-block">
                    <Form
                        name="basic"
                        initialValues={{ remember: true }}
                        onFinish={onFinish}
                        onFinishFailed={onFinishFailed}
                        autoComplete="off"
                        layout="horizontal"
                    >
                        <Form.Item
                            name="email"
                            rules={[{ required: true, message: 'Please input your Email !' }]}
                        >
                            <Input prefix={<UserOutlined className="site-form-item-icon" />} placeholder="Email" />
                        </Form.Item>
                        <Form.Item
                            name="password"
                            rules={[{ required: true, message: 'Please input your Password!' }]}
                        >
                            <Input
                                prefix={<LockOutlined className="site-form-item-icon" />}
                                type="password"
                                placeholder="Password"
                            />
                        </Form.Item>

                        <Form.Item>
                            <Button type="primary" htmlType="submit" className="login-form-button">
                                Log In
                            </Button>
                            <p className="text-center"><MinusOutlined /> or <MinusOutlined /></p>
                            <NavLink to="/register" exact="true">
                                <Button type="default" className="login-form-button">
                                    Register an account
                                </Button>
                            </NavLink>
                        </Form.Item>
                    </Form>
                </div>
            </div>
        </div >
    );
}

export default LoginPage;