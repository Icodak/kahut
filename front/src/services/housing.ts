import axios from 'axios'
import { LocalStorage, SessionStorage } from 'quasar'

const api = axios.create({ baseURL: 'http://localhost:8080' });

export async function createHousing(title : string, description : string, tags : object[], location : string) {
  const housing = JSON.stringify({
    title: title,
    description: description,
    author: {
      "fullName" : LocalStorage.getItem("name"),
      "description" : LocalStorage.getItem("description"),
      "email" : LocalStorage.getItem("email"),
      "phone" : LocalStorage.getItem("phone")
    },
    tags : tags,
    location : location,
  });
  console.log(housing)

  api
    .post("/api/housing",
    housing, 
     {
      headers: {
        "Content-Type": "application/json",
      },
    })
    .then((response) => console.log(response));
}