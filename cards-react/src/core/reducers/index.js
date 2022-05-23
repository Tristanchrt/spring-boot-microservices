import { combineReducers } from 'redux';
import userReducer from './UserReducer';
import cardReducer from './CardReducer';

const globalReducer = combineReducers({
    userReducer: userReducer,
    cardReducer: cardReducer,
});

export default globalReducer;