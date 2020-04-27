# LibraryApplication

This application has two projects:

1. libraries-books-app - UI (Angular)
2. library-management-service - Back End Service

## Follow the steps to bring up the application:
	
1. To run the backend service, run library-management-service as a spring boot application
	- Once the service starts use this url to confirm if the service is up & running 'http://localhost:8080/'
	- This service will configure the in-memory h2 database and its console can be accessed using 'http://localhost:8080/h2'
	
2. Run the following queries to insert the library records:
	- INSERT INTO LIBRARY VALUES(100, 'Bangalore', 'BLR Library');
	- INSERT INTO LIBRARY VALUES(200, 'Chennai', 'CHN Library');

3. To bring up the UI:
	- i. Run ```npm install``` command from the directory libraries-books-app
	- ii. Run ```ng serve``` command to run the application.
	- iii. Applicaiton starts on url http://localhost:4200
	
The application starts with added libraries showing in the drop down. 
User can select a library and perform book operations like get/add/update/delete book on that library.	