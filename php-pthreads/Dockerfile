# PHP with pthreads extension
#
# USAGE :
#   docker run --rm -it \
#     -v $(pwd):/app \
#     jdecool/php-pthreads [COMMAND]

FROM debian:jessie
MAINTAINER Jérémy DECOOL <contact@jdecool.fr>

ENV VERSION 7.0.10

RUN apt-get update && apt-get upgrade -y && apt-get install -y \
	autoconf \
	build-essential \
	libssl-dev \
	libxml2-dev \
	wget

RUN wget -qO php-$VERSION.tar.bz2 http://fr2.php.net/get/php-$VERSION.tar.bz2/from/this/mirror \
	&& tar xjf php-$VERSION.tar.bz2 \
	&& cd php-$VERSION \
	&& ./configure \
		--disable-cgi \
		--enable-mbstring \
		--enable-maintainer-zts \
		--enable-zip \
		--with-libdir=/lib/x86_64-linux-gnu \
		--with-openssl \
	&& make \
	&& make install \
	&& cp php.ini-production /usr/local/lib/php.ini \
	&& cd .. \
	&& pecl config-set php_ini /usr/local/lib/php.ini \
	&& pear config-set php_ini /usr/local/lib/php.ini \
	&& pecl install pthreads

RUN rm php-$VERSION.tar.bz2 \
	&& rm -rf php-$VERSION \
	&& apt-get purge -y autoconf build-essential wget .+-dev \
	&& apt-get clean \
	&& rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*

VOLUME ["/app"]
WORKDIR /app

ENTRYPOINT ["php"]
CMD ["--help"]
