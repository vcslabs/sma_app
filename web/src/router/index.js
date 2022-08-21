import Vue from "vue";
import VueRouter from "vue-router";
import UserRanking from "@/views/UserRanking";
import UserSearch from "@/views/UserSearch";
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
      path: '/users/search',
      component: UserSearch,
    },
    {
      path: '/users/ranking',
      component: UserRanking,
    },
    {
      path: '/login',
      component: LoginItem,
    },
  ]

});
