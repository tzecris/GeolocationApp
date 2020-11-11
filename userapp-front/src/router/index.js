import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import AddUser from '../views/AddUser.vue'
import SearchUser from '../views/SearchUser.vue'
import ShowUser from '../views/ShowUser.vue'
import ContactPage from '../views/ContactPage.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '*',
    name: 'Home',
    component: Home
  },
  {
    path: '/user',
    name: 'Add User',
    component: AddUser
  },
  {
    path: '/users',
    name: 'Users',
    component: SearchUser
  },
  {
    path: '/user/:id',
    name: 'Show User',
    component: ShowUser
  },
  {
    path: '/contact',
    name: 'Contact info',
    component: ContactPage
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
