FROM ubuntu:latest
LABEL authors="wlz"

ENTRYPOINT ["top", "-b"]