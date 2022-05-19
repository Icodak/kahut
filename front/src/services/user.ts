import axios from 'axios'

const api = axios.create({ baseURL: 'http://localhost:8080' });

export let token = "";

export async function login(email : string, password: string) {
    await api.post('/api/login', {}, {
        auth: {
          username: email,
          password: password
        }
      })
      .then((response) => {
        token = response.data;
        console.log(token);
      });
}

export async function getUser(token : string) {
    const head ={ headers: { 'Authorization': "Bearer " + token} }
    api
        .get("/api/user",  head)
        .then((response) => console.log(response));

}