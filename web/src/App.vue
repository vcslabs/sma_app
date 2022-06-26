<template>
  <div class="app">
    <h1>登録結果↓</h1>
    <p>{{ create }}</p>
    <h1>ログイン結果↓</h1>
    <p>{{ login }}</p>
    <h1>ログアウト結果↓</h1>
    <p>{{ logout }}</p>
    <h1>ユーザー編集API結果(1であれば成功)↓</h1>
    <p>{{ updateUser }}</p>
    <h1>対戦相手情報↓</h1>
    <p>{{ opponent }}</p>
    <h1>ユーザーランキング情報↓</h1>
    <p>{{ userRanking }}</p>
    <h1>レート情報↓</h1>
    <p>{{ rate }}</p>
    <h1>ユーザー情報↓</h1>
    <p>{{ user }}</p>
    <h1>マッチ履歴↓</h1>
    <p>{{ matchHistory }}</p>
    <h1>キャラクターランキング情報↓</h1>
    <p>{{ characterRanking }}</p>
  </div>
</template>

<script>

import axios from 'axios'

export default {
  data() {
    return{
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
    getUserRanking() {
      axios.get('http://localhost:80/v1/users/ranking')
          .then(res => this.userRanking = res.data)
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