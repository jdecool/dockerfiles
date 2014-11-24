FROM ubuntu:latest

ENV DEBIAN_FRONTEND noninteractive
ENV TIMEZONE Europe/Paris

RUN apt-get update && apt-get install -y -q php5-cli php5-curl && rm -rf /var/lib/apt/lists/*

RUN ln -s /srv/application /home/behat

ADD run.sh /run.sh
RUN chmod 755 /run.sh

CMD ["/run.sh"]
