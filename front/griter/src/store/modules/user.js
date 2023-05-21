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
  },
  mutations: {
    USER_LOGIN: (state, payload) => { state.loginUser = payload },
    USER_INFO: (state, payload) => { state.loginUser = payload },
  },
  actions: {
    userLogin: ({ commit }, loginUser) => {
      const API_URL = `${REST_API}/users/jwt`;
      localStorage.setItem("local", loginUser);
      axios({
        url: API_URL,
        method: "POST",
        params: loginUser,
      })
        .then((res) => {
          console.log(res);
          alert("여기는 성공");
          sessionStorage.setItem("access-token", res.data["access-token"]);
          commit("USER_LOGIN", loginUser);
        })
        .catch((err) => {
          console.log(err);
          alert("여기는 실패");
          // router.push({ name: "login" });
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