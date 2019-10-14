FROM openjdk:12-alpine

COPY target/devsunky-email-notification-*.jar /deployments/devsunky-email-notification.jar

CMD ["java", "-jar", "deployments/devsunky-email-notification.jar"]






