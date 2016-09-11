# TypeScript (superset of JavaScript that compiles to clean JavaScript) in a container
#
# USAGE :
#   docker run --rm -it \
#     -v $(pwd):/data \
#     jdecool/typescript

FROM node:latest
MAINTAINER Jérémy DECOOL <contact@jdecool.fr>

RUN gpg --keyserver ha.pool.sks-keyservers.net --recv-keys B42F6819007F00F88E364FD4036A9C25BF357DD4
RUN curl -o /usr/local/bin/gosu -SL "https://github.com/tianon/gosu/releases/download/1.4/gosu-$(dpkg --print-architecture)" \
  && curl -o /usr/local/bin/gosu.asc -SL "https://github.com/tianon/gosu/releases/download/1.4/gosu-$(dpkg --print-architecture).asc" \
  && gpg --verify /usr/local/bin/gosu.asc \
  && rm /usr/local/bin/gosu.asc \
  && chmod +x /usr/local/bin/gosu

RUN npm install -g typescript

VOLUME ["/data"]
WORKDIR /data

COPY entrypoint.sh /usr/local/bin/entrypoint.sh
ENTRYPOINT ["/usr/local/bin/entrypoint.sh"]
