#!/bin/bash

cd /home/hall
cp -f ../deploy/config_svrs_"$ENV" ./config/svr/config_svrs

if [ "$ENV" -eq "india" ]; then
  rm -rf config/business
  mv config/release_business config/bussiness
fi

./server.sh restart all