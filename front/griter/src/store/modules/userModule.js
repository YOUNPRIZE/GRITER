import router from '@/router';
import axios from 'axios';

const REST_API = `http://localhost:9999/api`;

const userModule = {
  namespaced: true,
  state: {
    loginUser: {
    },
    user: {
    },
    users: [],
  },
  getters: {
    getLoginUser: (state) => state.loginUser,
  },
  mutations: {
    USER_LOGIN: (state, payload) => { state.loginUser = payload },
    GET_USER: (state, payload) => {
      // console.log(payload);
      state.user = payload;
      // console.log(state.loginUser);
    },
    GET_LOGINUSER: (state, payload) =>{
      state.loginUser = payload;
    }
  },
  actions: {
    userLogin: ({ commit }, loginUser) => {
      const API_URL = `${REST_API}/users/jwt`;
      axios({
        url: API_URL,
        method: "POST",
        params: loginUser,
      })
        .then((res) => {
          // console.log(res.data);
          sessionStorage.setItem("access-token", res.data["access-token"]);
          localStorage.setItem("loginUser", res.data["loginUser"]);
          commit("USER_LOGIN", loginUser);
          // console.log(loginUser);
          router.push({ name: "home" });
        })
        .catch((err) => {
          console.log(err);
          alert("로그인 실패");
          router.push({ name: "login" }).catch(() => { });
          // console.log(router);
        });
    },
    getUser: ({ commit }, user_id) => {
      const API_URL = `${REST_API}/users/${user_id}`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          // console.log("res: " + JSON.stringify(res.data));
          // console.log("res: " + JSON.stringify(res.data));
          commit("GET_USER", res.data);
        })
    },
    getLoginUser: ({ commit }, user_id) => {
      const API_URL = `${REST_API}/users/${user_id}`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          // console.log("res: " + JSON.stringify(res.data));
          // console.log("res: " + JSON.stringify(res.data));
          commit("GET_LOGINUSER", res.data);
        })
    },
  },
};

export default userModule;