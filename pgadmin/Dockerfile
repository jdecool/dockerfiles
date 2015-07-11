FROM debian:sid
MAINTAINER Jérémy DECOOL <contact@jdecool.fr>

ENV DEBIAN_FRONTEND noninteractive

RUN apt-get update && apt-get install -y \
  pgadmin3 --no-install-recommends

CMD pgadmin3
