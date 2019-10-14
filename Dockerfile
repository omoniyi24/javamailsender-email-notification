FROM openjdk:jdk-alpine

COPY target/devsunky-email-notification-*.jar /devsunky-email-notification-0.0.1-SNAPSHOT.jar

CMD java -jar /devsunky-email-notification-0.0.1-SNAPSHOT.jar






