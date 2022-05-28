<style>
.Aventures-h4 {
  color: #fdb807;
  text-align: center;
}

.q-input {
  border-color: #fdb807;
}

.separe {
  padding: 20px 20px;
}
</style>

<template>
  <q-page>
    <div class="separe"></div>

    <q-form ref="search" @submit="postData" class="q-gutter-md">
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
                  (val && val.length > 4) || 'Entrez une destination valide',
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
              :options= "optionsTravellers"
              label="Combien ?"
            />
          </div>

          <div class="col-1">
            <q-btn
              @submit="postData"

              type="submit"
              icon="search"
              color="orange"
              size="xl"
            />
          </div>
        </div>
      </div>
    </q-form>


  </q-page>
</template>

<script>
import axios from "axios";
import { ref } from "vue";

export default {
  name: 'searchBarComponent',


  setup() {
      const optionsDevoirs = ["S'occuper des animaux","S'occuper des plantes","Nettoyer la Maison","Entretenir le jardin"]
      const optionsLimitations = ["Interdiction de fumer","Interdit d'avoir des animaux","Les enfants de moins de 3 ans sont interdit","Pas de bruit après 20h"]
      const optionsTravellers = [1,2,,3,4,5,6,7,8,9,10]
      const dateGo =  ref(null)
      const dateBack =  ref(null)
      const numberTravellers =  ref(null)
      const destination = ref(null)






  return {

       multipleDevoirs : ref(null),
multipleLimitations : ref(null),
        dateGo,
        dateBack,
        numberTravellers,
        destination,
        optionsDevoirs,
        optionsLimitations,
        optionsTravellers,

    postData() {
      console.log(destination);
      axios
        .post("http://localhost:8080/api/query",

        {destination:destination.value}

        )
        .then((response) => {
          console.log(response.data);
          this.dataHousing = response.data ;
          // stocker le reponse data et le fournir à la page de recherche
        });
    }
}
  }

}

</script>
