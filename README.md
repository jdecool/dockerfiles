Personnal Dockerfile I use for project.

# Current containers

* Apache
* PHP / Behat
* Elasticsearch
* MySQL
* PhantomJS

# Note about container usage

## Elasticsearch
* docker build --rm -t jdecool/elasticsearch elasticsearch/
* docker run [-d] -p 9200:9200 -p 9300:9300 --name elasticsearch jdecool/elasticsearch

## MySQL
* docker build --rm -t jdecool/mysql mysql/
* docker run [-d] -p 3306:3306 --name db jdecool/mysql

## Apache
* docker build --rm -t jdecool/apache apache/
* docker run [-d] -p 8000:80 -v pwd:/srv/application:rw --name web --link db:db --link elasticsearch:elasticsearch jdecool/apache

## PhantomJS
* docker build --rm -t jdecool/phantomjs phantomjs/
* docker run [-d] -p 8643:8643 --name phantomjs jdecool/phantomjs

## Behat
* docker build --rm -t jdecool/behat behat/
* docker run [-d] [-e ENV_PROFILE=behat_profile] -v pwd:/srv/application:rw --name behat --link phantomjs:localhost jdecool/behat
