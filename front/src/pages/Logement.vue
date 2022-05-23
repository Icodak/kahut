<template>
  <q-page>
    <h3 class="row justify-evenly">
      Appartement 3 pièces en plein coeur de Paris
    </h3>

    <q-img
      style="max-width: 300px"
      :ratio="4 / 3"
      src="https://img.freepik.com/photos-gratuite/conception-appartement-studio-moderne-chambre-espace-vie_1262-12375.jpg?t=st=1652184716~exp=1652185316~hmac=925ec8f9ac803a9cd96d7b11b87e144b6b9b7c94ae363829992ab11b2fd88b5f&w=1800"
    />

    <div class="row no-wrap items-center">
      <div class="col text-h6 ellipsis">
        Appartement 3 pièces en plein coeur de Paris
      </div>
    </div>

    <q-rating size="18px" v-model="stars" :max="5" color="primary" />
    <span class="text-caption text-grey q-ml-sm">4.2 (551)</span>

    <q-card-section class="q-pt-none">
      <div class="text-subtitle1">5 voyageurs</div>
      <div class="text-caption text-grey">
        2 chambres . 1 lit double . 1 lit simple . 1 canapé convertible<br />
        Wifi . Chauffage . Télévision
      </div>
    </q-card-section>

    <q-separator />

    <q-card-actions>
      <q-btn icon="house"  label="Disponible" />
      <q-btn color="primary" icon="edit" label="Modifier" />
    </q-card-actions>
  </q-page>
</template>

<script>
</script>