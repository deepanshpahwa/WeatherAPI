# RestFul Web Services (Using Java and AWS)

This application provides weather information to the developer in the form of JSON array. Various endpoints(GET, POST, DELETE) of the application can be used to access different kinds of weather data depending on the requirement.



The current URL to access the API is http://ec2-18-223-149-213.us-east-2.compute.amazonaws.com:8080/WeatherAPI/api

## Endpoints information
| Method        | Endpoint URL    | Use   |
| ------------- |:-------------:  | -----:|
| GET           | /historical     |All the dates the database holds|
| GET           | /historical/date|Weather for the day specified |
| POST          | /historical     |(201 Created) |
| DELETE        | /historical/date|(200 Deleted) |
| GET           | /forecast/date  | Weather data of 7 days from mentioned date|

## Overview
The application is developed on plain Java using some third party libraries for support (GSON, Jackson). The application is deployed on Apache Tomcat version 8.

This application was then packed into a war file and deployed onto the same version of Apache Tomcat installed on an AWS EC2 instance.

The URL mentioned above is of the EC2 instance with 8080 to access the default port to take the user to the API.

### Prerequisites
Internet connectivity
Web browser

### Installations required
Apache Tomcat
Java JDK

### References
Deploying Java Web Application war file on Tomcat Server running on remote machine
https://www.youtube.com/watch?v=_d-c9uGcUrU

### Author
Deepansh Pahwa
