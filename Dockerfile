FROM adoptopenjdk/openjdk8:alpine-slim

COPY target/timeteller-0.0.1-SNAPSHOT.jar timeteller-0.0.1-SNAPSHOT.jar

EXPOSE 8010

CMD ["java", "-jar", "timeteller-0.0.1-SNAPSHOT.jar"]