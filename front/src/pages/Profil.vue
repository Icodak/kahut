<template>
  <q-page>
    <div class="row">
      <div class="col q-mt-lg absolute-top bg-transparent">
        <q-avatar size="200px" class="q-mb-xl q-ml-lg">
          <img src="https://cdn.quasar.dev/img/avatar.png">
        </q-avatar>
      </div>
      <div class="absolute-top justify-evenly text-center">
        <h3>{{name}}</h3>
        <h6>{{description}}</h6> 
      </div>
    </div>

    <div class="q-mb-xl q-pa-md absolute-bottom" style="max-width: 350px">
    <q-list bordered>
      <q-title>
        <h6 class="q-ma-md text-center">Contact</h6>
      </q-title>
      <q-item>
        <q-item-section avatar>
          <q-icon color="primary" name="mail" />
        </q-item-section>

        <q-item-section>{{email}}</q-item-section>
      </q-item>

      <q-item>
        <q-item-section avatar>
          <q-icon color="primary" name="phone" />
        </q-item-section>

        <q-item-section>{{phone}}</q-item-section>
      </q-item>
    </q-list>

  </div>

  <div class="q-ma-md absolute-right">
      <q-btn color="primary" icon="edit" label="Modifier" @click="editLayout = true" />

    <q-dialog v-model="editLayout">
        <q-layout view="Lhh lpR fff" container class="bg-white">
          <q-header class="bg-primary glossy">
            <q-toolbar>
              <q-toolbar-title>Modifier les informations personnelles</q-toolbar-title>
              <q-btn flat v-close-popup round dense icon="close" />
            </q-toolbar>
          </q-header>

          <q-page-container>
            <q-page padding>
              <q-form
                @submit="editOnSubmit"
                @reset="onReset"
                class="q-gutter-md">

                <q-input
                  filled
                  v-model="téléphone"
                  label="Numéro de téléphone"
                >
                <template v-slot:prepend>
                    <q-icon name="phone" />
                  </template>
                </q-input>

                <q-input
                  filled
                  v-model="mail"
                  label="Adresse mail"
                >
                <template v-slot:prepend>
                    <q-icon name="mail" />
                  </template>
                </q-input>

                <q-input
                  filled
                  type="password"
                  v-model="oldPassword"
                  label="Type your password"
                >
                <template v-slot:prepend>
                    <q-icon name="key" />
                  </template>
                </q-input>

                <q-input
                  filled
                  type="password"
                  v-model="password"
                  label="New password"
                  lazy-rules
                  :rules="[ 
                      val => val.length > 7 && val.length < 30 || 'Your password is not secure enough']"
                >
                <template v-slot:prepend>
                    <q-icon name="key" />
                  </template>
                </q-input>

                <q-input
                  filled
                  type="password"
                  v-model="confirmPassword"
                  label="Confirm new password"
                  lazy-rules
                  :rules="[ 
                        val => val == password || 'Wrong password confirmation']"
                >
                <template v-slot:prepend>
                    <q-icon name="key" />
                  </template>
                </q-input>

                <div>
                  <q-btn label="Submit" type="submit" color="primary"/>
                  <q-btn label="Reset" type="reset" color="primary" flat class="q-ml-sm" />
                </div>
              </q-form>
            </q-page>
          </q-page-container>
        </q-layout>
      </q-dialog>
  </div>

  </q-page>

  
</template>

<script>
import { ref } from 'vue'
import { useQuasar } from 'quasar'

export default {
  setup () {
    const $q = useQuasar()
    const name = $q.localStorage.getItem("name")
    const description = $q.localStorage.getItem("description")
    const email = $q.localStorage.getItem("email")
    const phone = $q.localStorage.getItem("phone")

    const telephone = ref(null)
    const mail = ref(null)
    const oldPwd = ref(null)
    const password = ref(null)
    const confirmPassword = ref(null)
    const descriptionInput = ref(null);

    return {
      editLayout: ref(false),

      name,
      description,
      email,
      phone,

      telephone,
      mail,
      oldPwd,
      password,
      confirmPassword,
      descriptionInput,

      editOnSubmit () {
          
      },

      onReset () {
        telephone.value = null
        mail.value = null
        oldPwd.value = null
        password.value = null
        confirmPassword.value = null
        descriptionInput.value = null
      },


     }
  }
}
</script>