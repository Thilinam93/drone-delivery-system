# **Drone Delivery System**

Sample project for manage drones to delivering medications

# **Assumptions**

* A drone only contains medications in state of LOADING, LOADED or DELIVERING.
* All the security implementation are handled by API Gateway and frontend, so not implementing security in this service.
* Same medicine can come with different weight with but same code, so introduce medicine_id as primary key.
* Drone is considered as available if and only if it is in IDLE, LOADING or RETURNING state and battery level is more than 25%.
* All images are stored in separate server such as S3 bucket, and I have stored the image resource url in the MEDICATION database.
* Since the Data Base is in-memory indexing is not introduced.
* Medicine are considered as an unlimited deliverable loads and not implement and maintaining medicine inventory.
* Medicine can be loaded to the drone only in countable integer multiplications.
* Some medicine are heavier than 500gr.
* You can add N numbers of medicine to drone by adding same medicine N times.
* Database credentials are in application.yml file since this is a sample project, otherwise they should move to separate config server.

# Instructions

Please find the bellow end points and instructions to test this drone-delivery service. Even there are two environments (dev, prod), here I have used only dev environment. If you need run application in prod environment you can use command line arguments.

# Build the project

* Unzip the zip file and collect project
* Open the terminal and execute mvn cleaninstall -DskipTests
* Or go to the project folder and run build.sh using command ./build.sh in terminal
* Make sure that you are using Java 8, Spring Boot 2.x and Maven
* Run the Project
* If you are using an editor use that to run project.
* Or else go to the project folder and execute command ./run_drone_delivery_system.sh
* Or go to the jar file location and execute command java -jar drone-delivery-system-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev
* Logs and Log Files
* You can find log files in bellow locations.

# dev environment

* Server access logs : logs/dev/drone-delivery-system-access
* Application logs : /logs/drone-delivery-system.log

## Swagger
* http://localhost:8080/drone-delivery-system/swagger-ui/index.html/


## H2 Database Console
* http://localhost:8080/drone-delivery-system/h2-console
* Password can be found in application.yml file

## Developed By Thilina Madusanka