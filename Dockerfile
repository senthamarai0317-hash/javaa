FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY hotelserver.java .

RUN javac hotelserver.java

EXPOSE 5550

CMD ["java", "hotelserver"]
