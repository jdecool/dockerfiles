# Composer (PHP dependency manager) in a container
#
# USAGE :
#   docker run --rm -it \
#     -e LOCAL_USER_ID=`id -u $USER` \
#     -v $(pwd):/home/user \
#     jdecool/composer [COMMAND]

FROM php:5.6-cli
MAINTAINER Jérémy DECOOL <contact@jdecool.fr>

ENV DEBIAN_FRONTEND noninteractive

RUN gpg --keyserver ha.pool.sks-keyservers.net --recv-keys B42F6819007F00F88E364FD4036A9C25BF357DD4
RUN curl -o /usr/local/bin/gosu -SL "https://github.com/tianon/gosu/releases/download/1.4/gosu-$(dpkg --print-architecture)" \
  && curl -o /usr/local/bin/gosu.asc -SL "https://github.com/tianon/gosu/releases/download/1.4/gosu-$(dpkg --print-architecture).asc" \
  && gpg --verify /usr/local/bin/gosu.asc \
  && rm /usr/local/bin/gosu.asc \
  && chmod +x /usr/local/bin/gosu

RUN apt-get update && apt-get install -y \
  libfreetype6-dev \
  libjpeg62-turbo-dev \
  libmcrypt-dev \
  libpng12-dev \
  libbz2-dev \
  libicu-dev \
  libxml2-dev \
  zlib1g-dev \
  php-pear \
  curl \
  git \
  g++ \
  && rm -r /var/lib/apt/lists/*

RUN docker-php-ext-install mcrypt zip bz2 mbstring exif soap \
  && docker-php-ext-configure gd --with-freetype-dir=/usr/include/ --with-jpeg-dir=/usr/include/ \
  && docker-php-ext-install gd \
  && docker-php-ext-configure intl && docker-php-ext-install intl

RUN echo "memory_limit=1024M" > /usr/local/etc/php/conf.d/memory-limit.ini
RUN echo "date.timezone = Europe/Paris" > /usr/local/etc/php/conf.d/timezone.ini

ENV HOME=/home/user
ENV COMPOSER_HOME /home/user
RUN curl -sS https://getcomposer.org/installer | php -- --install-dir=/usr/local/bin --filename=composer

VOLUME ["/app"]
WORKDIR /app

RUN composer global require hirak/prestissimo

COPY entrypoint.sh /usr/local/bin/entrypoint.sh

ENTRYPOINT ["/usr/local/bin/entrypoint.sh"]
