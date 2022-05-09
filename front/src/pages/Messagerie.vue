<template>
  <q-page>

    <h3 class="row justify-evenly">Mes messages</h3>

    <div class="q-pa-md" style="max-width: 350px">
    <q-list>
      <q-item
      clickable
      @click="openMessage">
        <q-item-section>
          <q-item-label>Harry Covert</q-item-label>
          <q-item-label caption lines="2">You : Thank you very much for the information !</q-item-label>
        </q-item-section>

        <q-item-section side top>
          <q-item-label caption>5 min ago</q-item-label>
          <q-icon name="" color="yellow" />
        </q-item-section>
      </q-item>

      <q-separator spaced inset />

      <q-item clickable v-ripple>
        <q-item-section>
          <q-item-label>Annie Versaire</q-item-label>
          <q-item-label caption lines="2">Annie : Yes there is wifi in the house.</q-item-label>
        </q-item-section>

        <q-item-section side top>
          <q-item-label caption>1 hour ago</q-item-label>
          <q-icon name="" color="yellow" />
        </q-item-section>
      </q-item>

      <q-separator spaced inset />

      <q-item clickable v-ripple>
        <q-item-section>
          <q-item-label>Sarah Croche</q-item-label>
          <q-item-label caption lines="2">You : Hope you will enjoy the trip !</q-item-label>
        </q-item-section>

        <q-item-section side top>
          <q-item-label caption>4 days ago</q-item-label>
          <q-icon name="" color="yellow" />
        </q-item-section>
      </q-item>

      <q-separator spaced inset />

      <q-item clickable v-ripple>
        <q-item-section>
          <q-item-label>Paul Ochon</q-item-label>
          <q-item-label caption lines="2">You : I'm glad you enjoyed the trip !</q-item-label>
        </q-item-section>

        <q-item-section side top>
          <q-item-label caption>03/04/2022</q-item-label>
          <q-icon name="" color="yellow" />
        </q-item-section>
      </q-item>

      <q-separator spaced inset />

      <q-item clickable v-ripple>
        <q-item-section>
          <q-item-label>Anne Onyme</q-item-label>
          <q-item-label caption lines="2">Anne : Hope to see you again !</q-item-label>
        </q-item-section>

        <q-item-section side top>
          <q-item-label caption>25/03/2022</q-item-label>
          <q-icon name="" color="yellow" />
        </q-item-section>
      </q-item>
    </q-list>
  </div>

  <div>
    <div style="width: 100%; max-width: 400px">
      <q-item v-model="openMessage" show-if-above>
      <q-chat-message
        label="Sunday, 19th"
      />

      <q-chat-message
        name="me"
        avatar="https://cdn.quasar.dev/img/avatar4.jpg"
        :text="['hey, how are you?']"
        sent
        stamp="7 minutes ago"
      />
      <q-chat-message
        name="Jane"
        avatar="https://cdn.quasar.dev/img/avatar3.jpg"
        :text="['doing fine, how r you?']"
        stamp="4 minutes ago"
      />
      </q-item>
    </div>
  </div>

  <div class="q-ma-md absolute-right">
    <q-btn color="primary" icon="message" label="Nouveau message" />
  </div>

  </q-page>


</template>


<script lang="ts">
import { defineComponent, ref } from 'vue';

export default defineComponent({
  name: 'Messagerie',

  setup () {
    const openMessage = ref(false)

    return {
      openMessage,
      toggle () {
        openMessage.value = !openMessage.value
      }
    }
  }
});
</script>
