# Gulp (task automation) in a container
#
# USAGE :
#   docker run --rm -it \
#     -v $(pwd):/data \
#     jdecool/gulp [COMMAND]

FROM node:latest

RUN npm install -g gulp-cli

VOLUME ["/data"]
WORKDIR /data

RUN groupadd -f -g 1000 doe && \
  useradd -u 1000 -g doe doe && \
  mkdir -p /home/doe

RUN chown -R doe:doe /data && \
  chown -R doe:doe /home/doe

CMD ["-"]
ENTRYPOINT ["gulp"]
