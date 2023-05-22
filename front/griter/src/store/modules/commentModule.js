// import router from '@/router';
import axios from 'axios';

const REST_API = `http://localhost:9999/api`;

const postModule = {
  namespaced: true,
  state: {
    comments: [],
  },
  getters: {
    comments(state) {
      return state.comments;
    },
  },
  mutations: {
    setComments(state, payload) {
      state.comments = payload;
    },
  },
  actions: {
    getComments({ commit }, post_id) {
      const API_URL = `${REST_API}/posts/comments/${post_id}`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          console.log(JSON.stringify(res.data));
          commit('setComments', res.data);
        })
    }
  },
};

export default postModule;