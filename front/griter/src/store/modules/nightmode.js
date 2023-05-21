import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const Nightmode = {
  namespaced: true,
  state: {
    nightmode: true,
  },
  getters: {
    mode: state => () => state.nightmode,
  },
  mutations: {
    setMode: (state, payload) => { state.nightmode = payload },
  },
  actions: {
    callModeSet: (context) => { context.commit("setMode", !this.state.nightmode) }
  },
};

export default Nightmode;