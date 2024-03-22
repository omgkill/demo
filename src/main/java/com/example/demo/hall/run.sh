#!/bin/bash


#cd /home/deploy/server/hall/proto
#git pull

cp -rf /mnt/hgfs/server/hall /home/deploy/server/


docker stop game
cd /home/deploy/server/

docker build . -t game

docker run -d --rm \
--name game \
--env ENV=test \
-p 7200:7200 \
-p 7221:7221 \
-p 7211:7211 \
-p 8080:8080 \
-v /home/deploy/volume:/home/dd \
game

docker logs -f game