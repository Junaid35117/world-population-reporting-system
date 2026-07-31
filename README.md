# World Population Reporting System

A Java application that generates population reports from the SQL World database.

This project was developed as part of the Software Engineering Methods module using Java, Maven, MariaDB, GitHub, GitHub Actions, and Docker.

---

## Requirements Met

**8 requirements out of 8 have been implemented (100%).**

The table below provides evidence for each implemented requirement.

all the images attached in the repo at specified path

| ID  | Requirement                                                                 |  Met   | Screenshot                                     |
| --- | --------------------------------------------------------------------------- | :----: | ---------------------------------------------- |
| 1   | All the countries in the world organised by largest population to smallest  | ✅ Yes | `docs/screenshots/01-all-countries.png`        |
| 2   | All cities in the world organised by largest population to smallest         | ✅ Yes | `docs/screenshots/02-all-cities.png`           |
| 3   | All capital cities in the world organised by largest population to smallest | ✅ Yes | `docs/screenshots/03-capital-cities.png`       |
| 4   | Population report for the world                                             | ✅ Yes | `docs/screenshots/04-world-population.png`     |
| 5   | Population report for a continent                                           | ✅ Yes | `docs/screenshots/05-continent-population.png` |
| 6   | Population report for a region                                              | ✅ Yes | `docs/screenshots/06-region-population.png`    |
| 7   | Population report for a country                                             | ✅ Yes | `docs/screenshots/07-country-population.png`   |
| 8   | Language report                                                             | ✅ Yes | `docs/screenshots/08-language-report.png`      |

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
docker build -t world-report .
```

---

## Run

```bash
docker run -it world-report
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
