<template>
  <q-page>
    <h3 class="row justify-evenly">Bienvenue sur Kahut ! </h3>

    <div class="row justify-evenly">

    <div class="q-pa-md">
    <q-stepper
      v-model="step"
      vertical
      color="primary"
      animated
    >

      <q-step
        :name="1"
        title="Informations personnelles"
        icon="settings"
        :done="step > 1"
      >

      <p>Veuillez saisir vos informations personnelles nécessaires à l'inscription <br/> sur la plateforme. 
        <br/>Tous les champs sont obligatoires.</p>

        <q-input
        filled
        v-model="firstName"
        label="Prénom *"
        lazy-rules
        :rules="[ val => val && val.length > 0 || 'Champ obligatoire']"
      />

      <q-input
        filled
        v-model="lastName"
        label="Nom *"
        lazy-rules
        :rules="[ val => val && val.length > 0 || 'Champ obligatoire']"
      />

      <q-input
        filled
        v-model="naissance"
        label="Date de naissance *"
        mask="##/##/####"
        fill-mask
        lazy-rules
        :rules="[ val => val && val.length > 0 || 'Champ obligatoire']"
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
        :rules="[ val => val && val.length > 0 || 'Champ obligatoire']"
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
        :rules="[ val => val && val.length > 0 || 'Champ obligatoire',]"
      >
      <template v-slot:prepend>
          <q-icon name="mail" />
        </template>
      </q-input>

        <q-stepper-navigation>
          <q-btn 
            @click="step = 2" 
            color="primary" 
            label="Continuer"/>
        </q-stepper-navigation>
      </q-step>

      <q-step
        :name="2"
        title="Mot de passe"
        icon="key"
        :done="step > 2"
      >
        <p>Veuillez choisir un mot de passe. <br/>
        Votre mot de passe doit contenir minimum 8 caractères et doit contenir <br/>
          au moins une majuscule, une minuscule et un caractère spécial.</p>

        <q-input 
        v-model="password" 
        filled :type="isPwd ? 'password' : 'text'" 
        label="Mot de passe *"
        lazy-rules
        :rules="[ 
            val => val && val.length > 0 || 'Champ obligatoire',
            val => val.length > 7 && val.length < 30 || 'Mot de passe non sécurisé']"
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
        label="Confirmation mot de passe *"
        lazy-rules
        :rules="[ 
              val => val && val.length > 0 || 'Champ obligatoire',
              val => val == password || 'Confirmation de mot de passe incorrecte']"
      >
        <template v-slot:append>
          <q-icon
            :name="isConfirmPwd ? 'visibility_off' : 'visibility'"
            class="cursor-pointer"
            @click="isConfirmPwd = !isConfirmPwd"
          />
        </template>
      </q-input>

        <q-stepper-navigation>
          <q-btn @click="step = 3" color="primary" label="Continuer" />
          <q-btn flat @click="step = 1" color="primary" label="Back" class="q-ml-sm" />
        </q-stepper-navigation>
      </q-step>

      <q-step
        :name="3"
        title="Photo de profil"
        icon="photo"
      >

      <p>Veuillez choisir une photo de profil. <br/>
      Votre photo ne doit pas dépasser les 5Mo. Vérifier la taille de votre photo <br/> avant importation.</p>
        <q-file
          v-model="file"
          label="Importer"
          filled
          style="max-width: 500px"
        >
        <template v-slot:prepend>
          <q-icon name="attach_file" />
        </template>
      </q-file>

        <q-stepper-navigation>
          <q-btn @click="step= 4" color="primary" label="Continuer" />
          <q-btn flat @click="step = 2" color="primary" label="Back" class="q-ml-sm" />
        </q-stepper-navigation>
      </q-step>

      <q-step
        :name="4"
        title="Conditions générales d'utilisation"
        icon="description"
      >

      <p>Veuillez lire et accepter les conditions générales d'utilisation.</p>

      <q-btn label="Conditions générales d'utilisation" icon="subject" color="secondary" @click="fixed = true" /><br/>

      <q-dialog v-model="fixed">
        <q-card>
          <q-card-section>
            <div class="text-h6">Conditions générales d'utilisation : </div>
          </q-card-section>

          <q-separator />

          <q-card-section style="max-height: 50vh" class="scroll">
            <p v-for="n in 15" :key="n">Lorem ipsum dolor sit amet consectetur adipisicing elit. Rerum repellendus sit voluptate voluptas eveniet porro. Rerum blanditiis perferendis totam, ea at omnis vel numquam exercitationem aut, natus minima, porro labore.</p>
          </q-card-section>

          <q-separator />

          <q-card-actions align="right">
            <q-btn flat label="Accept" color="primary" v-close-popup @click="accept = true"/>
          </q-card-actions>
        </q-card>
      </q-dialog>
      <br/>
       <q-toggle v-model="accept" disable label="J'ai lu et j'accepte les conditions d'utilisation." />
        

        <q-stepper-navigation>
          <q-btn @click="subscribeOnSubmit" color="primary" label="Envoyer" />
          <q-btn flat @click="step = 3" color="primary" label="Back" class="q-ml-sm" />
        </q-stepper-navigation>
      </q-step>
    </q-stepper>
  </div>

  </div>
  </q-page>

  
</template>

<script>
import { useQuasar } from 'quasar'
import { ref } from 'vue'
import { register } from '../services/registration';

export default {
  setup () {
    const $q = useQuasar()

    const firstName = ref(null)
    const lastName = ref(null)
    const naissance = ref(null)
    const téléphone = ref(null)
    const mail = ref(null)
    const password = ref(null)
    const confirmPassword = ref(null)
    const accept = ref(false)

    return {
      isPwd: ref(true),
      isConfirmPwd: ref(true),
      step: ref(1),

      firstName,
      lastName,
      naissance,
      téléphone,
      mail,
      password,
      confirmPassword,
      file: ref(null),
      fixed: ref(false),
      accept,

      subscribeOnSubmit () {
        register(firstName, lastName, mail, password);
      },

      onReset () {
        firstName.value = null
        lastName.value = null
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
