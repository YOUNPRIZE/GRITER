// import router from "@/router";
import axios from "axios";

const REST_API = `http://localhost:9999/api`;

const routineModule = {
  namespaced: true,
  state: {
    // 그냥 모든 루틴 다 가져온 다음에 가공?
    routines: [],
  },
  getters: {
    getRoutines: (state) => state.routines,
  },
  mutations: {
    GET_ROUTINES: (state, payload) => {
      console.log(payload);
      state.routines = payload;
    },
  },
  actions: {
    // getAllRoutines: ({ commit }) => {
    //   const API_URL = `${REST_API}/routines/`;
    //   axios({
    //     url: API_URL,
    //     method: "GET",
    //   }).then((res) => {
    //     commit("GET_ROUTINES", res.data);
    //   });
    // },
    getUserRoutines({ commit }, user_id) {
      const API_URL = `${REST_API}/routines/users/${user_id}`;
      axios({
        url: API_URL,
        method: "GET",
      }).then((res) => {
        console.log(res.data);
        commit("GET_ROUTINES", res.data);
      });
    },
  },
};

export default routineModule;
