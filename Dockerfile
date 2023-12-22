FROM eclipse-temurin:17-alpine
WORKDIR /app
COPY CarPartsCatalog/target/CarCatalog-0.0.1-SNAPSHOT.jar CarPartsCatalog.jar

ENTRYPOINT ["java","-jar","CarPartsCatalog.jar"]