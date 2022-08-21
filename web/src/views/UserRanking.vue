<template>
  <div>
    <h2>ユーザーランキング</h2>
    <el-table
        :data="userRanking"
        border
        style="width: 100%">
      <el-table-column
          type="index"
          label="順位"
          width="50">
      </el-table-column>
      <el-table-column
          prop="name"
          label="名前"
          width="180">
      </el-table-column>
      <el-table-column
          prop="rate"
          label="レート"
          width="180">
      </el-table-column>
      <el-table-column
          prop="mainCharacterId"
          label="メインキャラID">
      </el-table-column>
      <el-table-column
          prop="sub1CharacterId"
          label="サブキャラ1ID"
          width="180">
      </el-table-column>
      <el-table-column
          prop="sub2CharacterId"
          label="サブキャラ2ID"
          width="180">
      </el-table-column>
    </el-table>
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
