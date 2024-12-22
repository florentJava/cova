

FROM openjdk:21

EXPOSE 4205

ADD target/cova.jar cova.jar

ENTRYPOINT [ "java" , "-jar" , "/cova.jar" ]  