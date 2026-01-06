FROM eclipse-temurin:8-jre-alpine

WORKDIR /app
COPY ruoyi-admin/target/ruoyi-admin.jar app.jar

EXPOSE 8080

# 限制 JVM 内存使用，适配 512MB 限制
ENTRYPOINT ["java", \
    "-Xmx400m", \
    "-Xms256m", \
    "-XX:+UseSerialGC", \
    "-Djava.security.egd=file:/dev/./urandom", \
    "-jar", "app.jar"]