# Keepass2 (password manager) in a container
#
# USAGE :
#   docker run -d \
#     -e LOCAL_USER_ID=`id -u $USER` \
#     -v /tmp/.X11-unix:/tmp/.X11-unix \
#     -v $HOME/Documents:/root/Documents \
#     -e DISPLAY=unix$DISPLAY \
#     --name keepass2 \
#     jdecool/keepass2 [COMMAND]

FROM ubuntu:vivid
MAINTAINER Jérémy DECOOL <contact@jdecool.fr>


RUN apt-get update && apt-get install -y \
  curl keepass2

RUN gpg --keyserver ha.pool.sks-keyservers.net --recv-keys B42F6819007F00F88E364FD4036A9C25BF357DD4
RUN curl -o /usr/local/bin/gosu -SL "https://github.com/tianon/gosu/releases/download/1.4/gosu-$(dpkg --print-architecture)" \
  && curl -o /usr/local/bin/gosu.asc -SL "https://github.com/tianon/gosu/releases/download/1.4/gosu-$(dpkg --print-architecture).asc" \
  && gpg --verify /usr/local/bin/gosu.asc \
  && rm /usr/local/bin/gosu.asc \
  && chmod +x /usr/local/bin/gosu

COPY entrypoint.sh /usr/local/bin/entrypoint.sh

CMD keepass2
ENTRYPOINT ["/usr/local/bin/entrypoint.sh"]
