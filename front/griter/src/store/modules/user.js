import router from '@/router';
import axios from 'axios';

const REST_API = `http://localhost:9999/api`;

const user = {
  namespaced: true,
  state: {
    loginUser: {},
  },
  getters: {
    getLoginUser: (state) => state.loginUser,
  },
  mutations: {
    USER_LOGIN: (state, payload) => { state.loginUser = payload },
    GET_USER: (state, payload) => { state.loginUser = payload },
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
          console.log(res);
          sessionStorage.setItem("access-token", res.data["access-token"]);
          localStorage.setItem("loginUser", loginUser.nickname);
          commit("USER_LOGIN", loginUser);
          console.log(loginUser);
          console.log("asdfasfdasfdasfdasfdafsdsfdsfdasfdaasfdafsdasfdsfad")
          router.push({ name: "home" });
        })
        .catch((err) => {
          console.log(err);
          alert("로그인 실패");
          router.push({ name: "login" }).catch(() => { });
          console.log(router);
        });
    },
    getUser: ({ commit }, nickname) => {
      const API_URL = `${REST_API}/users/${nickname}`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          console.log("res: " + res);
          commit("GET_USER");
        })
    }
  },
};

export default user;