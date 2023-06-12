FROM maven:3.8.3-openjdk-17 AS MAVEN_BUILD

COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/
RUN mvn clean install -Dmaven.test.skip=true

FROM maven:3.8.3-openjdk-17

WORKDIR /app

COPY --from=MAVEN_BUILD /build/target/calculator-0.0.1-SNAPSHOT.jar /app/calculator.jar

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "calculator.jar"]