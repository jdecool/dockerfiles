# MyCLI (A Terminal Client for MySQL with AutoCompletion and Syntax Highlighting) in a container
#
# USAGE :
#   docker run --rm -it \
#     --net host \
#     jdecool/mycli [COMMAND]

FROM python:3.4
MAINTAINER Jérémy DECOOL <contact@jdecool.fr>

ENV DEBIAN_FRONTEND noninteractive

RUN pip install mycli

CMD ["—h"]
ENTRYPOINT ["mycli"]
