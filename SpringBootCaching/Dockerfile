FROM livingobjects/jre8:latest
VOLUME /tmp
ADD SpringBootCaching.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 8080
ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom -jar -Duser.timezone=GMT+08 /app.jar
