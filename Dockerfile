FROM eclipse-temurin:17-alpine
WORKDIR .
COPY target/CarPartsCatalog-0.0.1-SNAPSHOT.jar CRM.jar

ENTRYPOINT ["java","-jar","CarPartsCatalog.jar"]