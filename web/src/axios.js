import store from "./store";
import axios from 'axios';

const instance = axios.create({
  baseURL: "http://localhost:8080"
});

instance.interceptors.request.use(config => {
  config.headers = {
    "X-AUTH-TOKEN": "Bearer " + store.getters.getToken
  };
  return config;
});

export default instance;
