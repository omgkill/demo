#!/bin/bash

cd

# 增加git密钥,用于后续热更（代码和配置）处理
mkdir -p .ssh
cp /home/deploy/file/id_rsa .ssh/id_rsa
chmod 600 .ssh/id_rsa
ssh-keyscan gitlab.yeahmobi.com >> /root/.ssh/known_hosts

cd /home/hall
cp -f ../deploy/config_svrs_"$ENV" ./config/svr/config_svrs

if [ "$ENV" == "india" ]
then
  rm -rf config/business
  mv config/release_business config/business
fi

./server.sh restart all