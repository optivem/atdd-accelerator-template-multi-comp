# Backend Service

This is the backend API service for the ATDD Accelerator Template, built with Java Spring Boot.

## Features

- RESTful API endpoints
- Echo endpoint for health checks
- Todo endpoint that proxies to external API
- CORS enabled for frontend communication

## Endpoints

- `GET /api/echo` - Returns "Echo" for health check
- `GET /api/todos/{id}` - Fetches a todo item by ID



## Building

```bash
./gradlew build
```

## Running Locally

```bash
./gradlew bootRun
```

The service will start on port 8081.

## Docker

Build the Docker image:

```bash
docker build -t backend .
```

Run the container:

```bash
docker run -p 8081:8081 backend
```

## Configuration

Configuration can be modified in `src/main/resources/application.yml`:

- `server.port` - Server port (default: 8081)
- `todos.api.host` - External todos API host (default: https://jsonplaceholder.typicode.com)