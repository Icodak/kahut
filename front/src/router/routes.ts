import { RouteRecordRaw } from 'vue-router';

const routes: RouteRecordRaw[] = [
  {
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      { path: '', component: () => import('pages/Accueil.vue') },
      { path: '/recherche', component: () => import('pages/Recherche.vue') },
      { path: '/profil', component: () => import('pages/Profil.vue') },
      { path: '/annonces', component: () => import('pages/Annonces.vue') },
      { path: '/voyages', component: () => import('pages/Voyages.vue') },
      { path: '/messagerie', component: () => import('pages/Messagerie.vue') },
      { path: '/chat', component: () => import('pages/PageChat.vue') },
      { path: '/inscription', component: () => import('pages/Inscription.vue') },
      { path: '/logement', component: () => import('pages/Logement.vue') }
    ],
  },

  // Always leave this as last one,
  // but you can also remove it
  {
    path: '/:catchAll(.*)*',
    component: () => import('pages/ErrorNotFound.vue'),
  },
];

export default routes;
