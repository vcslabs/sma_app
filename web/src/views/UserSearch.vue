<template>
  <h2>{{message}}</h2>
</template>

<script>
import ElementUI from "element-ui";
import locale from "element-ui/lib/locale/lang/ja";
import Vue from "vue";

Vue.use(ElementUI, { locale });

export default {
  data() {
    return {
      message: 'ユーザー検索'
    };
  },
};
</script>

<style scoped>
</style>
