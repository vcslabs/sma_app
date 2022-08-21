<template>
  <div class="app">
    <el-container style="height: 500px; border: 1px solid #eee" v-if="isAuthenticated">
      <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
        <el-menu :default-openeds="['1']">
          <el-menu-item>
            <template slot="title"><i class="el-icon-s-home"></i>
              <router-link to="/home">ホーム</router-link>
            </template>
          </el-menu-item>
          <el-submenu index="1">
            <template slot="title"><i class="el-icon-menu"></i>メニュー</template>
            <el-submenu index="1-1">
              <template slot="title"><i class="el-icon-user-solid"></i>ユーザー管理</template>
              <el-menu-item><i class="el-icon-search"></i>
                <router-link to="/users/search">検索</router-link>
              </el-menu-item>
              <el-menu-item><i class="el-icon-trophy"></i>
                <router-link to="/users/ranking">ランキング</router-link>
              </el-menu-item>
            </el-submenu>
          </el-submenu>
        </el-menu>
      </el-aside>

      <el-container>
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>

    <LoginItem v-if="!isAuthenticated"></LoginItem>
  </div>
</template>

<script>
import axios from 'axios'
import LoginItem from "@/views/LoginItem";

export default {
  components: {
    LoginItem
  },
  data() {
    return {
      create: [],
      login: [],
      logout: [],
      updateUser: [],
      opponent: [],
      userRanking: [],
      rate: [],
      user: [],
      matchHistory: [],
      characterRanking: []
    }
  },
  computed: {
    isAuthenticated() {
      return this.$store.getters.getToken !== null;
    }
  },
  created() {
    this.getCreate()
    this.getLogin()
    this.getLogout()
    this.putUpdateUser()
    this.getOpponent()
    this.getUserRanking()
    this.getRate()
    this.getUserFromName()
    this.getMatchHistory()
    this.getCharacterRanking()
  },
  methods: {
    getCreate() {
      axios.get('http://localhost:80/v1/users/create')
          .then(res => this.create = res.data)
          .then(res => console.log(res))
          .catch(err => console.log(err))
    },
    putUpdateUser() {
      axios.put('http://localhost:80/v1/users/1',{
        "name":"updateUser",
        "password":"updatePassword"
      })
          .then(res => this.updateUser = res.data)
          .then(res => console.log(res))
          .catch(err => console.log(err))
    },
    getLogin() {
      axios.get('http://localhost:80/v1/users/login')
          .then(res => this.login = res.data)
          .then(res => console.log(res))
          .catch(err => console.log(err))
    },
    getLogout() {
      axios.get('http://localhost:80/v1/users/logout')
          .then(res => this.logout = res.data)
          .then(res => console.log(res))
          .catch(err => console.log(err))
    },
    getOpponent() {
      axios.get('http://localhost:80/v1/matches/1/?condition=300')
          .then(res => this.opponent = res.data)
          .then(res => console.log(res))
          .catch(err => console.log(err))
    },
    getRate() {
      axios.get('http://localhost:80/v1/users/1/rate')
          .then(res => this.rate = res.data)
          .then(res => console.log(res))
          .catch(err => console.log(err))
    },
    getUserFromName() {
      axios.get('http://localhost:80/v1/users/updateUser')
          .then(res => this.user = res.data)
          .then(res => console.log(res))
          .catch(err => console.log(err))
    },
    getMatchHistory() {
      axios.get('http://localhost:80/v1/matches/history/1')
          .then(res => this.matchHistory = res.data)
          .then(res => console.log(res))
          .catch(err => console.log(err))
    },
    getCharacterRanking() {
      axios.get('http://localhost:80/v1/characters/ranking')
          .then(res => this.characterRanking = res.data)
          .then(res => console.log(res))
          .catch(err => console.log(err))
    }
  }
}
</script>

<style scoped>
.el-main {
  padding: 0 50px;
}

.el-icon-s-home {
  color: cornflowerblue;
}

.el-icon-search,.el-icon-trophy {
  color: #303133;
}

a {
  text-decoration: none;
  color: #303133;
}
</style>
