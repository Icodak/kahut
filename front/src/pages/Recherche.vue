<style lang="sass" scoped>
.my-card
  width: 30%
  max-width: 60%
</style>



<template>
  <q-page>
    <div class="q-pa-md">
      <div class="column" style="height: 100px">
        <q-form ref="search" class="q-gutter-md" @submit="searchHousing()">
          <div class="barre_de_recherche">
            <div class="row">
              <div class="col-2">
                <q-input
                  filled
                  v-model="destination"
                  label="Où aller ?"
                  lazy-rules
                  :rules="[
                    (val) =>
                      (val && val.length > 3) ||
                      'Entrez une destination valide',
                  ]"
                >
                  <template v-slot:prepend>
                    <q-icon filled name="place" />
                  </template>
                </q-input>
              </div>

              <div class="col-1,5">
                <q-select
                  filled
                  v-model="multipleDevoirs"
                  multiple
                  :options="optionsDevoirs"
                  label="A faire"
                  style="width: 250px"
                />
              </div>

              <div class="col-1,5">
                <q-select
                  filled
                  v-model="multipleLimitations"
                  multiple
                  :options="optionsLimitations"
                  label="Limitations"
                  style="width: 250px"
                />
              </div>

              <div class="col-2">
                <q-select
                  filled
                  v-model="numberTravellers"
                  :options="optionsTravellers"
                  label="Combien ?"
                />
              </div>

              <div class="col-1">
                <q-btn

                  type="submit"
                  icon="search"
                  color="orange"
                  size="xl"
                />
              </div>
            </div>
          </div>
        </q-form>
      </div>
    </div>

    <div class="q-pa-md row items-start q-gutter-md">
      <q-card class="my-card" v-for="housing in housings" :key="housing">
        <div class="row" style="margin: 1%">
          <div class="col-4">
            <q-img
              style="max-width: 300px"
              :ratio="4 / 3"
              :src=housing.imageId
            />

            <q-card-section>
              <div class="row no-wrap items-center col-3">
                <div class="text-h9 ellipsis">
                  {{ housing.title }}
                </div>
              </div>

              <span class="text-caption text-grey q-ml-sm"></span>
            </q-card-section>

            <q-card-section class="q-pt-none">
              <div class="text-subtitle1"></div>
              <div class="text-caption text-grey">
                {{ housing.description }}
              </div>
            </q-card-section>
          </div>
          <div
            class="col-8 text-h4 ellipsis"
            style="margin-top:10%; margin left:5%"
          >
            La Kahute de <br />
            <p class="text-h4">à {{ housing.location }}</p>
          </div>
        </div>
        <q-separator />
        <q-card-actions>
          <q-btn
            color="primary"
            icon="House"
            label="Avoir plus d'informations"
            to="/logement"
            v-on:click="storeHousingId(housing.id)"
          />
        </q-card-actions>
      </q-card>
    </div>
  </q-page>
</template>

<script >
import { onMounted, ref } from "vue";
import { api } from "src/boot/axios";
import { LocalStorage, SessionStorage } from "quasar";

export default {
  setup() {
    const optionsDevoirs = [
      "S'occuper des animaux",
      "S'occuper des plantes",
      "Nettoyer la Maison",
      "Entretenir le jardin",
    ];
    const optionsLimitations = [
      "Interdiction de fumer",
      "Interdit d'avoir des animaux",
      "Les enfants de moins de 3 ans sont interdit",
      "Pas de bruit après 20h",
    ];
    const optionsTravellers = [1, 2, , 3, 4, 5, 6, 7, 8, 9, 10];
    const dateGo = ref(null);
    const dateBack = ref(null);
    const numberTravellers = ref(null);
    const destination = ref(null);

    const housings = ref({});

    const storeHousingId = (id) => {
      LocalStorage.set("housingId", id);
    };

    const searchHousing = () => {
            api
        .post("/query",

        {destination:destination.value}

        )
        .then((response) => {
          housings.value = response.data;
          console.log(response.data);

          // stocker le reponse data et le fournir à la page de recherche
        });
    }

    onMounted(async () => {
      const response = await api.get("/query");
      housings.value = response.data;
      console.log(housings.value)
    });

    console.log(housings.value);
    return {
      housings,
      storeHousingId,
      searchHousing,
      multipleDevoirs: ref(null),
      multipleLimitations: ref(null),
      dateGo,
      dateBack,
      numberTravellers,
      destination,
      optionsDevoirs,
      optionsLimitations,
      optionsTravellers,
    };
  },
};
</script>
