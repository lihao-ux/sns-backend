# Dockerfile 
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY ruoyi-admin/target/ruoyi-admin.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]