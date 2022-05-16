import axios from 'axios'

const api = axios.create({ baseURL: 'http://localhost:8080' })

export async function register(firstName: any, lastName: any, email: any, password: any) {
    api.post('api/registration', {
        firstName: firstName,
        lastName: lastName,
        email: email,
        password: password
      })
      .then(function (response) {
        console.log(response);
      })
      .catch(function (error) {
        console.log(error);
      });
}