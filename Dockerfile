FROM openjdk:17
COPY "./target/SportFit-0.0.1.jar" "app.jar"
EXPOSE 8070
ENTRYPOINT [ "java","-jar", "app.jar" ]