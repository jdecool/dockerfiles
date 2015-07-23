# MySQL Workbench in a container
#
# USAGE :
#   docker run -d \
#     --net host \
#     -v /tmp/.X11-unix:/tmp/.X11-unix \
#     -v $HOME/.mysql-workbench:/root/.mysql/workbench \
#     -e DISPLAY=unix$DISPLAY \
#     --name mysql-workbench \
#     jdecool/mysql-workbench [COMMAND]

FROM ubuntu:latest
MAINTAINER Jérémy DECOOL <contact@jdecool.fr>

ENV DEBIAN_FRONTEND noninteractive

RUN apt-get update && apt-get install -y \
  mysql-workbench

CMD mysql-workbench
