import {
    Quasar,
    LocalStorage,
    SessionStorage
  } from 'quasar'
  
  app.use(Quasar, {
    plugins: {
      LocalStorage,
      SessionStorage
    }
  })