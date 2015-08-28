# Keepass2 (password manager) in a container
#
# USAGE :
#   docker run -d \
#     -v /tmp/.X11-unix:/tmp/.X11-unix \
#     -v $HOME/Documents:/root/Documents \
#     -e DISPLAY=unix$DISPLAY \
#     --name keepass2 \
#     jdecool/keepass2 [COMMAND]

FROM ubuntu:vivid
MAINTAINER Jérémy DECOOL <contact@jdecool.fr>

RUN apt-get update && apt-get install -y \
  keepass2

RUN groupadd -f -g 1000 doe && \
  useradd -u 1000 -g doe doe && \
  mkdir -p /home/doe

RUN chown -R doe:doe /home/doe

CMD keepass2
