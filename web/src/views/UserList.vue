<template>
  <h1>ユーザーランキング情報↓</h1>
</template>

<script>
import ElementUI from "element-ui";
import locale from "element-ui/lib/locale/lang/ja";
import Vue from "vue";

Vue.use(ElementUI, { locale });

export default {
  data() {
    return {
      userRanking: 'userRanking',
    };
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
