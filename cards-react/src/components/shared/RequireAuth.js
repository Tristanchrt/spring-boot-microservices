import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { Navigate, Outlet, useLocation } from "react-router";
import { updateCurrentUser } from "../../core/actions/userAction";
import { currentUser } from "../../core/services/AuthService";
const useAuth = () => {
    return localStorage.getItem('token') != null;
}



export const RequireAuth = ({ children }) => {
    let auth = useAuth();
    let location = useLocation();
    const dispatch = useDispatch();
    const current_user = useSelector(state => state.userReducer.user)

    useEffect(() => {
        if (auth && !current_user.id) {
            const setCurrentUser = async () => {
                const user = await currentUser();
                dispatch(updateCurrentUser(user));
            }
            setCurrentUser();
        }
    })
    return (
        !auth ? <Navigate to="/login" state={{ from: location }} /> :
            <Outlet />
    )
}
export default RequireAuth;