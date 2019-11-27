FROM openjdk:8-jdk 
VOLUME /tmp 
COPY target/CodeChallenge-0.0.1-SNAPSHOT.jar code-challenge.jar 
ENTRYPOINT ["java","-jar","/code-challenge.jar"] 