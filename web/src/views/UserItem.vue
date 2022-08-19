<template>
  <div>
    <h1>ユーザーランキング情報↓</h1>
    <p>{{ userRanking }}</p>
  </div>
</template>

<script>
import ElementUI from "element-ui";
import locale from "element-ui/lib/locale/lang/ja";
import Vue from "vue";
import axios from "@/axios";

Vue.use(ElementUI, { locale });

export default {
  data() {
    return {
      userRanking: undefined,
    };
  },
  mounted() {
    this.getUserRanking();
  },
  methods: {
    getUserRanking() {
      axios
        .get("/v1/users/ranking")
        .then(res => (this.userRanking = res.data))
        .then(res => console.log(res))
        .catch(err => console.log(err));
    },
  }
};
</script>

<style scoped>
.el-header {
  background-color: #B3C0D1;
  color: #333;
  line-height: 60px;
}

.el-aside {
  color: #333;
}
</style>
