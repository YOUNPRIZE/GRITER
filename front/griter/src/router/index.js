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
import UsersModify from "@/components/users/UsersModify.vue";
import UsersSearch from "@/components/users/UsersSearch.vue";
import CalView from "../views/CalView.vue";
import CalList from "@/components/cals/CalList.vue";
import CalDetail from "@/components/cals/CalDetail.vue";
import CalCreate from "@/components/cals/CalCreate.vue";
import CalDietDetail from "@/components/cals/CalDietDetail.vue";
import CalDietCreate from "@/components/cals/CalDietCreate.vue";

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
        path: "/routine/:routine_id",
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
        name: "DietsDetail",
        component: CalDietDetail,
      },
      {
        path: "/createDiet",
        name: "DietsCreate",
        component: CalDietCreate,
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
        path: "detail/:post_id",
        name: "PostsDetail",
        component: PostsDetail,
      },
      {
        path: "createPost",
        name: "PostCreate",
        component: PostsCreate,
      },
      {
        path: "modifyPost/:post_id",
        name: "PostModify",
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
        path: "myPage",
        name: "myPage",
        component: UsersInfo,
      },
      {
        path: ":user_id",
        name: "userInfo",
        component: UsersInfo,
      },
      {
        path: "update/:user_id",
        name: "updateUser",
        component: UsersModify,
      },
      {
        path: "search",
        name: "searchUser",
        component: UsersSearch,
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
