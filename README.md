# AirCompaniesManagementSystem

## Startup my application
Requirements:
+ Docker
+ Postman

You need use the scrips below to build .jar file ( 1 ), create the image ( 2  ), download the image of mysql:8 and set db_name & password ( 3 ) and run container ( 4 )

1. **Open terminal in the root of the project and use this commands:**
+ '.\mvnw package -DskipTests=true\'
+ 'docker image build -t acsm-image .'
+ 'docker container run -p 3305:3306 --name mysqldb --network acms-mysql -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=acsm -d mysql:8'
2. **wait a minute for the container to start running and use script below**
+ 'docker container run -d --name acsm-container -p 9091:9091 --network acms-mysql --link mysqldb:mysql acsm-image'

3. **In the docker project you should have 2 images and 2 containers:**

![image](https://github.com/NazzP/AirCompaniesManagementSystem/assets/123106736/7b6c37d3-6606-4940-8f88-cd33117a8ae8)
![image](https://github.com/NazzP/AirCompaniesManagementSystem/assets/123106736/218da5ca-7f90-470d-a44a-bacb5d1af921)

4. **Open Postman and import AirCompanyManagmentSystem.postman_collection (project root directory)**

![image](https://github.com/NazzP/AirCompaniesManagementSystem/assets/123106736/29eedc25-e558-4f7d-91f6-6479174522b9)

## Tech stack
+ **Java 11**
+ **Spring AoP/Core/Boot**
+ **Hibernate**
+ **MySQL**
+ **Swagger**
+ **Maven**
+ **Docker**
+ **Postman**

## Database
![image](https://github.com/NazzP/AirCompaniesManagementSystem/assets/123106736/08bc8d6d-7578-4e21-8217-c590d0d333a7)

## Swagger. REST APIs Documentation
![image](https://github.com/NazzP/AirCompaniesManagementSystem/assets/123106736/5ef687d9-6fc3-4ffc-88a4-e906be6d7bdb)
