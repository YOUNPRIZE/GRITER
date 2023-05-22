import router from '@/router';
import axios from 'axios';
import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

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
    USER_INFO: (state, payload) => { state.loginUser = payload },
  },
  actions: {
    userLogin: ({ commit }, loginUser) => {
      const API_URL = `${REST_API}/users/jwt`;
      localStorage.setItem("local", JSON.stringify(loginUser));
      axios({
        url: API_URL,
        method: "POST",
        params: loginUser,
      })
        .then((res) => {
          console.log(res);
          sessionStorage.setItem("access-token", res.data["access-token"]);
          commit("USER_LOGIN", loginUser);
          router.push({ name: "home" });
        })
        .catch((err) => {
          console.log(err);
          alert("로그인 실패");
          router.push({ name: "login" }).catch(()=>{});
          console.log(router);
        });
    },
    getLoginUserInfo: ({ commit }, nickname) => {
      const API_URL = `${REST_API}/users/${nickname}`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          commit("USER_INFO", res.date);
        }).catch((err) => {
          console.log(err);
        });
    },
  },
};

export default user;