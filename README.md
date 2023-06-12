# True North - Arithmetic Calculator

To run it locally please execute:

- docker compose build

It will generate a docker image that will contain the jar application to be executed. Please remove "-Dspring.profiles.active=prod" from the Dockerfile.

-- ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "calculator.jar"]

To launch it please run:

- docker compose up

It will launch the application in the port 5000, and a postgres db.

To interact with it live please visit: https://arithmetic-calculator.onrender.com

Endpoints:

/v1/auth/register

<img width="1150" alt="image" src="https://github.com/matiasballester/truenorthcalculator/assets/1633890/85474f16-d2e5-425d-8ba1-c1fa468cc5e1">

/v1/auth/login

<img width="1144" alt="image" src="https://github.com/matiasballester/truenorthcalculator/assets/1633890/3fab599b-6215-4678-aaaf-359e8864e709">

/v1/math/addition

<img width="859" alt="image" src="https://github.com/matiasballester/truenorthcalculator/assets/1633890/39d121c8-4d94-4e5b-9f6b-a8bb3156bf94">

/v1/math/multiplication

<img width="881" alt="image" src="https://github.com/matiasballester/truenorthcalculator/assets/1633890/1a711535-3a7f-4b94-807c-9d2b9b908e7a">



