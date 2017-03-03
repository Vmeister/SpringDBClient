# SpringDBClient
Database Client with Spring Boot, Spring Security and Hibernate

How to use:

1. Install Maven

2. Install preferred IDE that supports Maven.

3. Install MySQL database.

3.5 Add a new database called springdbclient or edit the application.properties file to use another database.

4. Run the application in preferred way, the pom.xml file ensures dependencies are downloaded automatically.

5. When the spring server is up and running, navigate to localhost:8080/

6. Log in using admin/password or user/password account credentials.

7. Enjoy.

Issues:

There's a method in the main class DBClientApp that will cause issues after first server run. Fixes are work in progress.
Best to comment out the Bean-method once database has been initialized.
