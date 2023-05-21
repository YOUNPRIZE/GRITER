import router from '@/router';
import axios from 'axios';
import Vue from 'vue'
import Vuex from 'vuex'
import createPersistedState from 'vuex-persistedstate'

Vue.use(Vuex)

const REST_API = `http://localhost:9999/api`;

export default new Vuex.Store({
  state:{
    nightmode: false,
    loginUser: {},
    posts: [],
    post:{},
  },
  getters:{
    mode(state){
      return state.nightmode;
    },
    posts(state){
      return state.posts;
    },
    post(state){
      return state.post;
    }
  },
  mutations: {
    setMode(state, payload){
      state.nightmode = payload;
    },
    setPosts(state, payload){
      state.posts = payload;
    },
    setPost(state, payload){
      state.post = payload;
    },
    USER_LOGIN(state, payload) {
      state.loginUser = payload;
    },
    USER_INFO(state, payload) {
      state.loginUser = payload;
    },
  },
  actions: {
    callModeSet(context){
      context.commit("setMode", !this.state.nightmode);
    },
    userLogin({commit}, loginUser) {
      const API_URL = `${REST_API}/users/jwt`;
      axios({
        url: API_URL,
        method: "POST",
        params: loginUser,
      })
      .then((res) => {
        console.log(res);
        sessionStorage.setItem("access-token", res.data["access-token"]);
        commit("USER_LOGIN", loginUser);
      })
      .catch((err) => {
        console.log(err);
        router.push({name:"login"});
      });
    },
    getLoginUserInfo({commit}, nickname) {
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
  modules: {
  },
  plugins: [
    createPersistedState({
      whiteList:[
        "nightmode",
      ]
    })
  ]
});