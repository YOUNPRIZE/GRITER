import Vue from 'vue'
import Vuex from 'vuex';
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import PostsView from '@/views/PostsView.vue'
import PostsList from '@/components/posts/PostsList.vue'
import PostsDetail from '@/components/posts/PostsDetail.vue'
import PostsCreate from '@/components/posts/PostsCreate.vue'
import UserView from '@/views/UserView.vue'
import UsersLogin from '@/components/users/UsersLogin.vue'
import UsersRegister from '@/components/users/UsersRegister.vue'
import UsersInfo from '@/components/users/UsersInfo.vue'
import UsersFollows from '@/components/users/UsersFollows.vue'


Vue.use(VueRouter)
Vue.use(Vuex)

const routes = [
  {
    path: "/",
    name: 'login',
    component: UsersLogin,
  },
  {
    path: '/home',
    name: 'home',
    component: HomeView,
  },
  {
    path: '/posts',
    component: PostsView,
    children: [
      {
        path: "",
        name: 'PostsList',
        component: PostsList,
      },
      {
        path: ":post_id",
        name: 'PostsDetail',
        component: PostsDetail,
      },
      {
        path: "createPost",
        name: 'PostCreate',
        component: PostsCreate,
      },
    ]
  },
  {
    path: '/users',
    component: UserView,
    children: [
      {
        path: "register",
        name: 'register',
        component: UsersRegister,
      },
      {
        path: "follows",
        name: 'follows',
        component: UsersFollows,
      },
      {
        path: ":nickname",
        name: 'userInfo',
        component: UsersInfo,
      },
    ]
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
