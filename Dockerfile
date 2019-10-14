FROM openjdk:12-alpine

COPY target/devsunky-email-notification-0.0.1-SNAPSHOT.jar /devsunky-email-notification-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "/devsunky-email-notification-0.0.1-SNAPSHOT.jar"]






