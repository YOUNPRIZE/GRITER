import Vue from 'vue'
import Vuex from 'vuex'
import createPersistedState from 'vuex-persistedstate'

Vue.use(Vuex)

export default new Vuex.Store({
  state:{
    nightmode: false,
    loginUser: {
    },
  },
  getters:{
    mode(state){
      return state.nightmode;
    },
  },
  mutations: {
    setMode(state, payload){
      state.nightmode = payload;
    },
  },
  actions: {
    callModeSet(context){
      context.commit("setMode", !this.state.nightmode);
    }
  },
  modules: {
  },
  plugins: [
    createPersistedState({
      whiteList:[
        "nightmode",
      ]
    })
  ]
});