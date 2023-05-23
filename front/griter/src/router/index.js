import Vue from "vue";
import Vuex from "vuex";
import VueRouter from "vue-router";
import HomeView from "../views/HomeView.vue";
import PostsView from "@/views/PostsView.vue";
import PostsList from "@/components/posts/PostsList.vue";
import PostsDetail from "@/components/posts/PostsDetail.vue";
import PostsCreate from "@/components/posts/PostsCreate.vue";
import UserView from "@/views/UserView.vue";
import UsersLogin from "@/components/users/UsersLogin.vue";
import UsersRegister from "@/components/users/UsersRegister.vue";
import UsersInfo from "@/components/users/UsersInfo.vue";
import UsersFollows from "@/components/users/UsersFollows.vue";
import CalView from "../views/CalView.vue";
import CalList from "@/components/cals/CalList.vue";
import CalDetail from "@/components/cals/CalDetail.vue";
import CalCreate from "@/components/cals/CalCreate.vue";
import CalDietDetail from "@/components/cals/CalDietDetail.vue";

Vue.use(VueRouter);
Vue.use(Vuex);

const routes = [
  {
    path: "/",
    name: "login",
    component: UsersLogin,
  },
  {
    path: "/home",
    name: "home",
    component: HomeView,
  },
  {
    path: "/cal",
    component: CalView,
    children: [
      {
        path: "",
        name: "calendar",
        component: CalList,
      },
      // 루틴이냐? 식단이냐?
      {
        path: "/routine",
        name: "RoutinesDetail",
        component: CalDetail,
      },
      {
        path: "/createRoutine",
        name: "RoutinesCreate",
        component: CalCreate,
      },
      {
        path: "/diet",
        name: "DietDetail",
        component: CalDietDetail,
      },
    ],
  },
  {
    path: "/posts",
    component: PostsView,
    children: [
      {
        path: "",
        name: "PostsList",
        component: PostsList,
      },
      {
        path: ":post_id",
        name: "PostsDetail",
        component: PostsDetail,
      },
      {
        path: "createPost",
        name: "PostCreate",
        component: PostsCreate,
      },
    ],
  },
  {
    path: "/users",
    component: UserView,
    children: [
      {
        path: "register",
        name: "register",
        component: UsersRegister,
      },
      {
        path: "follows",
        name: "follows",
        component: UsersFollows,
      },
      {
        path: ":user_id",
        name: "userInfo",
        component: UsersInfo,
      },
    ],
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
