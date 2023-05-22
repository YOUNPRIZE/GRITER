import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "@/store/store.js";
import VCalendar from "v-calendar";

Vue.use(VCalendar);

Vue.config.productionTip = false;

new Vue({
  VCalendar,
  router,
  store,
  render: (h) => h(App),
}).$mount("#app");
