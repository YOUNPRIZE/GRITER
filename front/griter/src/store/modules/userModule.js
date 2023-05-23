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
      state.user = payload;
    },
    GET_LOGINUSER: (state, payload) => {
      state.loginUser = payload;
    }
  },
  actions: {
    userLogin: ({ commit }, loginUser) => {
      const API_URL = `${REST_API}/users/jwt`;
      axios.post(API_URL, null, {
        params: {
          nickname: loginUser.nickname,
          password: loginUser.password,
        }
      })
        .then((res) => {
          sessionStorage.setItem("access-token", res.data["access-token"]);
          localStorage.setItem("loginUser", res.data["loginUser"]);
          commit("USER_LOGIN", loginUser);
          router.push({ name: "home" }).catch(() => { });
        })
        .catch((err) => {
          console.log(err);
          alert("로그인 실패");
          commit("USER_LOGIN", 'fail');
        });
    },
    getUser: ({ commit }, user_id) => {
      const API_URL = `${REST_API}/users/${user_id}`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
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
          commit("GET_LOGINUSER", res.data);
        })
    },
  },
};

export default userModule;