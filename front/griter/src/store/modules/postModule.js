import router from '@/router';
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
    },
    getPostsByUserId({ commit }, user_id) {
      const API_URL = `${REST_API}/posts/by=${user_id}`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          console.log(JSON.stringify(res.data));
          commit('setPosts', res.data);
        })
    },
    createPost(post) {
      const API_URL = `${REST_API}/posts/`;
      axios({
        url: API_URL,
        method: "POST",
        params: post
      })
        .then((res) => {
          console.log(res);
          alert("게시물이 등록되었습니다.");
          router.push({ name: 'PostsList' }).catch(() => { });
        })
        .catch((err) => {
          console.log(err);
        })
    },
  },
};

export default postModule;