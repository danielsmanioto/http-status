FROM adoptopenjdk/openjdk11

COPY ./build/libs/http-images-spring-boot-0.0.1-SNAPSHOT.jar /usr/app/http-images-springboot.jar

WORKDIR /usr/app

ENTRYPOINT ["java","-jar","/usr/app/http-images-springboot.jar"]