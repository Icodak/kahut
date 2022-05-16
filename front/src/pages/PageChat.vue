<template>

<div class="q-pa-md q-gutter-sm">
    <q-btn  color="primary" to = "/messagerie" icon="arrow_back_ios" flat label="Retour"  />
</div>

<q-page class="flex-column">



    <q-banner class="bg-grey-10 text-white text-center">
      L'utilisateur est hors-ligne
    </q-banner>


  <div class ="q-pa-md column col justify-end">

<q-chat-message
        v-for="message in messages"
        :key="message.text"
        :name="message.from"
        :text="[message.text]"
        :sent="message.from == 'me' ? true : false"

      />


  </div>

<q-footer elevated style="height: 100px" >
  <q-toolbar>
    <q-form   class ="full-width">

    <q-input v-model ="newMessage"  bg-color="secondary" outlined rounded label = "Message" >
          <q-avatar>
            <img src="https://cdn.quasar.dev/img/avatar5.jpg">
          </q-avatar>
          <q-btn round flat icon="send" type = "submit" @click="sendMessage" />
    </q-input>

</q-form>
</q-toolbar>
</q-footer>
</q-page>
</template>


<script>
import { useQuasar } from 'quasar'
import { ref } from 'vue'

export default {
  data(){
    return {
      newMessage :   '',
      messages:  [
            {
          text:'Salut bg',
          from :'me'
          },
          {
          text:'Salut kahutien',
          from:'Laurie'
          },
          {
          text:'je suis kahutienne',
          from:'Laurie'
          },
          {
          text:'Moi aussi ! ',
          from:'me'
          }
               ]
    }
  },
    methods: {
      sendMessage(){
        this.messages.push({
         text: this.newMessage,
         from : 'me'
       })
     }
   }
}


</script>
