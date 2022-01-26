FROM openjdk:8
EXPOSE 8080
ADD /target/*.jar app.jar
ENTRYPOINT ["java","-Dspring.profiles.active=${SPRING_PROFILE}","-jar","/app.jar"]