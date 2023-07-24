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
- File name must have lowercase and hyphen between each word

## 4. Git
- Create branch brief and concise for each child task
- Before push commit into your branch, check Development branch status
- If find out new update, pull and merge into your branch then re-push into git
- After create Pull Request, ping another member review theses code and waiting for approve 
- follow these below to create new branch

### 4.1. Branch Name
- Root Branch: `main`
- Development Branch: `Development`
- Feature Branch: `<Project Name>`/feature/`<Feature Implement>`
