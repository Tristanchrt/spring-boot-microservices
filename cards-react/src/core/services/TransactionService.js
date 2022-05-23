import { environment } from "../../environments/environment";
import BaseService from "./BaseService";


export const buyCard = (id) => {
    return BaseService.getInstance().post(`${environment.apiUrl}/transaction/buy/${id}`).then((res) => res.data);
}

export const sellCard = (cardId, price) => {
    return BaseService.getInstance().post(`${environment.apiUrl}/transaction/sell/${cardId}`, {price}).then(res => res.data);
}

export const cancelSellCard = (cardId) => {
    return BaseService.getInstance().put(`${environment.apiUrl}/transaction/sell/${cardId}`, {}).then(res => res.data);
}
