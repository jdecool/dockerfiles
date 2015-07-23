# PgAdmin in a container
#
# USAGE :
#   docker run -d \
#     --net host \
#     -v /tmp/.X11-unix:/tmp/.X11-unix \
#     -v $HOME/.pgadmin:/root \
#     -e DISPLAY=unix$DISPLAY \
#     --name pgadmin \
#     jdecool/pgadmin [COMMAND]

FROM debian:sid
MAINTAINER Jérémy DECOOL <contact@jdecool.fr>

ENV DEBIAN_FRONTEND noninteractive

RUN apt-get update && apt-get install -y \
  pgadmin3 --no-install-recommends

CMD pgadmin3
