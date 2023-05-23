import router from '@/router';
import axios from "axios";

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
    },
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
      }).then((res) => {
        // console.log(JSON.stringify(res.data));
        commit("setPosts", res.data);
      });
    },
    getPost({ commit }, post_id) {
      const API_URL = `${REST_API}/posts/${post_id}`;
      axios({
        url: API_URL,
        method: "GET",
      }).then((res) => {
        // alert(post_id);
        // console.log(JSON.stringify(res.data));
        commit("setPost", res.data);
      });
    },
    getPostsByUserId({ commit }, user_id) {
      const API_URL = `${REST_API}/posts/by=${user_id}`;
      axios({
        url: API_URL,
        method: "GET",
      }).then((res) => {
        // console.log(JSON.stringify(res.data));
        commit("setPosts", res.data);
      });
    },
    createPost({ commit }, payload) {
      commit;
      const API_URL = `${REST_API}/posts/`;
      axios.post(API_URL, null, {
        params: {
          user_id: payload.user_id,
          title: payload.title,
          content: payload.content,
          category: payload.category,
        },
      })
        .then(() => {
          alert("게시물이 등록되었습니다.");
          router.push({ name: 'PostsList' }).catch(() => { });
        })
        .catch((err) => {
          console.log(err);
        });
    },
    delete({ commit }, post_id) {
      commit;
      const API_URL = `${REST_API}/posts/${post_id}`
      axios.delete(API_URL, null, {
        params: {
          post_id: post_id,
        }
      })
        .then(() => {
          alert("게시물이 삭제되었습니다.");
          router.push({ name: 'PostsList' }).catch(() => { });
        })
    }
  },
};

export default postModule;
