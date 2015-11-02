# TypeScript (superset of JavaScript that compiles to clean JavaScript) in a container
#
# USAGE :
#   docker run --rm -it \
#     -v $(pwd):/data \
#     jdecool/typescript

FROM node:latest
MAINTAINER Jérémy DECOOL <contact@jdecool.fr>

RUN npm install -g typescript

VOLUME ["/data"]
WORKDIR /data

RUN groupadd -f -g 1000 doe && \
  useradd -u 1000 -g doe doe && \
  mkdir -p /home/doe

RUN chown -R doe:doe /data && \
  chown -R doe:doe /home/doe

CMD ["-"]
ENTRYPOINT [ "tsc" ]
