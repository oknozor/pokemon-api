#!/bin/sh

CURRENT_BRANCH=$(git rev-parse --abbrev-ref HEAD)

if [ "$CURRENT_BRANCH" != "main" ]
then
    echo "Needs to be on main to bump current version"
    exit 1
fi
