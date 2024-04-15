#!/bin/bash

if [ -d "/mnt/hgfs/server" ];then echo "hold"; else sudo mount -t fuse.vmhgfs-fuse .host:/ /mnt/hgfs -o allow_other ;fi
rsync -a --delete  /mnt/hgfs/server/hall /home/deploy/server/
rsync -a --delete  /mnt/hgfs/server/common /home/deploy/server/
cp -rf /mnt/hgfs/server/deploy /home/deploy/server/

#cd ./hall/proto && git pull && cd -
docker stop game
cd /home/deploy/server/

docker build . -t game

docker run -d --rm \
--name game \
--env ENV=shuai \
-p 7200:7200 \
-p 7221:7221 \
-p 7211:7211 \
-p 8080:8080 \
-v /home/deploy/volume:/home/dd \
game

docker logs -f game
