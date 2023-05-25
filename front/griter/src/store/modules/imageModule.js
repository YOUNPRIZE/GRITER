import axios from 'axios';

const REST_API = `http://localhost:9999/api`;

const imageModule = {
  namespaced: true,
  state: {
    image: {},
  },
  getters: {},
  mutations: {
    setimage: (state, payload) => {
      state.image = payload;
    },
  },
  actions: {
    upload({ commit }, payload) {
      console.log("여기까지 오나?");
      const API_URL = `${REST_API}/image/${payload.user_id}/${payload.image}`;
      commit;
      axios
        .post(API_URL, null, {
          params:{
            user_id: payload.user_id,
            data: payload.image,
          }
        })
        .then((res) => {
          alert("업로드 성공");
          console.log(res);
        })
        .catch((err) => {
          alert("업로드 실패");
          console.log(err);
        });
    },
  },
};

export default imageModule;
