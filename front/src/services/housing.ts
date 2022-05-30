import axios from 'axios'
import { LocalStorage, SessionStorage } from 'quasar'

const api = axios.create({ baseURL: 'http://localhost:8080' });

export async function createHousing(title : string, description : string, tags : object[], location : string) {
  const housing = JSON.stringify({
    title: title,
    description: description,
    tags : tags,
    location : location,
  });
  const token = LocalStorage.getItem("token")
  console.log(housing)

  api
    .post("/api/housing",
    housing,
     {
      headers: {
        "Content-Type": "application/json",
        "Authorization" : `Bearer ${token}`
      },
    })
    .then((response) => console.log(response));
}
