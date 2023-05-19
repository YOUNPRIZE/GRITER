import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import PostsView from '@/views/PostsView.vue'
import PostsList from '@/components/posts/PostsList.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView,
  },
  {
    path: 'posts',
    component: PostsView,
    children: [
      {
        path: "",
        name: 'posts',
        component: PostsList,
      },
      {
        path: "",
        name: ''
      }
    ]
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
