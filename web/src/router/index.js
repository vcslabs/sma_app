import Vue from "vue";
import VueRouter from "vue-router";
import UserItem from "@/views/UserItem";
import HomeItem from "@/views/HomeItem";

Vue.use(VueRouter);

let jSessionIdFromCookie;

const cookie = document.cookie;
console.log(cookie);

export default new VueRouter({
  mode: "history",
  routes: [
    {
      path: '/home',
      component: HomeItem,
      beforeEnter(to, from, next) {
        console.log(jSessionIdFromCookie);
        if (jSessionIdFromCookie) {
          next();
        } else {
          next('http://localhost:8080/login');
        }
      }
    },
    {
      path: '/users',
      component: UserItem,
    },
  ]

});
