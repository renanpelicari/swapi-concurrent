# Java Concurrent with Future
This POC show how to handle with concurrency and asynchronous using Future.
Also using Feign to consume the [Star Wars API](https://swapi.co/).

## How it works
Basically the this POC connect simultaneously at Star Wars API and consume a massive information.
Process all those data asynchronously and response all together.

## Tech Stack
* [Gradlew](https://docs.gradle.org/current/userguide/gradle_wrapper.html) (build automation - wrapper version);
* [Spring Boot 2](https://projects.spring.io/spring-boot/);
* [Feign](http://www.baeldung.com/intro-to-feign) (make easier to consume webservices);
* [RESTFul API](https://restfulapi.net/) (webservices to expose the endpoints);
* [Actuator](https://spring.io/guides/gs/actuator-service/) (to expose some endpoints to manage application easily);
* [Swagger](https://swagger.io/) (to expose the docs of endpoints);
* [JUnit](http://junit.org/junit4/) and [Mockito](http://site.mockito.org/) for unit test purposes;
* [Jersey](https://jersey.github.io/) and [JAX-RS](https://github.com/jax-rs) (turn easy RESTFul WEB Services development);
* [Jetty](https://www.eclipse.org/jetty/) (servlet container);
* [Log4J](https://logging.apache.org/) (handle logs easily);

## Requirements
* Java SE 8 or higher

## About gradlew
This project contains gradlew 4.2.

So you don't need to install or config gradle, you can use this embedded version.

To execute you just need to be at project initial folder and run the command: `./gradlew <task>`

## Building Project
`$ ./gradlew clean build`

## Run Application
`$ ./gradlew bootRun`

## Usage
By default, the application will start at port 8080, and will expose some endpoints.

You can check the endpoints with the properly documentation at the address:
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Also I attached the [postman](https://www.getpostman.com/) collection at resource folder.

## Author
* Renan Peliçari Rodrigues
* renanpelicari@gmail.com
* https://www.linkedin.com/in/renanpelicari/
* https://github.com/renanpelicari
