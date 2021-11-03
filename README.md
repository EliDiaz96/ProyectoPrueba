##Prueba Tecnica 
** Elizabeth Castro Díaz **

##Solucion de la prueba 
Se realiza el desarrollo de la prueba con Spring boot, angular y docker, en la parte back realice un microservicio llamado apiDetecter que su funcionalidad principal es a partir de la ruta del archivo y el dominio a verificar hallar similitudes y guardarlas en base de datos. En la parte de angular realice una vista muy simple de consumo para verificar que el dominio se encuentre o no registrado y en la parte de docker subi tanto servicio como la base de datos.

## Modo de construirlo o empaquetarlo
Dentro de la carpeta donde se aloje el proyecto
Comando: mvn clean install -DskipTests=true

##Como dockerizarlo o construir la imagen de docker
Comando para el proyecto de spring boot: docker-compose up

##Como ejecutar el contenedor de Docker
Comando:docker run -d api-detector

##Diagramas
diagramas/diagramaPrueba.drawio
diagramas/diagramaPrueba1.drawio