# ProtocolBuffer compiler
#
# USAGE :
#   docker run --rm -it \
#     -v $(pwd):/app \
#     jdecool/protoc [COMMAND]

FROM alpine:3.6
MAINTAINER Jérémy DECOOL <contact@jdecool.fr>

RUN apk add --no-cache --virtual .persistent-deps \
        protobuf \
        protobuf-dev

VOLUME ["/app"]
WORKDIR /app

ENTRYPOINT ["protoc"]
CMD ["--help"]