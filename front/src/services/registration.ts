import axios from 'axios'

const api = axios.create({ baseURL: 'http://localhost:8080' })

export async function register(firstName: string, lastName: string, description: string, email: string, phone: string, password: string) {
  const personalInfo = JSON.stringify({
    firstName: firstName,
    lastName: lastName,
    description: description,
    email: email,
    phone: phone,
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