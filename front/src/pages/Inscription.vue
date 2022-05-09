<template>
  <q-page>
    <h3 class="row justify-evenly">Bienvenue sur Kahut ! </h3>

    <div class="row justify-evenly">

    <q-form
      @submit="subscribeOnSubmit"
      @reset="onReset"
      class="q-gutter-md"
    >

      <q-input
        filled
        v-model="Prénom"
        label="Prénom *"
        lazy-rules
        :rules="[ val => val && val.length > 0 || 'Please type something']"
      />

      <q-input
        filled
        v-model="Nom"
        label="Nom *"
        lazy-rules
        :rules="[ val => val && val.length > 0 || 'Please type something']"
      />

      <q-input
        filled
        v-model="naissance"
        label="Date de naissance *"
        mask="##/##/####"
        fill-mask
        lazy-rules
        :rules="[ val => val && val.length > 0 || 'Please type something']"
      >
      <template v-slot:prepend>
          <q-icon name="event" />
        </template>
      </q-input>

      <q-input
        filled
        v-model="téléphone"
        label="Numéro de téléphone *"
        lazy-rules
        :rules="[ val => val && val.length > 0 || 'Please type something']"
      >
      <template v-slot:prepend>
          <q-icon name="phone" />
        </template>
      </q-input>

      <q-input
        filled
        v-model="mail"
        label="Adresse mail *"
        lazy-rules
        :rules="[ val => val && val.length > 0 || 'Please type something',]"
      >
      <template v-slot:prepend>
          <q-icon name="mail" />
        </template>
      </q-input>

      <q-input 
        v-model="password" 
        filled :type="isPwd ? 'password' : 'text'" 
        label="Password *"
        lazy-rules
        :rules="[ 
            val => val && val.length > 0 || 'Please type something',
            val => val.length > 7 && val.length < 30 || 'Your password is not secure enough']"
      >
        <template v-slot:append>
          <q-icon
            :name="isPwd ? 'visibility_off' : 'visibility'"
            class="cursor-pointer"
            @click="isPwd = !isPwd"
          />
        </template>
      </q-input>

      <q-input 
        v-model="confirmPassword" 
        filled :type="isConfirmPwd ? 'password' : 'text'" 
        label="Confirm Password *"
        lazy-rules
        :rules="[ 
              val => val && val.length > 0 || 'Please type something',
              val => val == password || 'Wrong password confirmation']"
      >
        <template v-slot:append>
          <q-icon
            :name="isConfirmPwd ? 'visibility_off' : 'visibility'"
            class="cursor-pointer"
            @click="isConfirmPwd = !isConfirmPwd"
          />
        </template>
      </q-input>

      <q-toggle v-model="accept" label="J'ai lu et j'accepte les conditions d'utilisation." />

      <div>
        <q-btn label="Submit" type="submit" color="primary"/>
        <q-btn label="Reset" type="reset" color="primary" flat class="q-ml-sm" />
      </div>
    </q-form>

  </div>
  </q-page>

  
</template>

<script>
import { useQuasar } from 'quasar'
import { ref } from 'vue'

export default {
  setup () {
    const $q = useQuasar()

    const Prénom = ref(null)
    const Nom = ref(null)
    const naissance = ref(null)
    const téléphone = ref(null)
    const mail = ref(null)
    const password = ref(null)
    const confirmPassword = ref(null)
    const accept = ref(false)

    return {
      isPwd: ref(true),
      isConfirmPwd: ref(true),

      Prénom,
      Nom,
      naissance,
      téléphone,
      mail,
      password,
      confirmPassword,
      accept,

      subscribeOnSubmit () {
        if (accept.value !== true) {
          $q.notify({
            color: 'red-5',
            textColor: 'white',
            icon: 'warning',
            message: 'You need to accept the license and terms first'
          })
        }
        else {
          $q.notify({
            color: 'green-4',
            textColor: 'white',
            icon: 'cloud_done',
            message: 'Submitted'
          })
        }
      },

      onReset () {
        Prénom.value = null
        Nom.value = null
        naissance.value = null
        téléphone.value = null
        mail.value = null
        password.value = null
        confirmPassword.value = null
        accept.value = false
      }
    }
  }
}
</script>
