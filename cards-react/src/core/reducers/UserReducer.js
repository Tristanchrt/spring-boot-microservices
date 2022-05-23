const userReducer = (state = { user: {}, submitted_user: {} }, action) => {
    switch (action.type) {
        case 'UPDATE_CURRENT_USER':
            if(action.user.token){
                localStorage.setItem('token', action.user.token);
            }
            return { user: action.user, submitted_user: state.submitted_user };
        case 'SUBMIT_USER_ACTION': 
            console.log("User to Submit", action.user);
            return {user:state.user, submitted_user:action.user};
        default:
            return state;
    }
}

export default userReducer;