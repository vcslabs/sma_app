import Vue from "vue";
import Vuex from "vuex";
import createPersistedState from "vuex-persistedstate";

Vue.use(Vuex);

export default new Vuex.Store({
  state() {
    return {
      token: null
    };
  },
  getters: {
    getToken(state) {
      return state.token;
    }
  },
  mutations: {
    saveToken(state, token) {
      state.token = token;
    },
    removeToken(state) {
      state.token = null;
    }
  },
  actions: {
    saveToken({ commit }, token) {
      commit("saveToken", token);
    },
    removeToken({ commit }) {
      commit("removeToken");
    }
  },
  // `createPersistedState()`でインスタンス作成。引数に設定を書く
  plugins: [
    createPersistedState({
      // ストレージのキーを指定。デフォルトではvuex
      key: "smabroApp",
      // ストレージの種類を指定する。デフォルトではローカルストレージ
      storage: window.sessionStorage
    })
  ]
});
