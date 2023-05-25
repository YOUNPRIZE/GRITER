import Vue from "vue";
import Vuex from "vuex";
import createPersistedState from "vuex-persistedstate";

import nightmodeModule from "./modules/nightmodeModule.js";
import userModule from "./modules/userModule.js";
import postModule from "./modules/postModule.js";
import commentModule from "./modules/commentModule.js";
import routineModule from "./modules/routineModule.js";
import followModule from "./modules/followModule.js";
import dietModule from "./modules/dietModule.js";
import imageModule from "./modules/imageModule.js";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {},
  getters: {},
  mutations: {},
  actions: {},
  modules: {
    nightmodeModule: nightmodeModule,
    userModule: userModule,
    postModule: postModule,
    commentModule: commentModule,
    routineModule: routineModule,
    followModule: followModule,
    dietModule: dietModule,
    imageModule: imageModule,
  },
  plugins: [
    createPersistedState({
      paths: ["nightmodeModule", "routineModule"],
    }),
  ],
});
