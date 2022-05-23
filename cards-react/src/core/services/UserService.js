import BaseService from "./BaseService"
import { environment } from "../../environments/environment"


export const getUserById = (id) => {
    return BaseService.getInstance().get(`${environment.apiUrl}/user/${id}`).then((res) => res.data);
}
    