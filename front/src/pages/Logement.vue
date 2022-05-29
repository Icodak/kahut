<template>
  <q-page>
    <div class="row" style="margin: 1%">
      <div class="col-8" style="margin-top:10%; margin left:5%;">
        <h6>Description</h6>
        <p>
          {{ housing.description }}
        </p>

<div style="max-width: 350px">
    <q-list bordered>
      <q-title>
        <h6 class="q-ma-md text-center">{{owner.fullName}}</h6>
      </q-title>
      <q-item>
        <q-item-section style="font-weight: bold;">{{owner.description}}</q-item-section>
      </q-item>
      <q-item>
        <q-item-section avatar>
          <q-icon color="primary" name="mail" />
        </q-item-section>

        <q-item-section>{{owner.email}}</q-item-section>
      </q-item>

      <q-item>
        <q-item-section avatar>
          <q-icon color="primary" name="phone" />
        </q-item-section>

        <q-item-section>{{owner.phone}}</q-item-section>
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
const owner = ref({});

onMounted(async () => {
  const response = await api.get(
    "housing/eff9417c-828b-48fd-b382-852fe3d1b38c"
  );
  housing.value = response.data;
})

onMounted(async () => {
  const response2 = await api.get(
    "housing/eff9417c-828b-48fd-b382-852fe3d1b38c"
  );
  owner.value = response2.data.author;
})


    
console.log(housing)
    return {
      housing,
      owner,
    };
  },
};
</script>