#!/bin/sh
set -e

java -jar build/libs/smabro_app-0.0.1-SNAPSHOT.jar
#cd ./web
#npm run serve

# Then exec the container's main process (what's set as CMD in the Dockerfile).
exec "$@"