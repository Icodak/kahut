<template>
  <q-page>

  <h3 class="row justify-evenly">Mes annonces</h3>

  <div class="q-ma-md absolute-right">
    <q-btn color="primary" icon="send" label="Publier une annonce" @click="annoncesLayout = true" />

    <q-dialog v-model="annoncesLayout">
        <q-layout view="Lhh lpR fff" container class="bg-white">
          <q-header class="bg-primary glossy">
            <q-toolbar>
              <q-toolbar-title>Nouvelle annonce</q-toolbar-title>
              <q-btn flat v-close-popup round dense icon="close" />
            </q-toolbar>
          </q-header>

          <q-page-container>
            <q-page padding>
              <q-form
                @submit="addOnSubmit"
                @reset="onReset"
                class="q-gutter-md">

                <q-btn-toggle
                  v-model="groupType"
                  spread
                  no-caps
                  toggle-color="primary"
                  color="white"
                  text-color="black"
                  :options="optionsType"
                />

                <q-input 
                  filled
                  v-model="title" 
                  label="Titre de l'annonce"
                  lazy-rules
                  :rules="[ val => val && val.length > 0 || 'Champ obligatoire']">
                  <template v-slot:prepend>
                    <q-icon name="title" />
                  </template>
                </q-input>

                <q-input 
                  filled
                  v-model="place" 
                  label="Adresse"
                  lazy-rules
                  :rules="[ val => val && val.length > 0 || 'Champ obligatoire']">
                  <template v-slot:prepend>
                    <q-icon name="place" />
                  </template>
                </q-input>

                <q-input
                  v-model="description"
                  filled
                  type="textarea"
                  label="Décriver votre logement"
                />

                <q-input
                  filled
                  type="number"
                  v-model="numberOfPeople"
                  label="Nombre maximum de personnes"
                  lazy-rules
                  :rules="[
                    val => val !== null && val !== '' || 'Champ obligatoire',
                    val => val > 0 && val < 30 || 'Nombre choisi incorrect'
                  ]"
                />

                <q-input
                  filled
                  type="number"
                  v-model="numberOfBedrooms"
                  label="Nombre de chambres"
                  lazy-rules
                  :rules="[
                    val => val !== null && val !== '' || 'Champ obligatoire',
                    val => val > 0 && val < 30 || 'Nombre choisi incorrect'
                  ]"
                />

                <q-input
                  filled
                  type="number"
                  v-model="numberOfBeds"
                  label="Nombre de lits simples"
                  lazy-rules
                  :rules="[
                    val => val !== null && val !== '' || 'Champ obligatoire',
                    val => val > 0 && val < 30 || 'Nombre choisi incorrect'
                  ]"
                />

                <q-input
                  filled
                  type="number"
                  v-model="numberOfDoubleBeds"
                  label="Nombre de lits doubles"
                  lazy-rules
                  :rules="[
                    val => val !== null && val !== '' || 'Champ obligatoire',
                    val => val > 0 && val < 30 || 'Nombre choisi incorrect'
                  ]"
                />

                <q-input
                  filled
                  type="number"
                  v-model="numberOfBathrooms"
                  label="Nombre de salles de bain"
                  lazy-rules
                  :rules="[
                    val => val !== null && val !== '' || 'Champ obligatoire',
                    val => val > 0 && val < 30 || 'Nombre choisi incorrect'
                  ]"
                />

                <div class="bg-grey-2 q-pa-sm rounded-borders">
                  <p class="text-weight-medium">Equipements présents :</p>
                  <q-option-group
                    v-model="group"
                    :options="options"
                    color="green"
                    type="checkbox"
                  />
                </div>

                <q-btn flat color="bg-secondary" icon="event" label="Choisissez les disponibilités" @click="displayDates = true" />
                <q-dialog v-model="displayDates">
                  <q-date v-model="days" range multiple />
                </q-dialog>

                <q-file 
                  color="teal" 
                  filled 
                  multiple
                  v-model="model" 
                  label="Photos">
                  <template v-slot:prepend>
                    <q-icon name="cloud_upload" />
                  </template>
                </q-file>
              

                <q-toggle v-model="accept" label="J'ai lu et j'accepte les conditions d'utilisation." />

                <div>
                  <q-btn label="Publier l'annonce" type="submit" color="primary"/>
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
    const title = ref(null)
    const place = ref(null)
    const description = ref(null)
    const numberOfPeople = ref(null)
    const numberOfBedrooms = ref(null)
    const numberOfBeds = ref(null)
    const numberOfDoubleBeds = ref(null)
    const numberOfBathrooms = ref(null)
    const accept = ref(false)

    return {
      annoncesLayout: ref(false),
      displayDates: ref(false),
      model: ref(null),
      title,
      place, 
      description,
      numberOfPeople,
      numberOfBedrooms,
      numberOfBeds,
      numberOfDoubleBeds,
      numberOfBathrooms,
      accept,

      groupType: ref(),

      optionsType: [
        {
          label: 'Maison',
          value: 'op1'
        },
        {
          label: 'Appartement',
          value: 'op2'
        },
        {
          label: 'Autre',
          value: 'op3'
        }
      ],

      group: ref([]),

      options: [
        {
          label: 'Jardin',
          value: 'op1'
        },
        {
          label: 'Piscine',
          value: 'op2'
        },
        {
          label: 'Parking',
          value: 'op3'
        },
        {
          label: 'Cuisine équipée',
          value: 'op4'
        },
        {
          label: 'Wifi',
          value: 'op5'
        },
        {
          label: 'Canapé convertible',
          value: 'op6'
        },
        {
          label: 'Machine à laver',
          value: 'op7'
        },
        {
          label: 'Lave-vaisselle',
          value: 'op8'
        },
        {
          label: 'Sèche cheveux',
          value: 'op9'
        },
        {
          label: 'Détecteur de fumée',
          value: 'op10'
        }
      ],

      addOnSubmit () {
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
        title.value = null
        place.value = null
        description.value = null
        numberOfPeople.value = null
        numberOfBedrooms.value = null
        numberOfBeds.value = null
        numberOfDoubleBeds.value = null
        numberOfBathrooms.value = null
        accept.value = false
      }
     }
  }
}
</script>