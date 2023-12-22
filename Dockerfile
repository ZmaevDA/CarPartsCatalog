FROM eclipse-temurin:17-alpine
WORKDIR .
COPY CRM/target/CarCatalog-0.0.1-SNAPSHOT.jar CRM.jar

ENTRYPOINT ["java","-jar","CarCatalog.jar"]