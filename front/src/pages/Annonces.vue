<template>
  <q-page>
    <h3 class="row justify-evenly">Mes annonces</h3>

    <div class="q-pa-md row items-start q-gutter-md">
      <q-card class="my-card">
        <q-img
          :ratio="4 / 3"
          src="https://img.freepik.com/photos-gratuite/conception-appartement-studio-moderne-chambre-espace-vie_1262-12375.jpg?t=st=1652184716~exp=1652185316~hmac=925ec8f9ac803a9cd96d7b11b87e144b6b9b7c94ae363829992ab11b2fd88b5f&w=1800"
        />

        <q-card-section>
          <div class="row no-wrap items-center">
            <div class="col text-h6 ellipsis">
              Appartement 3 pièces en plein coeur de Paris
            </div>
          </div>

          <q-rating size="18px" v-model="stars" :max="5" color="primary" />
          <span class="text-caption text-grey q-ml-sm">4.2 (551)</span>
        </q-card-section>

        <q-card-section class="q-pt-none">
          <div class="text-subtitle1">5 voyageurs</div>
          <div class="text-caption text-grey">
            2 chambres . 1 lit double . 1 lit simple . 1 canapé convertible<br />
            Wifi . Chauffage . Télévision
          </div>
        </q-card-section>

        <q-separator />

        <q-card-actions>
          <q-btn icon="house" label="Disponible" />
          <q-btn color="primary" icon="edit" label="Modifier" />
        </q-card-actions>
      </q-card>
    </div>

    <div class="q-ma-md absolute-right">
      <q-btn
        color="primary"
        icon="add"
        label="Publier une annonce"
        @click="annoncesLayout = true"
      />

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
                class="q-gutter-md"
              >
                <q-btn-toggle
                  v-model="housingType"
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
                  :rules="[
                    (val) => (val && val.length > 0) || 'Champ obligatoire',
                  ]"
                >
                  <template v-slot:prepend>
                    <q-icon name="title" />
                  </template>
                </q-input>

                <q-input
                  filled
                  v-model="place"
                  label="Adresse"
                  lazy-rules
                  :rules="[
                    (val) => (val && val.length > 0) || 'Champ obligatoire',
                  ]"
                >
                  <template v-slot:prepend>
                    <q-icon name="place" />
                  </template>
                </q-input>

                <q-input
                  v-model="description"
                  filled
                  type="textarea"
                  label="Décrivez votre logement"
                >
                  <template v-slot:prepend>
                    <q-icon name="notes" />
                  </template>
                </q-input>

                <q-input
                  filled
                  type="number"
                  v-model="numberOfPeople"
                  label="Nombre maximum de personnes"
                  lazy-rules
                  :rules="[
                    (val) =>
                      (val !== null && val !== '') || 'Champ obligatoire',
                    (val) => (val > 0 && val < 30) || 'Nombre choisi incorrect',
                  ]"
                >
                  <template v-slot:prepend>
                    <q-icon name="group" />
                  </template>
                </q-input>

                <q-input
                  filled
                  type="number"
                  v-model="numberOfBedrooms"
                  label="Nombre de chambres"
                  lazy-rules
                  :rules="[
                    (val) =>
                      (val !== null && val !== '') || 'Champ obligatoire',
                    (val) => (val > 0 && val < 30) || 'Nombre choisi incorrect',
                  ]"
                >
                  <template v-slot:prepend>
                    <q-icon name="night_shelter" />
                  </template>
                </q-input>

                <q-input
                  filled
                  type="number"
                  v-model="numberOfBeds"
                  label="Nombre de lits simples"
                  lazy-rules
                  :rules="[
                    (val) =>
                      (val !== null && val !== '') || 'Champ obligatoire',
                    (val) => (val > 0 && val < 30) || 'Nombre choisi incorrect',
                  ]"
                >
                  <template v-slot:prepend>
                    <q-icon name="single_bed" />
                  </template>
                </q-input>

                <q-input
                  filled
                  type="number"
                  v-model="numberOfDoubleBeds"
                  label="Nombre de lits doubles"
                  lazy-rules
                  :rules="[
                    (val) =>
                      (val !== null && val !== '') || 'Champ obligatoire',
                    (val) => (val > 0 && val < 30) || 'Nombre choisi incorrect',
                  ]"
                >
                  <template v-slot:prepend>
                    <q-icon name="bed" />
                  </template>
                </q-input>

                <q-input
                  filled
                  type="number"
                  v-model="numberOfBathrooms"
                  label="Nombre de salles de bain"
                  lazy-rules
                  :rules="[
                    (val) =>
                      (val !== null && val !== '') || 'Champ obligatoire',
                    (val) => (val > 0 && val < 30) || 'Nombre choisi incorrect',
                  ]"
                >
                  <template v-slot:prepend>
                    <q-icon name="bathroom" />
                  </template>
                </q-input>

                <div class="bg-grey-2 q-pa-sm rounded-borders">
                  <p class="text-weight-medium">Equipements présents :</p>
                  <q-option-group
                    v-model="tagsOptions"
                    :options="options"
                    color="green"
                    type="checkbox"
                  />
                </div>

                <q-btn
                  flat
                  color="bg-secondary"
                  icon="event"
                  label="Choisissez les disponibilités"
                  @click="displayDates = true"
                />
                <q-dialog v-model="displayDates">
                  <q-date v-model="days" range multiple />
                </q-dialog>

                <q-file
                  color="teal"
                  filled
                  multiple
                  v-model="model"
                  label="Photos"
                >
                  <template v-slot:prepend>
                    <q-icon name="cloud_upload" />
                  </template>
                </q-file>

                <q-toggle
                  v-model="accept"
                  label="J'ai lu et j'accepte les conditions d'utilisation."
                />

                <div>
                  <q-btn
                    label="Publier l'annonce"
                    type="submit"
                    color="primary"
                  />
                  <q-btn
                    label="Reset"
                    type="reset"
                    color="primary"
                    flat
                    class="q-ml-sm"
                  />
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
import { ref } from "vue";
import { createHousing } from '../services/housing';

