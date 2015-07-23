# Jekyll (static blog engine) in a container
# With NCFTP for FTP deployment
#
# USAGE :
#   docker run --rm -it \
#     -v $(pwd):/srv/jekyll \
#     -p 127.0.0.1:4000:4000 \
#     jdecool/jekyll jekyll [COMMAND]

FROM jekyll/stable
MAINTAINER Jérémy DECOOL <contact@jdecool.fr>

RUN apt-get update && apt-get install -y \
  openjdk-8-jre ncftp --no-install-recommends

RUN gem install glynn --source http://gemcutter.org \
  && gem install chronic \
  && gem install yui-compressor
