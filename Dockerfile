FROM eclipse-temurin:17-jre

WORKDIR /app

COPY target/BattleshipGame-2.0.jar app.jar

CMD ["java", "-jar", "app.jar"]