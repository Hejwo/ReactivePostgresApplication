FROM openjdk:8u151-jre

ENV APP_PORT 8888

# Developer utils
ENV TERM xterm
RUN apt-get update
RUN apt-get install nano

### Set timezone
ENV TIME_ZONE Europe/Warsaw
RUN ln -snf /usr/share/zoneinfo/$TIME_ZONE /etc/localtime && echo $TIME_ZONE > /etc/timezone

### Prepare files
ADD ReactivePostgreSql.jar app.jar
RUN sh -c 'touch /app.jar'

### Expose volumes and ports
VOLUME /tmp/app_data/logs
EXPOSE $APP_PORT

ENV JAVA_OPTS "-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/tmp/app_data/logs"

ENTRYPOINT  exec java $JAVA_OPTS -jar /app.jar

HEALTHCHECK --interval=10s --timeout=3s CMD curl -f http://localhost:${APP_PORT}/metrics/health || exit 1