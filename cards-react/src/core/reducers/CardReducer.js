const cardReducer = (state = { card: null, cards : [] }, action) => {
    switch (action.type) {
        case 'UPDATE_SELECTED_CARD':
            if (state?.card?.id === action?.card?.id) {
                return state;
            }
            return {...state, card: action.card };
        case 'UPDATE_CARDS_LIST':
            return { ...state,cards : action.cards}
        case 'RESET_CARD':
            return { ...state,cards : [], card : {}}
        default:
            return state
    }
}

export default cardReducer;