# Composer (PHP dependency manager) in a container
#
# USAGE :
#   docker run --rm -it \
#     -v $(pwd):/app \
#     jdecool/composer [COMMAND]

FROM php:5.6-cli
MAINTAINER Jérémy DECOOL <contact@jdecool.fr>

ENV DEBIAN_FRONTEND noninteractive

RUN apt-get update && apt-get install -y \
  libfreetype6-dev \
  libjpeg62-turbo-dev \
  libmcrypt-dev \
  libpng12-dev \
  libbz2-dev \
  php-pear \
  curl \
  git \
  && rm -r /var/lib/apt/lists/*

RUN docker-php-ext-install mcrypt zip bz2 mbstring exif \
  && docker-php-ext-configure gd --with-freetype-dir=/usr/include/ --with-jpeg-dir=/usr/include/ \
  && docker-php-ext-install gd

RUN echo "memory_limit=1024M" > /usr/local/etc/php/conf.d/memory-limit.ini
RUN echo "date.timezone = Europe/Paris" > /usr/local/etc/php/conf.d/timezone.ini

ENV HOME=/home/doe
ENV COMPOSER_HOME /home/doe/composer
RUN curl -sS https://getcomposer.org/installer | php -- --install-dir=/usr/local/bin --filename=composer

VOLUME ["/app"]
WORKDIR /app

RUN groupadd -f -g 1000 doe && \
  useradd -u 1000 -g doe doe && \
  mkdir -p /home/doe

RUN chown -R doe:doe /app && \
  chown -R doe:doe /home/doe

CMD ["-"]
ENTRYPOINT ["composer"]
