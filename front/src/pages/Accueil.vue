<style>


.Aventures-h4{
  color: #FDB807 ;
  text-align: center;
}

.q-input{

border-color :#FDB807 ;

}


.separe{
  padding:20px 20px;
}

</style>

<template>
  <q-page>

    <div class = "separe">



    </div>



<q-form
  action="/recherche" method="post"
   @submit="onSubmit"
    class="q-gutter-md"
    >
 <div class="barre_de_recherche">

      <div class="row">
        <div class="col-3">

            <q-input filled v-model="text" label="Où aller ?"
            lazy-rules
        :rules="[ val => val && val.length > 4 || 'Entrez une destination valide']"
            >
        <template v-slot:prepend>
          <q-icon filled name="place" />
        </template>
            </q-input>
        </div>

        <div class="col-2">
             <q-input v-model="date_aller" filled type="date" hint="Départ"
             lazy-rules
        :rules="[ date => date && date.length > 0 || 'Entrez une date de départ']"
        >
        <template v-slot:prepend>
          <q-icon name="event" />
        </template>
             </q-input>
        </div>


        <div class="col-2">
             <q-input v-model="date_retour" filled type="date" hint="Retour"
              lazy-rules
        :rules="[ date => date && date.length > 0 || 'Entrez une date de retour ']"
        >
        <template v-slot:prepend>
          <q-icon name="event" />
        </template>
             </q-input>
        </div>


        <div class="col-2">
             <q-select
            filled v-model="nombre_voyageurs"
            :options="options"
            label="Combien ?"

             />
        </div>

        <div class="col-1">
             <q-btn
             type = "submit"
             icon="search"
             color="orange"
             size="xl"
             />

        </div>
        </div>


    </div>

    </q-form>

      <h4 class="Aventures-h4">
        Quelques idées d'aventures !
      </h4>

    <div class="q-pa-md">
    <div class="q-col-gutter-md row items-start">
      <div class="col-3">
        <q-img :ratio="4/3" src="https://img.freepik.com/photos-gratuite/palau-national-barcelone-espagne-jardins-personnes-devant-ciel-nuageux_1268-17853.jpg?t=st=1652105882~exp=1652106482~hmac=69cdc1a6bd3db37a529f8d8424ff504f88f7113f4ed7f165b43649abe96579de&w=1060">
          <div class="absolute-bottom text-subtitle1 text-center">
            Barcelone
          </div>
        </q-img>
      </div>

      <div   class="col-3">
        <q-img :ratio="4/3"  src="https://img.freepik.com/photos-gratuite/arc-triomphe-nuit-paris-france_268835-878.jpg?t=st=1652106209~exp=1652106809~hmac=5fd9451fec25847685b0224102d50c548c7676c35eeaa0c41cb784f7ca17aca9&w=996">
          <div  to = "/inscription"
              clickable
              v-ripple class="absolute-bottom text-subtitle1 text-center">
            Paris

          </div>
        </q-img>

      </div>

      <div class="col-3">
        <q-img :ratio="4/3" src="https://img.freepik.com/photos-gratuite/vue-panoramique-big-ben-pont-londres-royaume-uni_268835-1393.jpg?t=st=1652106695~exp=1652107295~hmac=fb4107f30ca27d9983a4129c53fb1f95fb439b8e3ef32e06f30f9542234a7f26&w=1060">
          <div class="absolute-bottom text-subtitle1 text-center">
            Londres
          </div>
        </q-img>
      </div>

      <div class="col-3">
        <q-img :ratio="4/3" src="https://img.freepik.com/photos-gratuite/basilique-santa-maria-della-salud-venise_181624-27270.jpg?w=996&t=st=1652106919~exp=1652107519~hmac=4a1fb389b42483c1c497a75ebffae894693d9d0f2d12ea6db1c8644091bf677d">
          <div class="absolute-bottom text-subtitle1 text-center">
            Rome
          </div>
        </q-img>
      </div>
    </div>
  </div>





  </q-page>

</template>

<script>

import { ref } from 'vue'
import axios from 'axios'

export default {

  setup () {
    return {
      model: ref(null),
      options: [
        1, 2,3,4,5,6,7,8,9,10,11 ],
      date_aller: ref(''),
      date_retour: ref(''),
      text: ref('')
    };
    },
    data(){
      return{
       text: '',
       date_aller: '',
       date_retour: '',
       nombre_voyageurs: '',
      };
    },
    methods: {
      onSubmit(){
          axios.post(
            '/recherche',
            {text: this.text, date_aller: this.date_aller},
            ).then((response) => {
              console.log(response);
      });
    },
  },
  };


</script>
