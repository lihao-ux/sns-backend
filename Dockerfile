FROM maven:3.8.4-jdk-8 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:8u312-jre-slim
WORKDIR /app
COPY --from=build /app/ruoyi-admin/target/ruoyi-admin.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]