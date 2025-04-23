# Usamos una imagen oficial de Java 17
FROM eclipse-temurin:17-jdk

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el JAR de la aplicación dentro del contenedor
COPY target/my-appointments-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto en el que corre Spring Boot
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]
