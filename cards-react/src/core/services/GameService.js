import axios from "axios"
import { environment } from "../../environments/environment"
import BaseService from "./BaseService";

export const getGames = () => {
    return BaseService.getInstance().get(`${environment.apiUrl}/games`).then((res) => res.data);
}
export const getGame = (id) => {
    return BaseService.getInstance().get(`${environment.apiUrl}/games/${id}`).then((res) => res.data);
}

export const createGames = (game) => {
    return BaseService.getInstance().post(`${environment.apiUrl}/games`, game).then((res) => res.data);
}

export const updateRoom = (id, game) => {
    return BaseService.getInstance().post(`${environment.apiUrl}/gamesUpdate/${id}`, game).then((res) => res.data);
}
export const startBattle = (game) => {
    return BaseService.getInstance().post(`${environment.apiUrl}/games/startBattle`, game).then((res) => res.data);
}
