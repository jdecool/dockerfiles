FROM node:latest

ENV DEBIAN_FRONTEND noninteractive

RUN npm install phantomjs -g

EXPOSE 8643
CMD ["/usr/local/bin/phantomjs", "--webdriver=8643"]
