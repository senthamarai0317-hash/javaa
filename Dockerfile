FROM openjdk:17-jdk-slim

WORKDIR /app

COPY hotelserver.java .

RUN javac hotelserver.java

EXPOSE 5000

CMD ["java", "hotelserver"]
