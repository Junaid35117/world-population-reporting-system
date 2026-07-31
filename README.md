# World Population Reporting System

A Java application that generates population reports from the SQL World database.

This project was developed as part of the Software Engineering Methods module using Java, Maven, MariaDB, GitHub, GitHub Actions, and Docker.

---

## Features

### Country Reports

- All countries ordered by population
- Countries by continent
- Countries by region
- Top N populated countries

### City Reports

- All cities ordered by population
- Cities by country
- Cities by district
- Capital cities
- Top N capital cities

### Population Reports

- World population
- Continent population
- Region population
- Country population
- District population
- City population

### Language Reports

- Chinese
- English
- Hindi
- Spanish
- Arabic

---

## Technologies

- Java 17
- Maven
- MariaDB
- JDBC
- JUnit 5
- Git
- GitHub
- GitHub Actions
- Docker

---

## Project Structure

```
src
 ├── main
 │   ├── java
 │   │   └── com.junaid
 │   │       ├── application
 │   │       ├── database
 │   │       ├── model
 │   │       ├── repository
 │   │       ├── report
 │   │       ├── service
 │   │       └── util
 │   └── resources
 └── test
```

---

## Database

The project uses the official World database.

Database:

```
world
```

Tables:

- country
- city
- countrylanguage

---

## Build

```bash
mvn clean package
```

---

## Run

```bash
java -jar target/world-report-1.0-SNAPSHOT.jar
```

---

## Testing

Run unit tests

```bash
mvn test
```

---

## Docker

Build image

```bash
docker build -t world-report .
```

Run container

```bash
docker run -it world-report
```

**Note**

The Docker container expects a MariaDB database to be available. When using Docker Desktop, configure the database host appropriately (for example, `host.docker.internal`) or run the database in a separate container.

---

## Continuous Integration

GitHub Actions automatically:

- Builds the project
- Verifies each push and pull request

---

## Author

Junaid
