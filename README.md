# JWT Token Generator and Email Sender

- Server side code module - backend (Jetty server running on port 8080)
- Client side code module - frontend (HTML running on NodeJS server - port 1593)

# Pre-requisites
- Java 8
- Maven
- NodeJS

# Steps to execute the code
- Create a directory named ```jwt-tges```
- Inside jwt-tges, clone this repo using ```git clone https://github.com/ruch0401/jwt-token-generator-email-sender.git```
- Open the cloned repo in Intellij (or the IDE of your choice)
- In the terminal, navigate the the backend module of the code and run the following commands simultaneously

> cd backend  
> mvn clean install -DskipTests  
> mvn jetty:run

- Now, open another terminal and navigate to the frontend code using ``` cd frontend```
- In the terminal, run the following command - 
> npm install

You may have to run ```npm audit fix``` in case of any vulnerabilities found. 

- Once all the node modules have been downloaded, run the node server
> node app.js

At this point, both your backend and frontend servers are running, access the frontend on this URL - http://localhost:1593

|![jetty-server-start.PNG](https://github.com/ruch0401/jwt-token-generator-email-sender/blob/master/jetty-server-start.PNG)|
|:--:|
| *Jetty Server - Running*|