export default {
  setup() {
    const title = ref(null);
    const place = ref(null);
    const description = ref(null);
    const numberOfPeople = ref(null);
    const numberOfBedrooms = ref(null);
    const numberOfBeds = ref(null);
    const numberOfDoubleBeds = ref(null);
    const numberOfBathrooms = ref(null);
    const housingType = ref(null);
    const tagsOptions = ref([]);
    const accept = ref(false);

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

      housingType: ref("op1"),

      optionsType: [
        {
          label: "Maison",
          value: "op1",
        },
        {
          label: "Appartement",
          value: "op2",
        },
        {
          label: "Chambre",
          value: "op3",
        },
      ],

      tagsOptions,

      options: [
        {
          label: "Jardin",
          value: "jardin",
        },
        {
          label: "Piscine",
          value: "piscine",
        },
        {
          label: "Parking",
          value: "parking",
        },
        {
          label: "Cuisine équipée",
          value: "cuisine",
        },
        {
          label: "Wifi",
          value: "wifi",
        },
        {
          label: "Canapé convertible",
          value: "canapeConvertible",
        },
        {
          label: "Machine à laver",
          value: "machine",
        },
        {
          label: "Lave-vaisselle",
          value: "laveVaisselle",
        },
        {
          label: "Sèche cheveux",
          value: "secheCheveux",
        },
        {
          label: "Détecteur de fumée",
          value: "detecteurFumee",
        },
      ],

      addOnSubmit() {
        const tags = [];
        tags[0] = {
          tagName : "numberOfPeople",
          intValue : numberOfPeople.value
        };
        tags[1] = {
          tagName : "numberOfBedrooms",
          intValue : numberOfBedrooms.value
        };
        tags[2] = {
          tagName : "numberOfBeds",
          intValue : numberOfBeds.value
        };
        tags[3] = {
          tagName : "numberOfDoubleBeds",
          intValue : numberOfDoubleBeds.value
        };
        tags[4] = {
          tagName : "numberOfBathrooms",
          intValue : numberOfBathrooms.value
        };
        console.log(tagsOptions.value);
        tagsOptions.value.forEach(element => tags.push({
            tagName : element,
            boolValue : true
          }))
        createHousing(title.value, description.value, tags, place.value)
        console.log(tags);
      },

      onReset() {
        title.value = null;
        place.value = null;
        description.value = null;
        numberOfPeople.value = null;
        numberOfBedrooms.value = null;
        numberOfBeds.value = null;
        numberOfDoubleBeds.value = null;
        numberOfBathrooms.value = null;
        tagsOptions.value = [];
        accept.value = false;
      },
    };
  },
};
</script>
