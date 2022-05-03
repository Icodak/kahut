<template>
  <q-page>
    <div class="row">
      <div class="col q-mt-lg absolute-top bg-transparent">
        <q-avatar size="200px" class="q-mb-xl q-ml-lg">
          <img src="https://cdn.quasar.dev/img/avatar.png">
        </q-avatar>
      </div>
      <div class="absolute-top justify-evenly text-center">
        <h3>Stéphanie de Monaco</h3> 
        <h5>Cahutienne depuis 2020</h5>
      </div>
    </div>

    <div class="q-mb-xl q-pa-md absolute-bottom" style="max-width: 350px">
    <q-list bordered>
      <q-title>
        <h6 class="q-ma-md text-center">Contact</h6>
      </q-title>
      <q-item>
        <q-item-section avatar>
          <q-icon color="primary" name="mail" />
        </q-item-section>

        <q-item-section>stephanie.demonaco@gmail.com</q-item-section>
      </q-item>

      <q-item>
        <q-item-section avatar>
          <q-icon color="primary" name="phone" />
        </q-item-section>

        <q-item-section>0714536295</q-item-section>
      </q-item>

      <q-item>
        <q-item-section avatar>
          <q-icon color="primary" name="star" />
        </q-item-section>

        <q-item-section>4,8/5</q-item-section>
      </q-item>

      <q-item>
        <q-btn class="absolute-center" 
          color="primary" 
          icon="edit" 
          label="Modifier"
          :size="md" />
      </q-item>

    </q-list>
  </div>


  </q-page>

  
</template>

<script>

</script>
