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

At this point, both your backend and frontend servers are running

|![jetty-server-start](https://user-images.githubusercontent.com/29031675/125884963-68508043-a8c0-4d50-852d-c0bdedaac346.PNG)|
|:--:|
| *Jetty Server - Running*|

|![node-server-start](https://user-images.githubusercontent.com/29031675/125885049-82bf6cb6-8eaa-4076-b86e-139a2e0ded5c.PNG)|
|:--:|
| *Node Server - Running*|

 Visit the frontend URL here - http://localhost:1593
 
| ![web-page](https://user-images.githubusercontent.com/29031675/125886611-e6f9942d-5e62-4eae-915a-dbd2633cb3e0.PNG)|
|:--:|
| *Frontend UI*|

Fill the form according to the following details - 

|Input Field|Description|Example|
|------------|------------|------------|
|User ID|The user's ID for whom the token has to be generated|rb20180|
|Consumer App Key|The consumer app key for which the token has to be generated (This can be either entered manually, or selected from the drop-down menu)|4e520b52-af67-4b20-bf6e-b17c5ccb68c5|
|Token Validity|The number of days, for which the token generated, will remain valid|30 (This means that the generated token will remain valid for 30 days)|

Click on the ```Generate Token``` button to generate the JWT Token. This is populated in the FlowBuilder Token input field.

|Input Field|Description|Example|
|------------|------------|------------|
|To List |Email ID to which the email has to be sent|bryam.adams@zs.com (This can be separated by a semi-colon for multiple recipients)|
|CC List|Email ID to which the email has to be sent (as CC recipients)|user1@zs.com;user2@zs.com|
|FlowBuilder Release Tag|FlowBuilder Release Tag|R4.7|
|FlowBuilder Client|The client name for which the token has been generated|OE QA|
|FlowBuilder Version|The latest version which has been deployed to the Pre-Prod environment|14.0.23.0|
|FlowBuilder Base URL|The URL where the clients will be testing out the flows|https://verso.staging.zsservices.com/ccm-0071fbg/web|
|Sender's name|The name of the person who is sending the email|Ruchit Bhardwaj|

| ![web-page](https://user-images.githubusercontent.com/29031675/125886611-e6f9942d-5e62-4eae-915a-dbd2633cb3e0.PNG)|
|:--:|
| *Frontend UI - Filled Form*|

Clicking the ```Send Email``` button will open your mahcine's default email application.

![email-preview](https://user-images.githubusercontent.com/29031675/125884689-1f0b65b0-27a0-45fb-a73b-706a6468ab37.PNG)
|:--:|
| *Email Preview*|
