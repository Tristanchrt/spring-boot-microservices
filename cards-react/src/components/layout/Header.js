import { Menu } from 'antd';
import { BookOutlined, ShoppingCartOutlined, QqOutlined } from '@ant-design/icons';
import { useState } from 'react';
import { Button, Tag } from 'antd';
import { useDispatch, useSelector } from 'react-redux';
import { logOut } from '../../core/services/AuthService';
import { useNavigate } from 'react-router';
import { updateCurrentUser } from '../../core/actions/userAction';
import { resetCard } from '../../core/actions/cardAction';
export const Header = () => {
    const [currentTab, setTab] = useState("cards")
    const navigate = useNavigate();
    const dispatch = useDispatch();

    const changeTab = (e) => {
        setTab(e.key);
        if(e.key !== "logout"){
            navigate(e.key);
        }
    }

    const current_user = useSelector(state => state.userReducer.user);

    const logout = () => {
        logOut();
        dispatch(updateCurrentUser({}));
        dispatch(resetCard())
        navigate("/login");
    }
    
    return (
        <>
            <div className="d-flex flex-row w-100 mb-5">

                <Menu onClick={changeTab} selectedKeys={[currentTab]} mode="horizontal" className="w-100">

                    <Menu.Item key="/home">
                        <img src="/assets/pokemon.png" className="logo" alt="img"></img>
                    </Menu.Item>
                    <Menu.Item key="/profil" icon={<BookOutlined />}>
                        My Pokemon
                    </Menu.Item>
                    <Menu.Item key="/shop" icon={<ShoppingCartOutlined />}>
                        Shop
                    </Menu.Item>
                    <Menu.Item key="/room" icon={<QqOutlined />}>
                        Game
                    </Menu.Item>
                    <Menu.Item key="balance" disabled className="ms-auto">
                        <span className="mx-3">{current_user.firstname} {current_user.lastname}</span>
                        <Tag>$ {current_user.sold}</Tag>
                    </Menu.Item>
                    <Menu.Item disabled key="logout">
                        <Button type="primary" onClick={logout}>Log out</Button>
                    </Menu.Item>
                </Menu>

            </div>
        </>
    );
}
export default Header;