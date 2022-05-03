<template>
  <q-layout view="lHh Lpr lFf">
    <q-header elevated>
      <q-toolbar class="glossy">
        <q-btn
          flat
          dense
          round
          icon="menu"
          aria-label="Menu"
          @click="toggleLeftDrawer"
        />

        <q-toolbar-title>
            Kahut
        </q-toolbar-title>

        <q-btn
          to = "/"
          clickable 
          flat
          dense
          round
          icon="home"
        />

      </q-toolbar>
    </q-header>

    <q-drawer
        v-model="leftDrawerOpen"
        show-if-above
        :width="200"
        :breakpoint="400"
      >
        <q-scroll-area style="height: calc(100%); margin-top: 50px; border-right: 1px solid #ddd">
          <q-list padding>

            <q-item 
              to = "/connexion"
              clickable 
              v-ripple>
              <q-item-section avatar>
                <q-icon name="login" />
              </q-item-section>

              <q-item-section>
                Se connecter
              </q-item-section>
            </q-item>

            <q-item 
              to = "/inscription"
              clickable 
              v-ripple>
              <q-item-section avatar>
                <q-icon name="assignment" />
              </q-item-section>

              <q-item-section>
                S'inscrire
              </q-item-section>
            </q-item>

            <q-item 
              to = "/profil"
              clickable 
              v-ripple>
              <q-item-section avatar>
                <q-icon name="star" />
              </q-item-section>

              <q-item-section>
                Mon profil
              </q-item-section>
            </q-item>

            <q-item 
              to = "/messagerie"
              clickable 
              v-ripple>
              <q-item-section avatar>
                <q-icon name="inbox" />
              </q-item-section>

              <q-item-section>
                Messagerie
              </q-item-section>
            </q-item>


             <q-item 
              to = "/annonces"
              clickable 
              v-ripple>
              <q-item-section avatar>
                <q-icon name="send" />
              </q-item-section>

              <q-item-section>
                Mes annonces
              </q-item-section>
            </q-item>

            <q-item 
              to = "/voyages"
              clickable 
              v-ripple>
              <q-item-section avatar>
                <q-icon name="today" />
              </q-item-section>

              <q-item-section>
                Mes voyages
              </q-item-section>
            </q-item>

            <q-item 
              to = "/deconnexion"
              clickable 
              v-ripple>
              <q-item-section avatar>
                <q-icon name="logout" />
              </q-item-section>

              <q-item-section>
                Déconnexion
              </q-item-section>
            </q-item>
          </q-list>
        </q-scroll-area>

        <q-img class="bg-primary absolute-top glossy" style="height: 50px ">
          <div class="absolute-center bg-transparent">
            <q-avatar size="40px">
          <img src="https://cdn.quasar.dev/img/avatar.png">
        </q-avatar>
          </div>
        </q-img>
      </q-drawer>

    <q-page-container>
      <keep-alive>
        <router-view />
      </keep-alive>
    </q-page-container>
  </q-layout>
</template>

<script lang="ts">
import { defineComponent, ref } from 'vue';

export default defineComponent({
  name: 'MainLayout',

  setup () {
    const leftDrawerOpen = ref(false)

    return {
      leftDrawerOpen,
      toggleLeftDrawer () {
        leftDrawerOpen.value = !leftDrawerOpen.value
      }
    }
  }
});
</script>