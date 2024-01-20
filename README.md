# Kaiburr Task 4
## CI-CD pipeline for the application built in Task 1

### About the task 
The entire source code of the application is pushed to the repository and the CI/CD workflow is automated. The tool used to automate the workflow is using GitHub Actions. Since GitHub is used as a repository to store code, it can directly be used as a CI/CD tool. This way it makes integration easier. Whenever there is a push or pull request action to the repository, the corresponding action takes place. Hence an `action` for an `event`. 

&emsp;Task 1: Build the Spring Boot project using Maven.  
&emsp;Task 2: Dockerize the resulting package or JAR using docker.  
&emsp;Task 3: Push the docker image to the `docker hub repository`.  
### Screenshots

#### Commit Source Code to GIT
![Commit Source Code](https://github.com/M-JB413/KaiburrTask4/assets/83492132/74140dbd-560c-437c-b859-8c13e15d1693)

#### Setting up Java Build with Maven using GitHub Actions
![Actions Build Maven](https://github.com/M-JB413/KaiburrTask4/assets/83492132/21bffe36-d74a-430f-aae5-bd664dfca1b6)

#### Status of the First Build
![First Build Status](https://github.com/M-JB413/KaiburrTask4/assets/83492132/71ade1d6-9652-4ec8-b1e1-121c63e7710f)

#### Private repository creation in Docker Hub
![Private Repository Creation](https://github.com/M-JB413/KaiburrTask4/assets/83492132/5a179d57-c974-4a2e-9b7f-b7c1f885b063)

#### Setting the Docker Credentials as Repository Secrets in GitHub
![Setting Up Secrets for Docker Login](https://github.com/M-JB413/KaiburrTask4/assets/83492132/708fb2b9-2c68-48a3-ace1-6a1872c58f25)

#### YAML file update for dockerizing the Maven build
![Code to Dockerize](https://github.com/M-JB413/KaiburrTask4/assets/83492132/f7a41f95-3fa1-4e52-8163-7d9df4e7791b)

#### Status of the build after adding docker actions
![Docker Build Status](https://github.com/M-JB413/KaiburrTask4/assets/83492132/d7e5c6ac-0528-4662-b7cf-916b263e1fe3)

#### Result of Docker Build in Docker Hub Repository
![Docker Build Result](https://github.com/M-JB413/KaiburrTask4/assets/83492132/a5b3a40b-73bb-4000-852b-441d959b10f7)

