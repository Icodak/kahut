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
        LocalStorage.set("token", token);
      });
      getUser();
}

export async function getUser() {
    const token = LocalStorage.getItem("token")
    api
        .get("/api/user",  { headers: {"Authorization" : `Bearer ${token}`} })
        .then((response) => {
          console.log(response);
          console.log(response.data);
          LocalStorage.set("name", response.data.fullName);
          LocalStorage.set("description", response.data.description);
          LocalStorage.set("email", response.data.email);
          LocalStorage.set("phone", response.data.phone);
        });
        

}