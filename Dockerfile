FROM openjdk:8
EXPOSE 8080
ADD /target/*.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom --spring.config.location=classpath:file:/app/application-propertiesdoc","-jar","/app.jar"]