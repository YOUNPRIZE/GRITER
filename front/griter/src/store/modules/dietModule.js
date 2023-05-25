// import router from "@/router";
import router from "@/router";
import axios from "axios";

const REST_API = `http://localhost:9999/api`;

const dietModule = {
  namespaced: true,
  state: {
    // 그냥 모든 루틴 다 가져온 다음에 가공?
    diets: [],
    diet: {},
  },
  getters: {
    getdiets: (state) => state.diets,
    getdiet: (state) => state.dies,
  },
  mutations: {
    GET_DIETS: (state, payload) => {
      state.diets = payload;
    },
    GET_DIET: (state, payload) => {
      state.diet = payload;
    },
  },
  actions: {
    deleteDiet({ commit }, diet_id) {
      commit;
      const API_URL = `${REST_API}/diets/${diet_id}`;
      axios
        .delete(API_URL, null, {
          params: {
            diet_id: diet_id,
          },
        })
        .then(() => {
          alert("식단이 삭제되었습니다.");
          router.push({ name: "calendar" });
        });
    },
    updateDiet: ({ commit }, diet) => {
      commit;
      const API_URL = `${REST_API}/diets/`;
      axios
        .put(API_URL, null, {
          params: {
            diet_id: diet.diet_id,
            user_id: diet.user_id,
            date: diet.date,
            meal: diet.meal,
            kind: diet.kind,
            gram: diet.gram ? diet.gram : null,
            calories: diet.calories ? diet.calories : null,
          },
        })
        .then(() => {
          alert("식단이 수정되었습니다.");
          router.go(0);
        });
    },
    getDiet: ({ commit }, diet_id) => {
      const API_URL = `${REST_API}/diets/${diet_id}`;
      axios({
        url: API_URL,
        method: "GET",
      }).then((res) => {
        commit("GET_DIET", res.data);
      });
    },
    getUserDiets({ commit }, user_id) {
      const API_URL = `${REST_API}/diets/users/${user_id}`;
      axios({
        url: API_URL,
        method: "GET",
      }).then((res) => {
        commit("GET_DIETS", res.data);
      });
    },
    createDiets({ commit }, diet) {
      commit;
      const API_URL = `${REST_API}/diets/`;
      axios
        .post(API_URL, null, {
          params: {
            diet_id: diet.diet_id,
            user_id: diet.user_id,
            date: diet.date,
            meal: diet.meal,
            kind: diet.kind,
            gram: diet.gram ? diet.gram : null,
            calories: diet.calories ? diet.calories : null,
          },
        })
        .then((res) => {
          console.log(res);
          alert("식단이 등록되었습니다.");
          router.push({ name: "calendar" });
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
};

export default dietModule;
