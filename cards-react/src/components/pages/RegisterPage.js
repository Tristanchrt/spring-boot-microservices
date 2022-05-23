import React from 'react'
import { NavLink } from 'react-router-dom'
import { MinusOutlined } from "@ant-design/icons"
import { register } from '../../core/services/AuthService';
import { useNavigate } from "react-router-dom";
import { updateCurrentUser } from '../../core/actions/userAction';
import { useDispatch } from 'react-redux';
import { Form, Input, Button, Typography } from 'antd';

export const RegisterPage = () => {
    let navigate = useNavigate();
    const dispatch = useDispatch();
    const onFinish = async (values) => {

        await register(values).then(response => {
            dispatch(updateCurrentUser(response));
            return navigate("/home");
        });
    };

    const onFinishFailed = (errorInfo) => {
        console.log('Failed:', errorInfo);
    };

    return (
        <div className="container">
            <Typography.Title className="text-center">Register</Typography.Title>
            <div className="row">
                <div className="col-md-10 mx-auto d-block">
                    <Form
                        name="basic"
                        initialValues={{ remember: true }}
                        onFinish={onFinish}
                        onFinishFailed={onFinishFailed}
                        autoComplete="off"
                        layout="horizontal"
                        labelCol={{ span: 4 }}
                        wrapperCol={{ span: 24 }}
                    >
                        <Form.Item
                            name="firstname"
                            rules={[{ required: true, message: 'Please input your firstname!' }]}
                        >
                            <Input placeholder="Firstname" />
                        </Form.Item>
                        <Form.Item
                            name="lastname"
                            rules={[{ required: true, message: 'Please input your lastname!' }]}
                        >
                            <Input placeholder="Lastname" />
                        </Form.Item>
                        <Form.Item
                            name="email"
                            rules={[{ required: true, message: 'Please input your email!' }]}
                        >
                            <Input placeholder="Email" />
                        </Form.Item>

                        <Form.Item
                            name="password"
                            rules={[{ required: true, message: 'Please input your password!' }]}
                        >
                            <Input.Password placeholder="password" />
                        </Form.Item>
                        <Form.Item htmlType="submit" className="login-form-button">
                            <Button type="primary" htmlType="submit" className="login-form-button">
                                Register account
                            </Button>
                            <p className="text-center"><MinusOutlined /> or <MinusOutlined /></p>
                            <NavLink to="/login" exact="true">
                                <Button type="default" className="login-form-button">
                                    Login into your account
                                </Button>
                            </NavLink>
                        </Form.Item>
                    </Form>
                </div>
            </div>
        </div>
    );
}

export default RegisterPage;