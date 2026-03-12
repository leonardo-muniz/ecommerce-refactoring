# Estágio 1: Build
FROM maven:3.9-eclipse-temurin-25 AS builder
WORKDIR /app

# Copia o pom.xml e baixa as dependências (aproveita o cache do Docker)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia o código-fonte
COPY src ./src

# Empacota a aplicação em um JAR, pulando testes (delegados para o pipeline de CI)
RUN mvn clean package -DskipTests

# Estágio 2: Execução
FROM eclipse-temurin:25-jre-alpine
LABEL org.opencontainers.image.authors="leonardomuniz"
WORKDIR /app

# Copia o artefato JAR gerado no estágio anterior
COPY --from=builder /app/target/*.jar app.jar

# Executa apontando o classpath para o JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
