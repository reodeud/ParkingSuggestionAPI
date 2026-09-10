# Architecture of the Application

## Environments

* **Dev Environment:** Java 21, Spring Boot, Maven, Spring Web
* **Testing Environment:** JUnit, Mockito, Spring Boot Test, Spring Web
* **Running Environment:** Docker, Docker Compose

---

## Architectural Choices

### Point 1
In the application, we see that there are external APIs used by the project. This may lead one to think of using an **Hexagonal Architecture** based on use cases by city, with adapters to switch whenever we change the external provider. However, this type of architecture could be overly heavy for implementation given the simplicity of this example.

The choice here comes down to a **simple REST API** that acts as a data aggregator, using layers to separate the logic.

### Point 2
The initial description does not specify the required TPS or the volume of calls. Therefore, the solution should also cover performance issues by using **caching**, ensuring **HTTP resilience** (due to external calls), and enabling **scaling** via Docker / K8s.

### Point 3: Conception
Design is made before coding, so some code was generated directly from the API specification.


### Enhancements that could be done
- this appli is just developped for the perspective of parking need, as we can see in the scrennshot of the front a similar work could be done for other service like bike .. So the application could be split as microserices each one deals with an endpoint specific for a need for example.  Or we can customise the endpoint to handle all in one openAPI /parking /bike /...
- We give the city, lat et long, but ideally we can have an external provider to guess the city
- We can add a Redis to enhance performances
- Security of the API could be added using JWT / Spring security for example to secure the access to the API
- Add more Tests to have coverage till 100%
 
