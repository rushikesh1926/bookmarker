FROM eclipse-temurin:21.0.5_11-jre

# Install minimal debugging tools
RUN microdnf update && \
    microdnf install -y findutils procps && \
    microdnf clean all

ADD target/*.jar app.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]
