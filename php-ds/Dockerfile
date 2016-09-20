# PHP with php-ds (https://github.com/php-ds/extension) extension
#
# USAGE :
#   docker run --rm -it \
#     -v $(pwd):/app \
#     jdecool/php-ds [COMMAND]

FROM php
MAINTAINER Jérémy DECOOL <contact@jdecool.fr>

RUN pecl install ds

RUN echo "extension=ds.so" >> /usr/local/etc/php/php.ini
