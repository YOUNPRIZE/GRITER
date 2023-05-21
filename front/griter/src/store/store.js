import Vue from 'vue'
import Vuex from 'vuex'
import createPersistedState from 'vuex-persistedstate'

import Nightmode from "./modules/nightmode.js";
import User from "./modules/user.js";

Vue.use(Vuex)

export default new Vuex.Store({
  state:{
    posts: [],
    post:{},
  },
  getters:{
    posts(state){
      return state.posts;
    },
    post(state){
      return state.post;
    }
  },
  mutations: {
    setPosts(state, payload){
      state.posts = payload;
    },
    setPost(state, payload){
      state.post = payload;
    },
  },
  actions: {
  },
  modules: {
    nightmodeModule: Nightmode,
    userModule: User,
  },
  plugins: [
    createPersistedState({
      paths:[
        "nightmodeModule",
      ],
    }),
  ],
});