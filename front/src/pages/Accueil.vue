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


    <h4 class="Aventures-h4">Quelques idées d'aventures !</h4>

    <div class="q-pa-md">
      <div class="q-col-gutter-md row items-start">
        <div class="col-3">
          <q-img
            :ratio="4 / 3"
            src="https://img.freepik.com/photos-gratuite/palau-national-barcelone-espagne-jardins-personnes-devant-ciel-nuageux_1268-17853.jpg?t=st=1652105882~exp=1652106482~hmac=69cdc1a6bd3db37a529f8d8424ff504f88f7113f4ed7f165b43649abe96579de&w=1060"
          >
            <div class="absolute-bottom text-subtitle1 text-center">
              Barcelone
            </div>
          </q-img>
        </div>

        <div class="col-3">
          <q-img
            :ratio="4 / 3"
            src="https://img.freepik.com/photos-gratuite/arc-triomphe-nuit-paris-france_268835-878.jpg?t=st=1652106209~exp=1652106809~hmac=5fd9451fec25847685b0224102d50c548c7676c35eeaa0c41cb784f7ca17aca9&w=996"
          >
            <div
              to="/inscription"
              clickable
              v-ripple
              class="absolute-bottom text-subtitle1 text-center"
            >
              Paris
            </div>
          </q-img>
        </div>

        <div class="col-3">
          <q-img
            :ratio="4 / 3"
            src="https://img.freepik.com/photos-gratuite/vue-panoramique-big-ben-pont-londres-royaume-uni_268835-1393.jpg?t=st=1652106695~exp=1652107295~hmac=fb4107f30ca27d9983a4129c53fb1f95fb439b8e3ef32e06f30f9542234a7f26&w=1060"
          >
            <div class="absolute-bottom text-subtitle1 text-center">
              Londres
            </div>
          </q-img>
        </div>

        <div class="col-3">
          <q-img
            :ratio="4 / 3"
            src="https://img.freepik.com/photos-gratuite/basilique-santa-maria-della-salud-venise_181624-27270.jpg?w=996&t=st=1652106919~exp=1652107519~hmac=4a1fb389b42483c1c497a75ebffae894693d9d0f2d12ea6db1c8644091bf677d"
          >
            <div class="absolute-bottom text-subtitle1 text-center">Rome</div>
          </q-img>
        </div>
      </div>
    </div>


  </q-page>
</template>
