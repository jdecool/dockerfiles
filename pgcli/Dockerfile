# PgCLI (Postgres CLI with autocompletion and syntax highlighting ) in a container
#
# USAGE :
#   docker run --rm -it \
#     --net host \
#     jdecool/pgcli [COMMAND]

FROM python:3.4
MAINTAINER Jérémy DECOOL <contact@jdecool.fr>

ENV DEBIAN_FRONTEND noninteractive

RUN pip install pgcli

CMD ["—h"]
ENTRYPOINT ["pgcli"]
