# SmaApp
## 大乱闘スマッシュブラザーズSpecial: 対戦プラットフォーム

## 使用技術
### BE
* Java
* SpringBoot
* SpringSecurity

### FE
* HTML
* CSS
* Vue.js
* Vuex
* VueRouter

### DB
* MySql
* MyBatis

### Session Store
* Redis（現在未設定）

### Test
* groovy

### CI/CD
* GithubActions
* AWS

## 起動方法
* イメージのビルド  
  ```$ docker-compose build```

* コンテナの作成  
  ```$ docker-compose up -d```

* 立ち上がったコンテナを確認  
  ```$ docker ps -a```

* 起動したコンテナにログイン（コンテナ名は上記で確認したもの）  
  ```$ docker exec -it コンテナ名 bash -p``` or ```$ docker exec -it コンテナID bash -p``` 

