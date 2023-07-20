# Naming Convention

## 1. Innitial
### 1.1. Innitial Project

- **Project Type**: `Maven`
- **Language**: `Java`
- **Spring Framework**: `3.2.0`
- **Project Metadata**:
  - **groupId**: `flightbooking.microservices`
  - **artifactId**: `<Service Name>-service`
  - **Packaging**: `Jar`
  - **Java Version**: `11`
- **Note**:
  - `groupId`: lowercase, must have a dot in between each word
  - `<Service Name>`: lowercase, must have hyphen in between each word

- ### Example:
![image](https://github.com/VinhTuan-Nguyen/flight-booking/assets/90610857/42faca96-78f0-4c2b-81e3-0e647fd5b86f)

### 1.2. Inintial pom.xml File
- Project version: `1.0.0`

## 2. Organize Project Structure
```
/<Git Repo Name>
  /<Project Name 1>
    /src
      /main
        /java/flightbooking/microservices/<Service Name>
          /models
          /controlers
          ...
          <Service Name>Application.java
        /resources
          /config
            application.properties
          ...
      /test
        ...
  <Project Name 2>
  <Project Name 3>
  ...
```
- ### Example
![image](https://github.com/VinhTuan-Nguyen/flight-booking/assets/90610857/725f08af-b14b-4d8e-86ed-ccd7b1235c0b)

## 3. Files Naming Convention
  
