const nightmodeModule = {
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

export default nightmodeModule;