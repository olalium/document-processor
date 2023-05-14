# document-processor 📄📄📄
A helpful boilerplate for document processing of multiple file formats (.pdf, .json, etc...),
using Spring Boot (Kotlin) and Apache Tika

# Setup
## Prerequisites
Java 17
## install, compile and build jar
1. to install dependencies, compile and build jar run ```./gradlew build```
2. then run the outputted jar with ```java -jar ```
## Docker setup
1. run `./gradlew build`
2. run `docker build -t <myorg>/document-processor .`
3. run ` docker run -p 8080:8080 <myorg>/document-processor`