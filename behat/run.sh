#!/bin/sh

if [ ! $ENV_PROFILE ]; then
    ENV_PROFILE=default
fi

cd /home/behat
bin/behat --profile=$ENV_PROFILE
