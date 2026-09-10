FROM maven:3.8.8-amazoncorretto-21 AS build
WORKDIR /workspace
COPY pom.xml ./
COPY src ./src
RUN mvn -B -DskipTests package

FROM amazoncorretto:21-alpine-jdk
WORKDIR /app
COPY --from=build /workspace/target/*.jar /app/
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "JAR=$(find /app -maxdepth 1 -type f -name '*.jar' | head -n 1); exec java -jar \"$JAR\""]
