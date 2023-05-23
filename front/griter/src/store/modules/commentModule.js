import router from '@/router';
import axios from 'axios';

const REST_API = `http://localhost:9999/api`;

const postModule = {
  namespaced: true,
  state: {
    comments: [],
    comment: {},
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
    setComment(state, payload) {
      state.comment = payload;
    }
  },
  actions: {
    getComments({ commit }, post_id) {
      const API_URL = `${REST_API}/posts/comments/${post_id}`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          // console.log(JSON.stringify(res.data));
          commit('setComments', res.data);
        })
    },
    getComment({ commit }, comment) {
      console.log(comment);
      commit('setComment', comment);
    },
    //////////////////////////////////////////////////
    createComment({ commit }, payload) {
      commit;
      const API_URL = `${REST_API}/posts/comments/`;
      console.log(API_URL);
      console.log(JSON.stringify(payload));
      axios.post(API_URL, null, {
        params: {
          content: payload.content,
          parent_id: payload.parent_id,
          user_id: payload.user_id,
          post_id: payload.post_id,
        }
      })
        .then((res) => {
          console.log(JSON.stringify(res.data));
          router.go(0);
        })
        .catch((err) => {
          console.log(err);
        })
        .finally(

      )
    }
  },
};

export default postModule;