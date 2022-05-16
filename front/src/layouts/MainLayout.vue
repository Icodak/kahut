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
          @click="getHome"
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
                <q-header class="bg-primary glossy">
                  <q-toolbar>
                    <q-toolbar-title>Connexion</q-toolbar-title>
                    <q-btn flat v-close-popup round dense icon="close" />
                  </q-toolbar>
                </q-header>

                <q-page-container>
                  <q-page padding>
                    <div class="q-pa-md" style="max-width: 400px">

                      <q-form
                        @reset="onReset"
                        class="justify-center"
                      >
                        <q-input
                          filled
                          v-model="email"
                          label="Adresse e-mail"
                          lazy-rules
                          :rules="[ val => val && val.length > 0 || 'Please type something']"
                        />

                        <q-input 
                          v-model="password" 
                          filled :type="isPwd ? 'password' : 'text'" 
                          label="Password *"
                          lazy-rules
                          :rules="[val => val && val.length > 0 || 'Please type something']"
                        >
                          <template v-slot:append>
                            <q-icon
                              :name="isPwd ? 'visibility_off' : 'visibility'"
                              class="cursor-pointer"
                              @click="isPwd = !isPwd"
                            />
                          </template>
                        </q-input>

                        <div>
                          <q-btn label="Submit" type="submit" color="primary" @click="loginOnSubmit"/>
                          <q-btn label="Reset" type="reset" color="primary" flat class="q-ml-sm" />
                        </div>
                      </q-form>

                    </div>
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
                <q-icon name="account_circle" />
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
                <q-icon name="forum" />
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
              clickable 
              @click="confirm = true"
              v-ripple>
              <q-item-section avatar>
                <q-icon name="logout" />
              </q-item-section>

              <q-item-section>
                Déconnexion
              </q-item-section>
            </q-item>

            <q-dialog v-model="confirm" persistent>
              <q-card>
                <q-card-section class="row items-center">
                  <q-avatar icon="logout" color="primary" text-color="white" />
                  <span class="q-ml-sm">Are you sure you want to logout ?</span>
                </q-card-section>

                <q-card-actions align="right">
                  <q-btn flat label="Cancel" color="primary" v-close-popup />
                  <q-btn flat label="Logout" color="primary" v-close-popup />
                </q-card-actions>
              </q-card>
            </q-dialog>


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
import { login, getHomePage } from '../services/login';

export default defineComponent({
  name: 'MainLayout',

  setup () {
    const leftDrawerOpen = ref(false)
    const email = ref(null)
    const password = ref(null)

    return {
      leftDrawerOpen,
      toggleLeftDrawer () {
        leftDrawerOpen.value = !leftDrawerOpen.value
      },

      isPwd: ref(true),
      email,
      password,

      loginLayout: ref(false),
      confirm: ref(false),

      loginOnSubmit () {
        login(email, password);
      },

      getHome() {
        getHomePage();
      },
      
      onReset () {
        email.value = null
        password.value = null
      }
    }
    }
  });
</script>