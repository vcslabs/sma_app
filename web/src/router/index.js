import Vue from "vue";
import VueRouter from "vue-router";
import UserItem from "@/views/UserItem";
import HomeItem from "@/views/HomeItem";
import LoginItem from "@/views/LoginItem";

Vue.use(VueRouter);

const cookie = document.cookie;
console.log(cookie);

export default new VueRouter({
  mode: "history",
  routes: [
    {
      path: '/home',
      component: HomeItem,
    },
    {
      path: '/users',
      component: UserItem,
    },
    {
      path: '/login',
      component: LoginItem,
    },
  ]

});
