<template>
  <q-page class ="flex q-pa-md">
<div v-for="conversation in conversations" :key="conversation">
<q-btn v-on:click="onConversationClick(conversation.id, conversation.recipient)"><p>{{conversation.title}}</p>
</q-btn>
</div>
  </q-page>
</template>


<script >

import { api } from "src/boot/axios";
import { onMounted, ref } from "vue";
import { LocalStorage, SessionStorage } from "quasar";
import { useRoute, useRouter } from 'vue-router';
export default{
setup (){
const token = LocalStorage.getItem("token")
const conversations = ref([]);
const router = useRouter();
const onConversationClick = (id, recipient) => {
LocalStorage.set("conversationUUID", id);
LocalStorage.set("recipient", recipient);
router.push("/messages")
};

  onMounted(async () => {
      const response = await api.get("/conversation", {
      headers: {
        "Authorization" : `Bearer ${token}`
      },
    });
      conversations.value = response.data;
    });
    return {
      conversations,
      onConversationClick,
      router
    }
}}
</script>
