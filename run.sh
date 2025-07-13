#!/usr/bin/env bash
set -e

# ensure mvnw is executable
chmod +x mvnw

# run your tests
./mvnw clean test -B

# (optional) package artifacts
./mvnw package -B
