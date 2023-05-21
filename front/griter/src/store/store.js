import axios from 'axios';
import Vue from 'vue'
import Vuex from 'vuex'
import createPersistedState from 'vuex-persistedstate'

Vue.use(Vuex)

const REST_API = `http://localhost:9999`;

export default new Vuex.Store({
  state:{
    nightmode: false,
    loginUser: {
    },
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
  },
  actions: {
    callModeSet(context){
      context.commit("setMode", !this.state.nightmode);
    },
<<<<<<< HEAD
    userLogin({commit}, loginUser) {
      const API_URL = `${REST_API}/login`;
      axios({
        url: API_URL,
        method: "POST",
        params: loginUser,
      })
      .then((res) => {
        console.log(res);
        sessionStorage.setItem("access-token", res.data["access-token"]);
        commit("USER_LOGIN"); // 필요하다면
      })
      .catch((err) => {
        console.log(err);
      });
=======
    getPosts(context){
      const postsList = JSON.getItem("postsList");
      let newList = {
        posts: [],
      };
      if(postsList){
        newList = JSON.parse(postsList);
      } else{
        localStorage.setItem("postsList", JSON.stringify(newList));
      }
      context.commit("setPosts", newList.posts);

    },
    getPost(context, payload){
      const postsList = JSON.parse(localStorage.getItem("postsList"));
      for(let obj of postsList){
        if(payload == obj.postId){
          context.commit("setPost", obj);
          break;
        }
      }
>>>>>>> 1fbfd0614cf1fb09e6086845a93c8be2f5d8edca
    }
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