<template>
  <q-page>
    <div class="row" style="margin: 1%">
      <div class="col-8" style="margin-top:10%; margin left:5%;">
        <q-img style="max-width: 300px" :ratio="4 / 3" :src="housing.imageId" />
        <h6>{{ housing.title }}</h6>
        <p>
          {{ housing.description }}
        </p>
        <q-btn v-on:click="bookmark()"></q-btn>

        <div style="max-width: 350px">
          <q-list bordered>
            <q-title>
              <h6 class="q-ma-md text-center">{{ author.email }}</h6>
            </q-title>
            <q-item>
              <q-item-section style="font-weight: bold">{{author.description}}</q-item-section>
            </q-item>
            <q-item>
              <q-item-section avatar>
                <q-icon color="primary" name="mail" />
              </q-item-section>

              <q-item-section>{{ author.email }}</q-item-section>
            </q-item>

            <q-item>
              <q-item-section avatar>
                <q-icon color="primary" name="phone" />
              </q-item-section>

              <q-item-section>{{ author.phone }}</q-item-section>
            </q-item>
          </q-list>
        </div>
      </div>
    </div>
  </q-page>
</template>

<script setup>
import { onMounted, ref } from "vue";
import { api } from "src/boot/axios";
import { LocalStorage, SessionStorage } from "quasar";

const housing = ref({});
const author = ref({});
const token = LocalStorage.getItem("token");
const housingId = LocalStorage.getItem("housingId");

const bookmark = async () => {
  api.post(`housing/${housingId}/bookmark`,{}, {
    headers: {
      Authorization: `Bearer ${token}`,
    },
  });
};

onMounted(async () => {
  const response = await api.get(`housing/${housingId}`);
  housing.value = response.data;
  author.value = response.data.author

  console.log(housing.value);
   console.log(author.value);
  console.log(response.data);
});


</script>
