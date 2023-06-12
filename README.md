# True North - Arithmetic Calculator

To run it locally please execute:

- docker compose build

It will generate a docker image that will contain the jar application to be executed. Please remove "-Dspring.profiles.active=prod" from the Dockerfile.

-- ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "calculator.jar"]

To launch it please run:

- docker compose up

It will launch the application in the port 5000, and a postgres db.

To interact with it live please visit: https://arithmetic-calculator.onrender.com


