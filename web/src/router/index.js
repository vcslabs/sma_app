import Vue from "vue";
import VueRouter from "vue-router";
import UserList from "@/views/UserList";

Vue.use(VueRouter);

export default new VueRouter({
  mode: "history",
  routes: [
    {
      path: '/users',
      component: UserList,
    },
  ]

});
