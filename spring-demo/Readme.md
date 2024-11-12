## Requirements
1. Java 17
2. Docker compose
3. Spring boot 3
4. Postgres
5. Liquibase

## IntelliJ IDEA

#### Specify project SDK version and gradle SDK version.

1. File -> Project Structure -> Project Settings -> Project -> SDK -> Java17
2. File -> Settings -> Build, Execution, Deployment -> Build Tools -> Gradle -> Distribution -> Wrapper
3. File -> Settings -> Build, Execution, Deployment -> Build Tools -> Gradle -> Gradle JVM -> Java17
![img_1.png](img_1.png)
![img_4.png](img_4.png)

## Start application
1. Docker compose up

        docker-compose up -d
2. Build application jar

        ./gradlew build -x test
3. Apply migrations

        ./gradlew update
        
4. Run application. Option 1

       ./gradlew bootRun
         
5. Run application. Option 2
 
       java -jar build/libs/renlife_demo-0.0.1-SNAPSHOT.jar

## Test

1. Run tests
         
        ./gradlew test

### URLs
1. GET  http://localhost:8089/public/v1/factorial/{num}
2. POST http://localhost:8089/api/v1/fact
3. GET  http://localhost:8089/api/v1/products