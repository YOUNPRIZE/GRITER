import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const Nightmode = {
  namespaced: true,
  state: {
    nightmode: "",
  },
  getters: {
    mode: state => () => state.nightmode,
  },
  mutations: {
    setMode: (state, payload) => { state.nightmode = payload },
  },
  actions: {
    callModeSet: (context) => { context.commit("setMode", !context.state.nightmode) }
  },
};

export default Nightmode;