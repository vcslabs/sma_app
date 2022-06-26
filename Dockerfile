#FROM 元となるイメージを指定
FROM openjdk:14-slim

# ENV 環境変数を設定
    # APP_ROUTE アプリのディレクトリ あとでワーキングディレクトリに指定
    # LANG デフォルトエンコーディングの設定
ENV APP_ROUTE=smabro_app \
    LANG=en_US.UTF-8

# WORKDIR ワーキングディレクトリの指定
WORKDIR $APP_ROUTE

# RUN イメージビルドの際にコマンドを命令
    # apt update リポジトリ一覧を更新( リポジトリ追加・削除時には必ず実行する )
    # apt install インストール -yオプションで問い合わせがあった場合はすべて「y」と答える（apt installに必須）

RUN apt-get update \
&& apt-get install -y nodejs \
&& apt-get install -y npm

# COPY コピーコマンド
    # ホストマシンのソースコードをコンテナ内のアプリにコピーする
COPY . /$APP_ROUTE

# RUN イメージビルドの際にコマンドを命令
    # gradlew install
RUN ./gradlew clean build

#うまく動かないのでコメントアウト
#COPY ./app_start.sh /usr/bin/
#RUN chmod +x /usr/bin/app_start.sh
## CMD コンテナ作成後に実行するコマンドを指定
#CMD ["app_start.sh"]


# ENTRYPOINT コンテナ作成後に実行するコマンドを指定
ENTRYPOINT ["java", "-jar", "build/libs/smabro_app-0.0.1-SNAPSHOT.jar"]
