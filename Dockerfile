# 最简单的 Dockerfile - 不需要构建，直接运行
FROM openjdk:8-jre-slim
WORKDIR /app
COPY ruoyi-admin/target/ruoyi-admin.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]