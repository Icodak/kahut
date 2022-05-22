<template>
  <q-page>
    <div class="q-pa-md row items-start q-gutter-md">
      <q-card class="my-card">
        <div class="row" style="margin: 1%">
          <div class="col-4">
            <q-img
              style="max-width: 300px"
              :ratio="4 / 3"
              src="https://img.freepik.com/photos-gratuite/conception-appartement-studio-moderne-chambre-espace-vie_1262-12375.jpg?t=st=1652184716~exp=1652185316~hmac=925ec8f9ac803a9cd96d7b11b87e144b6b9b7c94ae363829992ab11b2fd88b5f&w=1800"
            />

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
            <p>
              Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non
              risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing
              nec, ultricies sed, dolor. Cras elementum ultrices diam. Maecenas
              ligula massa, varius a, semper congue, euismod non, mi. Proin
              porttitor, orci nec nonummy molestie, enim est eleifend mi, non
              fermentum diam nisl sit amet erat. Duis semper. Duis arcu massa,
              scelerisque vitae, consequat in, pretium a, enim. Pellentesque
              congue. Ut in risus volutpat libero pharetra tempor. Cras
              vestibulum bibendum augue. Praesent egestas leo in pede. Praesent
              blandit odio eu enim. Pellentesque sed dui ut augue blandit
              sodales. Vestibulum ante ipsum primis in faucibus orci luctus et
              ultrices posuere cubilia Curae; Aliquam nibh. Mauris ac mauris sed
              pede pellentesque fermentum. Maecenas adipiscing ante non diam
              sodales hendrerit.
            </p>
          </div>
        </div>
        <q-separator />
        <q-card-actions>
          <q-btn color="primary" icon="house" label="Check it out" />
        </q-card-actions>
      </q-card>
    </div>

    <div class="q-pa-md row items-start q-gutter-md">
      <q-card class="my-card">
        <div class="row" style="margin: 1%">
          <div class="col-4">
            <q-img
              style="max-width: 300px"
              :ratio="4 / 3"
              src="https://cdn.bioalaune.com/img/article/thumb/900x500/24466-10_maisons_magiques_au_coeur_de_la_nature_dans_lesquelles_vous_adoreriez_vivre_compressed.jpg"
            />

            <q-card-section>
              <div class="row no-wrap items-center col-8">
                <div class="text-h6 ellipsis">
                  Maison dans la forêt - 3 pièces
                </div>
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
              Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non
              risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing
              nec, ultricies sed, dolor. Cras elementum ultrices diam. Maecenas
              ligula massa, varius a, semper congue, euismod non, mi. Proin
              porttitor, orci nec nonummy molestie, enim est eleifend mi, non
              fermentum diam nisl sit amet erat. Duis semper. Duis arcu massa,
              scelerisque vitae, consequat in, pretium a, enim. Pellentesque
              congue. Ut in risus volutpat libero pharetra tempor. Cras
              vestibulum bibendum augue. Praesent egestas leo in pede. Praesent
              blandit odio eu enim. Pellentesque sed dui ut augue blandit
              sodales. Vestibulum ante ipsum primis in faucibus orci luctus et
              ultrices posuere cubilia Curae; Aliquam nibh. Mauris ac mauris sed
              pede pellentesque fermentum. Maecenas adipiscing ante non diam
              sodales hendrerit.
            </p>
          </div>
        </div>
        <q-separator />
        <q-card-actions>
          <q-btn color="primary" icon="house" label="Check it out" />
        </q-card-actions>
      </q-card>
    </div>
  </q-page>
</template>

<script>
</script>
