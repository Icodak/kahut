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

                <q-input 
                  filled
                  v-model="title" 
                  label="Title"
                  lazy-rules
                  :rules="[ val => val && val.length > 0 || 'Please type something']">
                  <template v-slot:prepend>
                    <q-icon name="title" />
                  </template>
                </q-input>

                <q-option-group
                  v-model="groupType"
                  :options="optionsType"
                  color="primary"
                />

                <q-input 
                  filled
                  v-model="place" 
                  label="Place"
                  lazy-rules
                  :rules="[ val => val && val.length > 0 || 'Please type something']">
                  <template v-slot:prepend>
                    <q-icon name="place" />
                  </template>
                </q-input>

                <q-input
                  v-model="description"
                  filled
                  type="textarea"
                  label="Describe your accomodation"
                />

                <q-input
                  filled
                  type="number"
                  v-model="numberOfPeople"
                  label="Number max of people"
                  lazy-rules
                  :rules="[
                    val => val !== null && val !== '' || 'Please a number max of people',
                    val => val > 0 && val < 30 || 'Please type a real number'
                  ]"
                />

                <q-input
                  filled
                  type="number"
                  v-model="numberOfBedrooms"
                  label="Number of bedrooms"
                  lazy-rules
                  :rules="[
                    val => val !== null && val !== '' || 'Please a number of bedrooms',
                    val => val > 0 && val < 30 || 'Please type a real number'
                  ]"
                />

                <q-input
                  filled
                  type="number"
                  v-model="numberOfBeds"
                  label="Number of beds"
                  lazy-rules
                  :rules="[
                    val => val !== null && val !== '' || 'Please a number of beds',
                    val => val > 0 && val < 30 || 'Please type a real number'
                  ]"
                />

                <q-input
                  filled
                  type="number"
                  v-model="numberOfBathrooms"
                  label="Number of bathrooms"
                  lazy-rules
                  :rules="[
                    val => val !== null && val !== '' || 'Please a number of bathrooms',
                    val => val > 0 && val < 30 || 'Please type a real number'
                  ]"
                />

                <q-option-group
                  v-model="group"
                  :options="options"
                  color="green"
                  type="checkbox"
                />

                <q-btn flat color="bg-secondary" icon="event" label="Chose dates" @click="displayDates = true" />
                <q-dialog v-model="displayDates">
                  <q-date v-model="days" range multiple />
                </q-dialog>

                <q-file 
                  color="teal" 
                  filled 
                  multiple
                  v-model="model" 
                  label="Pictures">
                  <template v-slot:prepend>
                    <q-icon name="cloud_upload" />
                  </template>
                </q-file>
              

                <q-toggle v-model="accept" label="I accept the license and terms" />

                <div>
                  <q-btn label="Publish" type="submit" color="primary"/>
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
      numberOfBathrooms,
      accept,

      groupType: ref(),

      optionsType: [
        {
          label: 'House',
          value: 'op1'
        },
        {
          label: 'Apartment',
          value: 'op2'
        },
        {
          label: 'Other',
          value: 'op3'
        }
      ],

      group: ref([]),

      options: [
        {
          label: 'Garden',
          value: 'op1'
        },
        {
          label: 'Swimming pool',
          value: 'op2'
        },
        {
          label: 'Parking',
          value: 'op3'
        },
        {
          label: 'Kitchen with equipments',
          value: 'op4'
        },
        {
          label: 'Wifi',
          value: 'op5'
        },
        {
          label: 'Smoke detector',
          value: 'op6'
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
        numberOfBathrooms.value = null
        accept.value = false
      }
     }
  }
}
</script>