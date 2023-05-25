import router from "@/router";
import axios from "axios";
// import httpCommon from "@/util/http-common";

const REST_API = `http://localhost:9999/api`;

const userModule = {
  namespaced: true,
  state: {
    loginUser: {},
    user: {},
    users: [],
  },
  getters: {
    getLoginUser: (state) => state.loginUser,
  },
  mutations: {
    USER_LOGIN: (state, payload) => {
      state.loginUser = payload;
    },
    GET_USER: (state, payload) => {
      state.user = payload;
    },
    GET_USERS: (state, payload) => {
      state.users = payload;
    },
    GET_LOGINUSER: (state, payload) => {
      state.loginUser = payload;
    },
    // UPDATE_USER: (state, payload) => {
    //   state.loginUser = payload;
    // }
  },
  actions: {
    updateUser: ({ commit }, user) => {
      commit;
      const API_URL = `${REST_API}/users/`;
      axios
        .put(API_URL, null, {
          params: {
            user_id: user.user_id,
            nickname: user.nickname,
            password: user.password,
            name: user.name,
            email: user.email,
            gender: user.gender,
            image: user.image ? user.image : null,
          },
        })
        .then((res) => {
          console.log(res);
          alert("사용자의 정보가 수정되었습니다.");
          // commit("UPDATE_USER", loginUser);
          // router.push({ name: "calendar" });
          router.push({ name: "home" }).catch(() => {});
        });
    },
    userLogin: ({ commit }, loginUser) => {
      const API_URL = `${REST_API}/users/jwt`;
      axios
        .post(API_URL, null, {
          params: {
            nickname: loginUser.nickname,
            password: loginUser.password,
          },
        })
        .then((res) => {
          sessionStorage.setItem("access-token", res.data["access-token"]);
          localStorage.setItem("loginUser", res.data["loginUser"]);
          commit("USER_LOGIN", loginUser);
          router.push({ name: "home" }).catch(() => {});
        })
        .catch((err) => {
          console.log(err);
          alert("로그인 실패");
          commit("USER_LOGIN", "fail");
        });
    },
    getUser: ({ commit }, user_id) => {
      const API_URL = `${REST_API}/users/${user_id}`;
      axios({
        url: API_URL,
        method: "GET",
      }).then((res) => {
        commit("GET_USER", res.data);
      });
    },
    getUsers: ({ commit }) => {
      const API_URL = `${REST_API}/users/`;
      axios({
        url: API_URL,
        method: "GET",
      }).then((res) => {
        commit("GET_USERS", res.data);
      });
    },
    getLoginUser: ({ commit }, user_id) => {
      const API_URL = `${REST_API}/users/${user_id}`;
      axios({
        url: API_URL,
        method: "GET",
      }).then((res) => {
        commit("GET_LOGINUSER", res.data);
      });
    },
  },
};

export default userModule;
