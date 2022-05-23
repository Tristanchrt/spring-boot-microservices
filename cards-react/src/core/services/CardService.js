import { environment } from "../../environments/environment";
import BaseService from "./BaseService";


export const getCards = () => {
    return BaseService.getInstance().get(`${environment.apiUrl}/cards`).then((res) => res.data);
}


export const getCard = (id) => {
    return BaseService.getInstance().get(`${environment.apiUrl}/card/${id}`).then((res) => res.data);
}

export const getMyCards = () => {
    return BaseService.getInstance().get(`${environment.apiUrl}/cards/my`).then((res) => res.data);
}

export const createCard = (card) => {
    return BaseService.getInstance().post(`${environment.apiUrl}/card`, card).then((res) => res.data);
}


export const deleteCard = (id) => {
    return BaseService.getInstance().delete(`${environment.apiUrl}/card/${id}`,).then((res) => res.data);
}

export const getBuyableCards = () => {
    return BaseService.getInstance().get(`${environment.apiUrl}/cards/buyable`).then((res) => res.data);
}