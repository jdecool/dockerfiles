# HHVM (Facebook HipHop Virtual Machine) in a container
#
# USAGE :
#   docker run --rm -it \
#     -v $(pwd):/root \
#     jdecool/hhvm [COMMAND]

FROM debian:jessie
MAINTAINER Jérémy DECOOL <contact@jdecool.fr>

ENV DEBIAN_FRONTEND noninteractive

RUN apt-key adv --recv-keys --keyserver hkp://keyserver.ubuntu.com:80 0x5a16e7281be7a449 \
  && echo deb http://dl.hhvm.com/debian jessie main | tee /etc/apt/sources.list.d/hhvm.list \
  && apt-get update \
  && apt-get install hhvm -y

ENTRYPOINT ["hhvm"]
