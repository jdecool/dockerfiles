# VirtualBox in a container
#
# USAGE :
#   docker run -d \
#     -v /tmp/.X11-unix:/tmp/.X11-unix \
#     -e DISPLAY=unix$DISPLAY \
#     --privileged \
#     --name virtualbox \
#     jdecool/virtualbox

FROM debian:jessie
MAINTAINER Jérémy DECOOL <contact@jdecool.fr>

RUN apt-get update && apt-get install -y \
  ca-certificates \
  curl \
  software-properties-common \
  --no-install-recommends && \
  curl -sSL https://www.virtualbox.org/download/oracle_vbox.asc | apt-key add - && \
  echo "deb http://download.virtualbox.org/virtualbox/debian jessie contrib" >> /etc/apt/sources.list.d/virtualbox.list && \
  apt-get update && \
  apt-get install -y \
  virtualbox-5.0 \
  && rm -rf /var/lib/apt/lists/*

ENTRYPOINT	[ "/usr/bin/virtualbox" ]
