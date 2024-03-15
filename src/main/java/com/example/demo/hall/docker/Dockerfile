FROM 172.30.10.185:15000/common/ubuntu:22.04

WORKDIR /home

RUN apt-get update && \
    apt-get install -y sudo && \
    apt-get install -y wget && \
    apt-get install -y autoconf && \
    apt-get install -y gcc && \
    apt-get install -y make && \
    apt-get install -y git && \
    apt-get install -y net-tools

# 处理aes加密报错问题
ADD ./deploy/file/libssl.so.1.0.0 /lib/x86_64-linux-gnu/libssl.so.1.0.0
ADD ./deploy/file/libcrypto.so.1.0.0 /lib/x86_64-linux-gnu/libcrypto.so.1.0.0
RUN cd /lib/x86_64-linux-gnu && \
    sudo ln -s libssl.so.1.0.0 libssl.so.10 && \
    sudo ln -s libcrypto.so.1.0.0 libcrypto.so.10 && \
    cd /home && \
# 为了解决https请求报错
    wget http://nz2.archive.ubuntu.com/ubuntu/pool/main/o/openssl/libssl1.1_1.1.1f-1ubuntu2.22_amd64.deb && \
    dpkg -i libssl1.1_1.1.1f-1ubuntu2.22_amd64.deb

ADD ./common ./common
RUN git clone https://github.com/jemalloc/jemalloc.git ./common/skynet/3rd/jemalloc && \
    cd ./common/skynet && \
	make linux


ADD ./deploy ./deploy
ADD ./hall ./hall

RUN chmod 755 /home/deploy/entrypoint.sh && \
  sed -i "s/daemon/--daemon/g" ./hall/gatesvrd/b_config_gatesvrd

EXPOSE 7220/tcp 7221/tcp 7211/tcp 8080/tcp

ENTRYPOINT ["/home/deploy/entrypoint.sh"]