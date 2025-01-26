# Progress Tracking Microservice

This is a Spring Boot-based microservice for tracking user progress, which for now includes body measurements. It uses MySQL as the database and exposes RESTful API endpoints for managing user progress.

---

## Docker

To build and run the application using Docker:

```bash
docker build -t progress_tracking .
docker run -p 8082:8080 --name progress_tracking_container --env-file .env progress_tracking
```

---

## Installation and Setup without Docker

### Prerequisites

- Java 21 or later installed on your system
- MySQL database instance running locally or in the cloud
- Maven installed

### Clone the Repository

```bash
git clone https://github.com/UNAL-Arch-2024ii-A5/progressTracking_ms.git
cd progressTracking_ms
```

### Install Dependencies

Ensure all required dependencies are installed:

```bash
./mvnw clean install
```

### Configure the Database

Update the database connection settings in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/progress_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

### Run the Application

Start the server:

```bash
./mvnw spring-boot:run
```

By default, the application will run on `http://localhost:8080`.

---

## API Endpoints

### Base URL

`http://localhost:8082/api`

### Snapshot Routes

| Method | Endpoint                    | Description                   |
| ------ | --------------------------- | ----------------------------- |
| POST   | `/snapshots`                | Create a new snapshot         |
| GET    | `/snapshots`                | List all snapshots            |
| GET    | `/snapshots/{id}`           | Get a specific snapshot by ID |
| GET    | `/snapshots/users/{userId}` | Get all snapshots for a user  |
| PUT    | `/snapshots/{id}`           | Update a snapshot by ID       |
| DELETE | `/snapshots/{id}`           | Delete a snapshot by ID       |

#### Example Requests

1. **Create a Snapshot**
   
   ```bash
   curl -X POST -H "Content-Type: application/json" -d '{
       "userId": 7,
       "weight": 70.5,
       "height": 175.0,
       "bodyFatPercentage": 15.0,
       "neck": 35.0,
       "waist": 80.0,
       "hip": 95.0,
       "chest": 100.0,
       "leftArm": 30.0,
       "rightArm": 30.0,
       "leftForearm": 25.0,
       "rightForearm": 25.0,
       "leftThigh": 60.0,
       "rightThigh": 60.0,
       "leftCalf": 40.0,
       "rightCalf": 40.0,
       "date": "2025-01-15"
   }' http://localhost:8082/api/snapshots
   ```

2. **List All Snapshots**
   
   ```bash
   curl -X GET http://localhost:8082/api/snapshots
   ```

3. **List All Snapshots by User**
   
   ```bash
   curl -X GET http://localhost:8082/api/snapshots/users/7
   ```

4. **Get a Snapshot by ID**
   
   ```bash
   curl -X GET http://localhost:8082/api/snapshots/1
   ```

5. **Update a Snapshot**
   
   ```bash
   curl -X PUT -H "Content-Type: application/json" -d '{
       "userId": 1,
       "weight": 70.5,
       "height": 175.0,
       "bodyFatPercentage": 25.0,
       "neck": 35.0,
       "waist": 80.0,
       "hip": 95.0,
       "chest": 100.0,
       "leftArm": 30.0,
       "rightArm": 30.0,
       "leftForearm": 25.0,
       "rightForearm": 25.0,
       "leftThigh": 60.0,
       "rightThigh": 60.0,
       "leftCalf": 40.0,
       "rightCalf": 40.0,
       "date": "2025-01-15"
   }' http://localhost:8082/api/snapshots/1
   ```

6. **Delete a Snapshot**
   
   ```bash
   curl -X DELETE http://localhost:8082/api/snapshots/1
   ```

---

## Notes

- Ensure MySQL is running and the database is accessible before starting the application.
- Customize the `application.properties` file for your production environment.
