# Grunt (task automation) in a container
#
# USAGE :
#   docker run --rm -it \
#     -v $(pwd):/data \
#     jdecool/grunt [COMMAND]

FROM node:latest

RUN apt-get update && apt-get install -y ruby ruby-dev
RUN gem install compass

RUN npm install -g grunt-cli

VOLUME ["/data"]
WORKDIR /data

RUN groupadd -f -g 1000 doe && \
  useradd -u 1000 -g doe doe && \
  mkdir -p /home/doe

RUN chown -R doe:doe /data && \
  chown -R doe:doe /home/doe

CMD ["-"]
ENTRYPOINT ["grunt"]
