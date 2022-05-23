export const selectedCard = (card) => {
    return { type: 'UPDATE_SELECTED_CARD', card: card }
}
export const resetCard = () => {
    return { type: 'RESET_CARD' }
}

export const updateCardsList = (cards) => {
    cards = cards.map((card) => { return { ...card, key: card.id } })
    return {type : 'UPDATE_CARDS_LIST', cards : cards}
}