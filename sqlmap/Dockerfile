# sqlmap (Automatic SQL injection) in a container
#
# USAGE :
#   docker run --rm -it \
#     -v $(pwd):/data \
#     jdecool/sqlmap [COMMAND]

FROM python:2.7
MAINTAINER Jérémy DECOOL <contact@jdecool.fr>

ENV DEBIAN_FRONTEND noninteractive
ENV VERSION 0.9

RUN apt-get update && apt-get install -y \
  git --no-install-recommends

RUN git clone https://github.com/sqlmapproject/sqlmap.git \
    && cd sqlmap \
    && git checkout tags/${VERSION}

WORKDIR /sqlmap
VOLUME /data

CMD ["—h"]
ENTRYPOINT ["./sqlmap.py"]
