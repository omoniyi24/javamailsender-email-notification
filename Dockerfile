FROM openjdk:jdk-alpine

COPY ./target/devsunky-email-notification-0.0.1-SNAPSHOT.jar /deployments/

CMD java -jar /deployments/devsunky-email-notification-0.0.1-SNAPSHOT.jar






