FROM adoptopenjdk/openjdk11
COPY target/driver-location-forwarder*.jar driver-location-forwarder.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/driver-location-forwarder.jar"]