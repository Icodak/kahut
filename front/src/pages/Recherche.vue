<style lang="sass" scoped>
.my-card
  width: 100%
  max-width: 350px
</style>



<template>
  <q-page>
    <div class="q-pa-md">
      <div class ="column" style ="height: 100px;">

      <searchBarComponent> </searchBarComponent>
    </div>
    </div>



    <div class="q-pa-md row items-start q-gutter-md">

 <q-card class="my-card" flat bordered>
      <q-card-section horizontal>
        <q-card-section class="q-pt-xs" >
          <div class="text-overline"  >
MMMM
          </div>
          <div class="text-h5 q-mt-sm q-mb-xs" v-for="(data, index) in dataHousing" :key="index" >
{{data.id}}
          </div>
          <div class="text-caption text-grey">

          </div>
        </q-card-section>
  <q-card-section class="col-5 flex flex-center">
          <q-img
            class="rounded-borders"
            src="https://cdn.quasar.dev/img/parallax2.jpg"
          />
        </q-card-section>
      </q-card-section>

</q-card>

      <q-card class="my-card">
        <div class="row" style="margin:1%">
          <div class="col-4">
            <q-img
              style="max-width: 300px"
              :ratio="4 / 3"
              src="https://img.freepik.com/photos-gratuite/conception-appartement-studio-moderne-chambre-espace-vie_1262-12375.jpg?t=st=1652184716~exp=1652185316~hmac=925ec8f9ac803a9cd96d7b11b87e144b6b9b7c94ae363829992ab11b2fd88b5f&w=1800"
            />


            <q-btn label = "Afficher les infos"
            @submit="printData"></q-btn>


            <q-card-section>
              <div class="row no-wrap items-center col-8">
                <div class="text-h6 ellipsis">
                  Appartement 3 pièces en plein coeur de Paris
                </div>
              </div>

              <q-rating size="18px" v-model="stars" :max="5" color="primary" />
              <span class="text-caption text-grey q-ml-sm">4.2 (551)</span>
            </q-card-section>

            <q-card-section class="q-pt-none">
              <div class="text-subtitle1">5 voyageurs</div>
              <div class="text-caption text-grey">
                2 chambres . 1 lit double . 1 lit simple . 1 canapé
                convertible<br />
                Wifi . Chauffage . Télévision
              </div>
            </q-card-section>
          </div>
          <div class="col-8" style="margin-top:10%; margin left:5%">

          </div>
        </div>
        <q-separator />
        <q-card-actions>
          <q-btn color="primary" icon="House" label="Test"
          @click="printData" />
        </q-card-actions>
      </q-card>
    </div>

    <div class="q-pa-md row items-start q-gutter-md">
      <q-card class="my-card">
        <div class="row" style="margin:1%">
          <div class="col-4">
            <q-img
              style="max-width: 300px"
              :ratio="4 / 3"
              src="https://cdn.bioalaune.com/img/article/thumb/900x500/24466-10_maisons_magiques_au_coeur_de_la_nature_dans_lesquelles_vous_adoreriez_vivre_compressed.jpg"
            />

            <q-card-section>
              <div class="row no-wrap items-center col-8">
                <div class="text-h6 ellipsis">
Maison dans la forêt - 3 pièces                </div>
              </div>

              <q-rating size="18px" v-model="stars" :max="5" color="primary" />
              <span class="text-caption text-grey q-ml-sm">4.5 (57)</span>
            </q-card-section>


            <q-card-section class="q-pt-none">
              <div class="text-subtitle1">3 voyageurs</div>
              <div class="text-caption text-grey">
                2 chambres . 1 lit double . 1 lit simple<br />
                Chauffage . Télévision
              </div>
            </q-card-section>
          </div>
          <div class="col-8" style="margin-top:10%; margin left:5%">
            <p>
              Les infos sont :

            </p>
          </div>
        </div>
        <q-separator />
        <q-card-actions>
          <q-btn color="primary" icon="House" label="Check it out" />
        </q-card-actions>
      </q-card>
    </div>
  </q-page>
</template>

<script lang="ts">



import * as Vue from 'vue' // in Vue 3
import axios from 'axios'
import VueAxios from 'vue-axios'
import { ref } from 'vue';

import searchBarComponent from 'src/components/searchBar.vue';

export default {
  name: 'searBarComponent',
components: { searchBarComponent },
    data() {
       let dataHousing: []
        return {

            printData() {

                axios
                    .post("http://localhost:8080/api/query",
{
destination : "Paris"
 }                   ).then(response => {
                    console.log(response.data);
                    dataHousing = response.data;
                    console.log(JSON.stringify(dataHousing));


            });
            }
          }
}
}

  </script>
