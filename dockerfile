FROM openjdk:8
WORKDIR /tmp
COPY target/docker-spring-boot.jar /tmp/
EXPOSE 8080
CMD ["java", "-jar", "target/docker-spring-boot.jar"]