# Usar uma imagem base oficial do OpenJDK para Java 17
FROM openjdk:17-jdk-slim

# Definir o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copiar o arquivo JAR do seu projeto para o contêiner
COPY target/ProjetodeExtencao-0.0.1-SNAPSHOT.jar app.jar

# Expor a porta que o seu aplicativo Spring Boot usa (geralmente 8080)
EXPOSE 8080

# Comando para executar o aplicativo quando o contêiner for iniciado
ENTRYPOINT ["java", "-jar", "app.jar"]