## gitwebservice
## Description

REST web service for **Allegro**, which purpose is to fetch repositories from GitHub using API.
Application fetch information about repository with given name for specified user.
API calls has been performed with a little help of **Retrofit** library.

Project uses port **8080**. (Example path: *http://localhost:8080/api/repositories/karczekzkurczaka/gitwebservice*)

See documentation to get information how to use Api.

## Setup

To build application run command *mvn clean install* from root directory of project.
To start server run: *mvn spring-boot:run*

## Documentation

REST API documentation is available under [localhost:8080/swagger-ui.html](localhost:8080/swagger-ui.html)
Above documentation has been created with help of **Swagger2** library.

## Technologies

Technologies used in project:
* Java 8
* Spring Boot
* Lombok
* Retrofit
* Mapstruct


## Author
Paweł Burmer