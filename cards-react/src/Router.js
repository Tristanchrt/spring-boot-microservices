import { Routes, Route } from "react-router-dom";
import { CreateRoomPage, HomePage, LoginPage, ProfilPage, BattlePage, GamePrepare, RegisterPage, RoomPage, ShopPage, WaitingRoom, EndGameRoom } from './components/pages/';
import RequireAuth from './components/shared/RequireAuth';

export const Router = () => {

    return (
        <Routes>
            <Route index exact path="/" element={<LoginPage />} />
            <Route exact path="/login" element={<LoginPage />} />
            <Route exact path="/register" element={<RegisterPage />} />
                
            <Route element={<RequireAuth />}>
                <Route exact path="/home" element={<HomePage />} />
                <Route exact path="/profil" element={<ProfilPage btnCard={true} />} />
                <Route exact path="/shop" element={<ShopPage />} />
                <Route exact path="/room" element={<RoomPage />} />
                <Route exact path="/room/create" element={<CreateRoomPage />} />
                <Route exact path="/room/waiting/:id" element={<WaitingRoom />} />
                <Route exact path="/room/end/:id" element={<EndGameRoom />} />
                <Route exact path="/room/prepare/:id" element={<GamePrepare />} />
                <Route exact path="/room/play/:id" element={<BattlePage />} />
            </Route>
        </Routes>
    )
}

export default Router;