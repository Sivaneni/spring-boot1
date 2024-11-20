# Builder stage
FROM eclipse-temurin:17-jdk as builder
WORKDIR application
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar

# Final stage
FROM eclipse-temurin:17-jre
WORKDIR application
COPY --from=builder application/dependencies/ ./
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/application/ ./
ENV JAVA_OPTS="-Djavax.net.ssl.trustStore=splunk.jks -Djavax.net.ssl.trustStorePassword=password -Djavax.net.debug=ssl:handshake"
# Copy the Splunk certificate
COPY splunk-cert.pem /etc/ssl/certs/splunk-cert.pem

# Import the certificate into the Java truststore
RUN keytool -import -trustcacerts -alias splunk -file /etc/ssl/certs/splunk-cert.pem -keystore $JAVA_HOME/lib/security/cacerts -storepass changeit -noprompt

ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
