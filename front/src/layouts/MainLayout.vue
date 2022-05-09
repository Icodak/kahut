<template>
  <q-layout view="lHh Lpr lFf">
    <q-header elevated>
      <q-toolbar color="secondary" class="glossy">
        <q-btn
          flat
          dense
          round
          icon="menu"
          aria-label="Menu"
          @click="toggleLeftDrawer"
        />

        <q-btn
          to = "/"
          clickable 
          flat
          dense
          round
          icon="home"
        />

        <q-toolbar-title>
            Kahut
        </q-toolbar-title>

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
              v-ripple
              @click="loginLayout = true">
              <q-item-section avatar>
                <q-icon name="login" />
              </q-item-section>

              <q-item-section>
                Se connecter
              </q-item-section>
            </q-item>

                <q-dialog v-model="loginLayout">
                  <q-layout view="Lhh lpR fff" container class="bg-white">
                    <q-header class="bg-primary">
                      <q-toolbar>
                        <q-btn flat @click="drawer = !drawer" round dense icon="menu" />
                        <q-toolbar-title>Header</q-toolbar-title>
                        <q-btn flat @click="drawerR = !drawerR" round dense icon="menu" />
                        <q-btn flat v-close-popup round dense icon="close" />
                      </q-toolbar>
                    </q-header>

                    <q-footer class="bg-black text-white">
                      <q-toolbar inset>
                        <q-toolbar-title>Footer</q-toolbar-title>
                      </q-toolbar>
                    </q-footer>

                    <q-drawer bordered v-model="drawer" :width="200" :breakpoint="600" class="bg-grey-3 q-pa-sm">
                      <div v-for="n in 50" :key="n">Drawer {{ n }} / 50</div>
                    </q-drawer>

                    <q-drawer side="right" bordered v-model="drawerR" :width="200" :breakpoint="300" class="bg-grey-3 q-pa-sm">
                      <div v-for="n in 50" :key="n">Drawer {{ n }} / 50</div>
                    </q-drawer>

                    <q-page-container>
                      <q-page padding>
                        <p v-for="n in contentSize" :key="n">
                          {{ lorem }}
                        </p>
                      </q-page>
                    </q-page-container>
                  </q-layout>
                </q-dialog>

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