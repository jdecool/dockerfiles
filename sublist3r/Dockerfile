# Sublist3r (https://github.com/aboul3la/Sublist3r) in a container
#
# USAGE :
#   docker run --rm -it \
#     jdecool/sublist3r domain.org

FROM python:3.7-alpine
MAINTAINER Jérémy DECOOL <contact@jdecool.fr>

RUN cd /tmp \
  && wget https://github.com/aboul3la/Sublist3r/archive/master.zip \
  && unzip master.zip \
  && mv Sublist3r-master /sublist3r

RUN cd /sublist3r && pip install -r ./requirements.txt

ENTRYPOINT ["python", "/sublist3r/sublist3r.py"]
CMD ["-h"]
