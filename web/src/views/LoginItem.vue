<template>
  <div>
    <h2>ログイン</h2>
    <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="120px" class="demo-ruleForm">
      <el-form-item label="ユーザー名" prop="username" class="login-form">
        <el-input type="text" v-model="username" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="パスワード" prop="password" class="login-form">
        <el-input type="password" v-model="password" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="resetForm">リセット</el-button>
        <el-button type="primary" @click="login">ログイン</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      password: undefined,
      username: undefined
    };
  },
  methods: {
    login() {
      axios
        .post("http://localhost:8080/api/login", {
          username: this.username,
          password: this.password
        })
        .then(res => {
          console.log(res);
          this.$store.dispatch('saveToken', res.headers['x-auth-token'])
          this.$router.push('/home')
        })
        .catch(e => {
          alert("ログインに失敗しました");
          console.log(e);
        });
    },
    resetForm() {
      this.username = '';
      this.password = '';
    }
  }
};
</script>

<style scoped>
h2 {
  color: #303133;
  padding-left: 35px;
}
.login-form {
  width: 50%;
}
</style>
