import router from '@/router';
import axios from 'axios';

const REST_API = `http://localhost:9999/api`;
const API_URL = `${REST_API}/follows`;

const followModule = {
  namespaced: true,
  state: {
    followers: [],
    following: [],
  },
  getters: {
  },
  mutations: {
    setFollowers: (state, payload) => { state.followers = payload },
    setFollowing: (state, payload) => { state.following = payload },
  },
  actions: {
    create: ({ commit }, relation) => {
      commit;
      axios.post(API_URL, null, {
        params: {
          user_id: relation.user_id,
          following_id: relation.following_id,
        }
      }).then((res) =>{
        console.log(res.data);
        router.go(0);
      })
    },
    callFollowers: ({commit}, user_id) => {
      console.log(user_id);
      axios.get(API_URL + `/followed/${user_id}`, null, {
        params: {
          user_id: user_id,
        }
      }).then((res)=>{
        console.log(res.data);
        commit('setFollowers', res.data);
      })
    },
    callFollowing: ({commit}, following_id) =>{
      axios.get(API_URL + `/following/${following_id}`, null, {
        params: {
          following_id: following_id,
        }
      }).then((res) =>{
        console.log(res.data);
        commit('setFollowing', res.data);
      })
    }
  },
};

export default followModule;