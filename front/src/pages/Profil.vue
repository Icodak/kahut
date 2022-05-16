<template>
  <q-page>
    <div class="row">
      <div class="col q-mt-lg absolute-top bg-transparent">
        <q-avatar size="200px" class="q-mb-xl q-ml-lg">
          <img src="https://cdn.quasar.dev/img/avatar.png">
        </q-avatar>
      </div>
      <div class="absolute-top justify-evenly text-center">
        <h3>Stéphanie de Monaco</h3> 
        <h5>Cahutienne depuis 2020</h5>
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

        <q-item-section>stephanie.demonaco@gmail.com</q-item-section>
      </q-item>

      <q-item>
        <q-item-section avatar>
          <q-icon color="primary" name="phone" />
        </q-item-section>

        <q-item-section>0714536295</q-item-section>
      </q-item>

      <q-item>
        <q-item-section avatar>
          <q-icon color="primary" name="star" />
        </q-item-section>

        <q-item-section>4,8/5</q-item-section>
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
                  v-model="password"
                  label="Password"
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
                  label="Confirm Password"
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

export default {
  setup () {

    const telephone = ref(null)
    const mail = ref(null)
    const password = ref(null)
    const confirmPassword = ref(null)

    return {
      editLayout: ref(false),

      telephone,
      mail,
      password,
      confirmPassword,

      editOnSubmit () {

      },

      onReset () {
        telephone.value = null
        mail.value = null
        password.value = null
        confirmPassword.value = null
      }
     }
  }
}
</script>