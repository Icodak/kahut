import axios from 'axios'

const api = axios.create({ baseURL: 'http://localhost:8080' })

export async function getHomePage() {
    api.get('/api/page/home')
    .then(function (response) {
        console.log(response.data);
      })
      .catch(function (error) {
        // handle error
        console.log(error);
      });
}

export async function login(email : any, password: any) {``
    await api.post('/api/login', {
        withCredentials: true,
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        }
        }, {
        auth: {
          username: email,
          password: password
        }
      });
}