# PHP with pthreads extension
#
# USAGE :
#   docker run --rm -it \
#     -v $(pwd):/app \
#     jdecool/php-pthreads [COMMAND]

FROM debian:jessie
MAINTAINER Jérémy DECOOL <contact@jdecool.fr>

RUN apt-get update && apt-get upgrade -y && apt-get install -y \
	autoconf \
	build-essential \
	libssl-dev \
	libxml2-dev \
	wget

RUN wget -qO php-7.0.0RC4.tar.bz2 https://downloads.php.net/~ab/php-7.0.0RC4.tar.bz2 \
	&& tar xjf php-7.0.0RC4.tar.bz2 \
	&& cd php-7.0.0RC4 \
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

RUN rm php-7.0.0RC4.tar.bz2 \
	&& rm -rf php-7.0.0RC4 \
	&& apt-get purge -y autoconf build-essential wget .+-dev \
	&& apt-get clean \
	&& rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*

VOLUME ["/app"]
WORKDIR /app

ENTRYPOINT ["php"]
CMD ["--help"]
