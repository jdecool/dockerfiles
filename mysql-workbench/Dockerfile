FROM ubuntu:latest
MAINTAINER Jérémy DECOOL <contact@jdecool.fr>

ENV DEBIAN_FRONTEND noninteractive

RUN apt-get update && apt-get install -y \
  mysql-workbench

CMD mysql-workbench
