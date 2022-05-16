<template>
  <q-page>

    <h3 class="row justify-evenly">Mes voyages</h3>

    <div class="q-pa-md row justify-center">
        <q-card class="my-card">
        <q-img :ratio="4/3" src="https://img.freepik.com/photos-gratuite/bagages-jaunes-plat-copie-espace_23-2148786124.jpg?t=st=1652185392~exp=1652185992~hmac=18f6528ecdde9880609951b54e0bfcf7f0cbdb40ae5f1398e3f79025a31a94e7&w=2000" />

        <q-card-section>
          <div class="row no-wrap items-center">
            <div class="col text-h6 ellipsis">
              Aucun voyage de prévu pour le moment ?
            </div>
          </div>
        </q-card-section>

         <q-separator />

          <q-card-actions class="justify-center">
            <q-btn color="primary" to="/" icon="card_travel" label="Lancer une recherche" />
          </q-card-actions>
        </q-card>
  </div>

  </q-page>

  
</template>

<script>

</script>
