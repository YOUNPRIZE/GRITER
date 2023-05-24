// import router from "@/router";
import router from "@/router";
import axios from "axios";

const REST_API = `http://localhost:9999/api`;

const routineModule = {
  namespaced: true,
  state: {
    // 그냥 모든 루틴 다 가져온 다음에 가공?
    routines: [],
    routine: {},
  },
  getters: {
    getRoutines: (state) => state.routines,
  },
  mutations: {
    GET_ROUTINES: (state, payload) => {
      state.routines = payload;
    },
    GET_ROUTINE: (state, payload) => {
      state.routine = payload;
    },
  },
  actions: {
    deleteRoutine({ commit }, routine_id) {
      commit;
      const API_URL = `${REST_API}/routines/${routine_id}`;
      axios
        .delete(API_URL, null, {
          params: {
            routine_id: routine_id,
          },
        })
        .then(() => {
          alert("운동 루틴이 삭제되었습니다.");
          router.push({ name: "calendar" });
        });
    },
    updateRoutine: ({ commit }, routine) => {
      commit;
      const API_URL = `${REST_API}/routines/`;
      axios
        .put(API_URL, null, {
          params: {
            routine_id: routine.routine_id,
            user_id: routine.user_id,
            exercise: routine.exercise,
            type: routine.type,
            date: routine.date,
            time: routine.time ? routine.time : null,
            sets: routine.sets ? routine.sets : null,
            reps: routine.reps ? routine.reps : null,
            weight: routine.weight ? routine.weight : null,
          },
        })
        .then((res) => {
          console.log(res);
          alert("루틴이 수정되었습니다.");
          // router.push({ name: "calendar" });
          router.go(0);
        });
    },
    getRoutine: ({ commit }, routine_id) => {
      const API_URL = `${REST_API}/routines/${routine_id}`;
      axios({
        url: API_URL,
        method: "GET",
      }).then((res) => {
        commit("GET_ROUTINE", res.data);
      });
    },
    getUserRoutines({ commit }, user_id) {
      const API_URL = `${REST_API}/routines/users/${user_id}`;
      axios({
        url: API_URL,
        method: "GET",
      }).then((res) => {
        commit("GET_ROUTINES", res.data);
      });
    },
    createRoutines({ commit }, routine) {
      commit;
      const API_URL = `${REST_API}/routines/`;
      console.log(routine.date);
      axios
        .post(API_URL, null, {
          params: {
            user_id: routine.user_id,
            exercise: routine.exercise,
            type: routine.type,
            date: routine.date,
            time: routine.time ? routine.time : null,
            sets: routine.sets ? routine.sets : null,
            reps: routine.reps ? routine.reps : null,
            weight: routine.weight ? routine.weight : null,
          },
        })
        .then((res) => {
          console.log(res);
          alert("운동 루틴이 등록되었습니다.");
          router.push({ name: "calendar" });
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
};

export default routineModule;
