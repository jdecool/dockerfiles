# Elasticsearch (Search Engine) in a container
#
# USAGE :
#   docker run -d
#     -v "$PWD/esdata":/usr/share/elasticsearch/data
#     -v "$PWD/esconfig":/usr/share/elasticsearch/config
#     elasticsearch

FROM elasticsearch:latest
MAINTAINER Jérémy DECOOL <contact@jdecool.fr>

RUN plugin install elasticsearch/marvel/latest
RUN plugin install lmenezes/elasticsearch-kopf
