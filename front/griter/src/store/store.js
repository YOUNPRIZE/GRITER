import Vue from 'vue'
import Vuex from 'vuex'
import createPersistedState from 'vuex-persistedstate'

import nightmodeModule from "./modules/nightmodeModule.js";
import userModule from "./modules/userModule.js";
import postModule from "./modules/postModule.js"

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
  },
  getters: {
  },
  mutations: {
  },
  actions: {
  },
  modules: {
    nightmodeModule: nightmodeModule,
    userModule: userModule,
    postModule: postModule,
  },
  plugins: [
    createPersistedState({
      paths: [
        "nightmodeModule",
      ],
    }),
  ],
});