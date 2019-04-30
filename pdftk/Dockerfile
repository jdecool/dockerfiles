FROM gradle:5.4.1-jdk11-slim as builder
WORKDIR /tmp
RUN wget https://gitlab.com/pdftk-java/pdftk/-/archive/v3.0.3/pdftk-v3.0.3.tar.bz2 \
    && tar xf pdftk-v3.0.3.tar.bz2 \
    && cd pdftk-v3.0.3 \
    && gradle shadowJar

FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=builder /tmp/pdftk-v3.0.3/build/libs/pdftk.jar .
ENTRYPOINT [ "java", "-jar", "/app/pdftk.jar" ]
CMD [ "--version" ]
