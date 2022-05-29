<template>
  <q-page>
    <div class="row" style="margin: 1%">
      <div class="col-4">
        <q-img
          style="max-width: 300px"
          :ratio="4 / 3"
          src="housing.images"
        />

        <q-card-section>
          <div class="row no-wrap items-center col-8">
            <div class="text-h6 ellipsis">
              {{ housing.title }}
            </div>
          </div>
          {{ housing.location }} <br />
          <q-rating size="18px" v-model="stars" :max="5" color="primary" />
          <span class="text-caption text-grey q-ml-sm">{{housing.stars}}</span>
        </q-card-section>

        <q-card-section class="q-pt-none">
          <div class="text-subtitle1">5 {{ numberOfPeople }} voyageurs</div>
          <div class="text-caption text-grey">
            2 {{ numberOfBedrooms }} chambres . 1 {{ numberOfBeds }} lit simple
            . 1 {{ numberOfDoubleBeds }} lit double <br />
            Wifi . Chauffage . Télévision
          </div>
        </q-card-section>

        <q-card-section class="q-pt-none">
          <div class="text-subtitle1">Equipements</div>
          <div class="text-caption text-grey">
            Canapé convertible . Machine à laver
          </div>
        </q-card-section>

        <q-card-section class="q-pt-none">
          <div class="text-subtitle1">Requêtes</div>
          <div class="text-caption text-grey">
            Arroser les plantes . Non-Fumeur . Chiens autorisés
          </div>
        </q-card-section>
      </div>
      <div class="col-8" style="margin-top:10%; margin left:5%;">
        <h6>Description</h6>
        <p>
          {{ housing.description }}
        </p>

<div style="max-width: 350px">
    <q-list bordered>
      <q-title>
        <h6 class="q-ma-md text-center"></h6>
      </q-title>
      <q-item>
        <q-item-section style="font-weight: bold;">{{housing.author.description}}</q-item-section>
      </q-item>
      <q-item>
        <q-item-section avatar>
          <q-icon color="primary" name="mail" />
        </q-item-section>

        <q-item-section>{{housing.author.email}}</q-item-section>
      </q-item>

      <q-item>
        <q-item-section avatar>
          <q-icon color="primary" name="phone" />
        </q-item-section>

        <q-item-section>{{housing.author.phone}}</q-item-section>
      </q-item>
    </q-list>

  </div>
  


      </div>
    </div>
  </q-page>
</template>

<script lang="ts">
import { onMounted, ref } from "vue";
import { api } from "src/boot/axios";

export default {
  setup () {
const housing = ref({});

onMounted(async () => {
  const response = await api.get(
    "housing/467fd92c-5fe2-4a67-ac7e-15bddb9fb01e"
  );
  housing.value = response.data;
})


    
console.log(housing)
    return {
      housing,
    };
  },
};
</script>