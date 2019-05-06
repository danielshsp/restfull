FROM openjdk:8
ADD target/docker-springboot-mongo.jar docker-springboot-mongo.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","docker-springboot-mongo.jar"]