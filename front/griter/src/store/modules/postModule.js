// import router from '@/router';
import axios from 'axios';

const REST_API = `http://localhost:9999/api`;

const postModule = {
  namespaced: true,
  state: {
    posts: [],
    post: {},
  },
  getters: {
    posts(state) {
      return state.posts;
    },
    post(state) {
      return state.post;
    }
  },
  mutations: {
    setPosts(state, payload) {
      state.posts = payload;
    },
    setPost(state, payload) {
      state.post = payload;
    },
  },
  actions: {
    getPosts({ commit }) {
      const API_URL = `${REST_API}/posts/`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          // console.log(JSON.stringify(res.data));
          commit('setPosts', res.data);
        })
    },
    getPost({ commit }, post_id) {
      const API_URL = `${REST_API}/posts/${post_id}`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          console.log(JSON.stringify(res.data));
          commit('setPost', res.data);
        })
    }
  },
};

export default postModule;