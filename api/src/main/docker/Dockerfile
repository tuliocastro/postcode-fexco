FROM frolvlad/alpine-oraclejdk8:slim
MAINTAINER tulioac88@gmail.com
#!/bin/bash
COPY postcode-search-1.0-SNAPSHOT.jar api.jar
RUN sh -c 'touch /api.jar'
VOLUME /tmp
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS  -jar /api.jar " ]