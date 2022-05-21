import axios from 'axios'
import { LocalStorage, SessionStorage } from 'quasar'

const api = axios.create({ baseURL: 'http://localhost:8080' });

export async function login(email : string, password: string) {
    await api.post('/api/login', {}, {
        auth: {
          username: email,
          password: password
        }
      })
      .then((response) => {
        const token = response.data;
        SessionStorage.set("token", token);
      });
}

export async function getUser() {
    const token = SessionStorage.getItem("token")
    api
        .get("/api/user",  { headers: {"Authorization" : `Bearer ${token}`} })
        .then((response) => {
          console.log(response);
          console.log(response.data.map);
          SessionStorage.set("name", response.data.map.name);
          SessionStorage.set("email", response.data.map.email);
        });
        

}