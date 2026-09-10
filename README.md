# ParkingSuggestionAPI

ParkingSuggestionAPI is a Spring Boot service providing a REST API to retrieve nearby parking locations for a given position (by city). The service fetches real-time data from public APIs (ex Poitiers), maps them into internal DTOs, calculates the distance from the requested location, and returns a filtered and sorted list.

## Reflexion on Architecture 
Reflexion of the architecture of the system can be found in the [Architecture.md](Architecture.md) file.

## Main Features

- GET /api/v1/parkings endpoint to retrieve parkings around a position.
- Extensible architecture by city provider and specific mappers per city.
- Usage of Feign to call external APIs.
- DTO -> API model mapping via specific ParkingMapper implementations for each city.
- Optimized distance calculation in meters (equirectangular approximation, fast for local distances) and filtering by radius.

## Stack technique

- Java 21 
- Spring Boot
- Spring Cloud OpenFeign
- Jackson pour JSON
- Maven


## Configuration

External Api configuration in `application.properties` / `application.yml`.

```properties
# URL pour Poitiers (exemple)
cities.poitiers.url=https://data.grandpoitiers.fr/data-fair/api/v1/datasets/mobilites-stationnement-des-parkings-en-temps-reel/lines

# Port de Spring Boot (optionnel)
server.port=8080
```

## Run

Dev : `mvn spring-boot:run` 

## Endpoint

### API Documentation
http://localhost:8080/v3/api-docs

### API Test with swagger
http://localhost:8080/swagger-ui.html

GET /api/v1/parkings

Paramètres query :
- city (required) : 
- latitude (optional) 
- longitude (optional) : longitude de l'utilisateur
- radiusInMeters (optional) : rayon en mètres pour limiter les résultats (défaut 5000 côté API OpenAPI)

Example :

```
curl -v "http://localhost:8080/api/v1/parkings?city=poitiers&latitude=46.5802&longitude=0.3401&radiusInMeters=2000"
```

Response Extract :

```json
{
  "total": 5,
  "parkings": [
    {
      "id": "1",
      "name": "NOTRE DAME",
      "capacity": 146,
      "availablePlaces": 74,
      "distanceInMeters": 320,
      "latitude": 46.583498,
      "longitude": 0.345002,
      "lastUpdated": "2026-09-09T19:21:02Z"
    }
  ]
}
```

## Build & Deploy
- Dockerfile :
```
docker build --no-cache -t parkingsuggestionapi .
docker run --rm -p 8080:8080 parkingsuggestionapi
```

- Docker-compose 
```
docker-compose up -d
```







