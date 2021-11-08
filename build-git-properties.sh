#!/usr/bin/env bash

cat > ./build/resources/main/application-gitconfig.properties <<EOF
git.commit.id=`git rev-parse HEAD`
EOF