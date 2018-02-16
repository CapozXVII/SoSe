# Enjoy Reservation

## Getting Started

Following list shows the technologies and tools used in Enjoy Reservation system.

* [JDK - 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Eclipse Oxygen - 2](http://www.eclipse.org/downloads/eclipse-packages/)
* [Tomcat - 8.5](https://tomcat.apache.org/download-80.cgi) 
* [Maven - 3.5.2](https://maven.apache.org/download.cgi)

Download and install the tools and set the environment variables as given in the installation document of respective tools. Below are the few setups we need for this application.

* Download this Github Repository.
* Open all the Maven applications in Eclipse Oxygen, except for the “routingrequests” one. Please refer "cald.sql" file inside the folder database in each projects to create Tables in MySQL Database, which are required by all the applications.
* Running all the applications that you have just opened on Tomcat within Eclipse. Probably you need to increase Tomcat timeout because the server may take time to run all the applications. 
For this purpose, please: Open the Servers view -> double click tomcat -> drop down the Timeouts section.
There you can increase the startup time for each particular server. I suggest to set it at one minute.
* You have to add the “enjoRreservation” application in your local repository. 
For this purpose, open command prompt, go to enjoyReservation folder and execute below command.
```
mvn install
```
* You can now build and run the controller application “routingrequests” using below command.
```
mvn clean package
```
Then open command prompt, go to target folder and execute below command. 
```
java -jar routingrequests-1.0.0.jar.
```
