# NodeJS in a container
#
# USAGE :
#   docker run --rm -it \
#     -v $(pwd):/usr/src \
#     -w /usr/src \
#     -u doe \
#     jdecool/node node [COMMAND]

FROM node:latest
MAINTAINER Jérémy DECOOL <contact@jdecool.fr>

ENV DEBIAN_FRONTEND noninteractive

RUN groupadd -f -g 1000 doe && \
  useradd -u 1000 -g doe doe && \
  mkdir -p /home/doe

RUN chown -R doe:doe /home/doe
