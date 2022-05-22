import axios from 'axios'

const api = axios.create({ baseURL: 'http://localhost:8080' })

export async function register(firstName: string, lastName: string, email: string, password: string) {
  const personalInfo = JSON.stringify({
    firstName: firstName,
    lastName: lastName,
    email: email,
    password: password,
  });
  console.log(personalInfo)

  api
    .post("/api/registration",
    personalInfo, 
     {
      headers: {
        "Content-Type": "application/json",
      },
    })
    .then((response) => console.log(response));
}