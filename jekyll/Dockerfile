FROM jekyll/stable
MAINTAINER Jérémy DECOOL <contact@jdecool.fr>

RUN apt-get update && apt-get install -y \
  openjdk-8-jre ncftp --no-install-recommends

RUN gem install glynn --source http://gemcutter.org \
  && gem install chronic \
  && gem install yui-compressor
