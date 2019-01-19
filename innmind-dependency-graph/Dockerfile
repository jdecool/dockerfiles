# Tool to help visualize the various dependencies between packages
#
# USAGE :
#   docker run --rm -it \
#     -v $(pwd):/data \
#     jdecool/innmind-dependency-graph [COMMAND]

FROM php:7.3-cli-alpine

RUN apk add --no-cache --virtual .persistent-deps git wget

RUN apk add --update \
        icu \
    && apk add --no-cache --virtual .build-deps \
        icu-dev \
        zlib-dev \
    && docker-php-ext-configure intl \
    && docker-php-ext-install intl \
    && docker-php-ext-enable intl

RUN wget -O /usr/bin/composer https://getcomposer.org/composer.phar \
    && chmod +x /usr/bin/composer \
    && composer global require innmind/dependency-graph \
    && ln -s /root/.composer/vendor/bin/dependency-graph /usr/bin/dependency-graph

ADD entrypoint.sh /usr/bin/entrypoint.sh

ENTRYPOINT ["entrypoint.sh"]
CMD ["dependency-graph"]
