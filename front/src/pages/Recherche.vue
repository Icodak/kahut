<style lang="sass" scoped>
.my-card
  width: 30%
  max-width: 60%
</style>



<template>
  <q-page>
    <div class="q-pa-md">
      <div class ="column" style ="height: 100px;">

      <searchBarComponent> </searchBarComponent>
    </div>
    </div>



    <div class="q-pa-md row items-start q-gutter-md">


      <q-card class="my-card">
        <div class="row" style="margin:1%">
          <div class="col-4">




            <q-card-section class="q-pt-none">
              <div class="text-subtitle1">5 voyageurs</div>
              <div class="text-caption text-grey">

                {{housing}}

              </div>
            </q-card-section>
          </div>
          <div class="col-8" style="margin-top:10%; margin left:5%">

          </div>
        </div>
        <q-separator />
        <q-card-actions>

        </q-card-actions>
      </q-card>
    </div>

    <div class="q-pa-md row items-start q-gutter-md">
      <q-card class="my-card" v-for="data in housing" :key="data">
        <div class="row" style="margin:1%">
          <div class="col-4">
            <q-img
              style="max-width: 300px"
              :ratio="4 / 3"
              src="https://cdn.bioalaune.com/img/article/thumb/900x500/24466-10_maisons_magiques_au_coeur_de_la_nature_dans_lesquelles_vous_adoreriez_vivre_compressed.jpg"
            />

            <q-card-section >
              <div class="row no-wrap items-center col-3" >
                <div class="text-h9 ellipsis" >
{{data.title}}
</div>
              </div>


              <span class="text-caption text-grey q-ml-sm"></span>
            </q-card-section>


            <q-card-section class="q-pt-none">
              <div class="text-subtitle1"></div>
              <div class="text-caption text-grey">
                {{data.description}}
              </div>
            </q-card-section>
          </div>
          <div class="col-8 text-h4 ellipsis" style="margin-top:10%; margin left:5%">

                La Kahute de <br>
                <p class="text-h4">
                  à {{data.location}}
                  </p>

          </div>
        </div>
        <q-separator />
        <q-card-actions>
          <q-btn color="primary" icon="House" label="Avoir plus d'informations" to="/logement" />
        </q-card-actions>
      </q-card>
    </div>
  </q-page>
</template>

<script lang="ts">

import * as Vue from 'vue' // in Vue 3
import axios from 'axios'
import VueAxios from 'vue-axios'
import searchBarComponent from 'src/components/searchBar.vue';
import { onMounted, ref } from "vue";
import {api} from"src/boot/axios";
import destination from 'src/components/searchBar.vue';
import searchBarVue from 'src/components/searchBar.vue';
import { error } from 'console';
export default{

  components : {searchBarComponent},
setup(){
const housing = ref ({});
onMounted(async() => {
   const response = await api.post( "/query",
{destination : "Paris"}
)
housing.value = response.data;
})
console.log(housing.value)
    return {
      housing
    };
  }

};

  </script>
