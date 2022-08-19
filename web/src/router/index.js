import Vue from "vue";
import VueRouter from "vue-router";
import UserItem from "@/views/UserItem";
import HomeItem from "@/views/HomeItem";

Vue.use(VueRouter);

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
  ]

});
