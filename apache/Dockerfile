FROM ubuntu:latest

ENV DEBIAN_FRONTEND noninteractive
ENV TIMEZONE Europe/Paris

RUN locale-gen en_US en_US.UTF-8
ENV LANG en_US.UTF-8

ENV APACHE_RUN_USER     www-data
ENV APACHE_RUN_GROUP    www-data
ENV APACHE_PID_FILE     /var/run/apache2.pid
ENV APACHE_RUN_DIR      /var/run/apache2
ENV APACHE_LOCK_DIR     /var/lock/apache2
ENV APACHE_LOG_DIR      /var/log/apache2

RUN apt-get update -y
RUN apt-get install -y apache2

RUN apt-get update -y
RUN apt-get install software-properties-common -y
RUN apt-add-repository ppa:ondrej/php5 -y
RUN apt-get update -y

RUN apt-get install -y --force-yes php5 libapache2-mod-php5 php5-mysql php5-json php5-xsl php5-intl php5-mcrypt php5-xdebug php5-curl php5-gd
RUN php5enmod xdebug

RUN apt-get install -y curl

RUN apt-get clean
RUN rm -rf /var/lib/apt/lists/*

RUN curl -sS https://getcomposer.org/installer | php -- --install-dir=/usr/local/bin && mv /usr/local/bin/composer.phar /usr/local/bin/composer
RUN echo $TIMEZONE > /etc/timezone && dpkg-reconfigure --frontend noninteractive tzdata
RUN sed -i "s@^;date.timezone =.*@date.timezone = $TIMEZONE@" /etc/php5/*/php.ini

ADD xdebug.ini /xdebug.ini
RUN sed -i "s@EXTENSION_DIR@`php -i | grep extension_dir | awk '{print $(NF)}'`@" /xdebug.ini
RUN mv /xdebug.ini /etc/php5/mods-available/xdebug.ini

RUN a2enmod rewrite

ADD 000-default.conf /etc/apache2/sites-available/000-default.conf

RUN rm -rf /var/www
RUN ln -s /srv/application/web /var/www

CMD ["/usr/sbin/apache2", "-D", "FOREGROUND"]

EXPOSE 80
