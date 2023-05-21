import Vue from 'vue'
import Vuex from 'vuex'
import createPersistedState from 'vuex-persistedstate'

Vue.use(Vuex)

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