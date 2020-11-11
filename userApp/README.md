# userApp
Spring boot project that allows CRUD of users with RestAPI.

Requirements:
* To run this application there are the following requirements:
* Java 11 SDK
* Maven (Latest version)
* MySQL server for the database schema


Build:
* Go to the project folder from terminal
* Run the following command 
* mvn clean install

DB setup:
* You can use db.sql file to create the db schema in a MySQL server
* Go to application properties
* Replace values in application.properties files :
  * spring.datasource.url= ??
  * spring.datasource.username=??
  * spring.datasource.password=??

Run:
* Run the following command
* mvn spring-boot:run

The project is running under http://localhost:8080/app/user
