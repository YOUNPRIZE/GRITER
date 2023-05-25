import router from '@/router';
import axios from 'axios';

const REST_API = `http://localhost:9999/api`;

const commentModule = {
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
        .then(() => {
          // router.go(0);
        })
        .catch((err) => {
          console.log(err);
        })
    },
    update({ commit }, payload) {
      commit;
      const API_URL = `${REST_API}/posts/comments/`;
      console.log(payload.content);
      axios.put(API_URL, null, {
        params: {
          content: payload.content,
          comment_id: payload.comment_id,
        }
      }).then((res) => {
        alert("댓글 수정 완료");
        console.log(res);
        router.go(0);
      })
    }, 
    commentDelete({ commit }, deleteCommentId){
      commit;
      const API_URL = `${REST_API}/posts/comments/${deleteCommentId}`;
      axios.delete(API_URL, null, {
        params:{
          comment_id: deleteCommentId,
        }
      }).then(()=>{
        alert("해당 댓글이 삭제되었습니다.");
      })
    }
  },
};

export default commentModule;