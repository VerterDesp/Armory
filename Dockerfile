FROM openjdk:11

COPY target/primo.jar primo.jar

CMD ["java","-jar","primo.jar"]