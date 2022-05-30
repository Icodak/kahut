<template>
  <div v-for="message in messages" :key="message">
    <p>Author {{ message.author }}</p>
       <p>Date {{ message.date }}</p>
    <p>Message: {{ message.message }}</p>
  </div>
  <form @submit.prevent="submit">
    <input
      class="form-control"
      placeholder="Write a message"
      v-model="message"
    />
  </form>
</template>

<script setup>
import { onMounted, ref } from "vue";
import Pusher from "pusher-js";
import { api } from "src/boot/axios";
import { LocalStorage, SessionStorage } from "quasar";


const messages = ref([]);
const message = ref("");
const recipient = LocalStorage.getItem("recipient")
const token = LocalStorage.getItem("token")
const conversationUUID = LocalStorage.getItem("conversationUUID")

const submit = async () => {
  console.log("called")
  await api.post(
    "/message",
    { message: message.value, recipient: recipient },
    {
      headers: {
        Authorization:
          `Bearer ${token}`,
      },
    }
  );
  message.value = "";
};

onMounted(async () => {
  const response = await api.get("/conversation/" + conversationUUID, {
    headers: {
      Authorization:
                 `Bearer ${token}`,
    },
  });
  messages.value = response.data.messages;
  console.log(messages.value);
  const pusher = new Pusher("0e78550231dc32a00604", {
    cluster: "eu",
  });

  const channel = pusher.subscribe("kahut");
  channel.bind("message", (data) => {
    messages.value.push(JSON.parse(data.message));
  });
});


</script>
