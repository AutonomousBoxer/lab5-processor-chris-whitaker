# lab5-processor-chris-whitaker
## Description

- This project is the processor side of the lab using Quarkus Reactive Messaging with RabbitMQ. 


- The processor subscribes to RabbitMQ queues that receive `Student` messages from the producer application. It uses 
  routing keys based on GPA to send students to different consumers.

- ### Routing Keys:
    - The producer sets the RabbitMQ routing key based on GPA. The processor subscribes to:
        - `gpa40` to President's List.
        - `gpa35` to Dean's List.


- ### This Application Uses:
  - quarkus-messaging-rabbitmq 


## Installation Instructions:

- Java 17+
    - [Eclipse Temurin JDK 17 (Adoptium)](https://adoptium.net/temurin/releases/?version=17)
    - [Oracle JDK 17 Downloads](https://www.oracle.com/java/technologies/downloads/)
- Maven 3.9+
    - [maven.apache.org/install.html](https://maven.apache.org/install.html)

- ### Verify installs

    ```bash
    java -version
    mvn -version
    ```

- ### Download the project ZIP
  - Download the project.
  - Extract the ZIP to a folder.
  - In a terminal navigate to the folder.

## How to Run the Code

- You can run your application in dev mode that enables live coding using:

    ```shell script
    ./mvnw clean compile
    ```

    ```shell script
    ./mvnw quarkus:dev
    ```

## File Structure
    src/
        main/
            java/
                edu/franklin/lab5/chriswhitaker/
                    Student.java
                    StudentProcessor.java
            resources/
                application.properties

## Known Issues
- Only the President's List `gpa40` and Dean's List `gpa35` are implemented.

## Author
`Chris Whitaker`