# Architecture of the Application 

Dev Environment:
- Java 21   
- Spring Boot 3.2.0
- Maven 4.0.0
- Spring Web 6.2.0

Testing Environment:
- JUnit 5.10.0
- Mockito 6.2.0
- Spring Boot Test 3.2.0
- Spring Web 6.2.0

Running Environment
- Docker
- Docker Compose

Architecture choice
Point 1 
In the application we see that there  external API used by the project, this may lead to think to use an Hexagonal architecture
with adaptor to change each time we change the external provider. This type of Architecture could be heavy for implementation
regarding the simplicity of this exemple.
The choice here comes to simple API Rest that Act as an agragator of data based on layers to seperate the logic

Point 2 
The initial description does not precise the TPS needed neither the volumetry of calls so the solution should also cover the performances issues
by using caching as well as the resilience HTTP (because we have external calls) and the scaling docker/k8s

Point 3 Conception
API-First is chosen over Code-first for the design


