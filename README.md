This project implements SpringBoot + Swagger.

To interact with Swagger UI you can use directly swagger-ui.html or
connect to https://editor.swagger.io/.
For the first way you should connect to http://localhost:8888/bookstore/swagger-ui.html
while for the second you should copy and paste the Json that
comes from http://localhost:8888/bookstore/v2/api-docs in https://editor.swagger.io/.

The port and the root path are set in /src/main/resources/application.properties.

The only thing to do to be compliant with Swagger is to add a configuration class
for Swagger like in /src/main/java/bookStore/configurations/SwaggerConfig