# ATDD Accelerator Template - Multi-Component Architecture

This repository contains an example application demonstrating a multi-component architecture with separate frontend and backend services.

## Architecture

The application has been decomposed from a monolith into the following components:

### Backend (`/backend`)
- **Technology**: Java 21 with Spring Boot 3.5.6
- **Port**: 8081
- **Description**: REST API service providing endpoints for echo and todo operations
- **Key Features**:
  - RESTful API endpoints
  - CORS enabled for frontend communication
  - Proxies requests to external JSONPlaceholder API

### Frontend (`/frontend`)
- **Technology**: React 18 with React Router
- **Port**: 8080
- **Description**: Single-page application providing the user interface
- **Key Features**:
  - Home page with welcome message
  - Todo Fetcher page for querying todos
  - Responsive design
  - Nginx reverse proxy for API calls

### Monolith (`/monolith`)
- **Status**: Legacy - kept for reference
- **Description**: Original monolithic application with embedded web pages

### System Tests (`/system-test`)
- **Technology**: Jest + Playwright
- **Description**: End-to-end and smoke tests for the application
- **Test Types**:
  - API E2E tests
  - UI E2E tests
  - API smoke tests
  - UI smoke tests

## Running the Application

### Using Docker Compose (Recommended)

The easiest way to run the entire application is using docker-compose:

```bash
cd system-test
docker-compose up
```

This will start both the frontend and backend services. Access the application at:
- Frontend: http://localhost:8080
- Backend API: http://localhost:8081/api

### Running Locally for Development

#### Backend

```bash
cd backend
./gradlew bootRun
```

The backend will be available at http://localhost:8081

#### Frontend

```bash
cd frontend
npm install
npm start
```

The frontend will be available at http://localhost:3000

## Running Tests

### System Tests

```bash
cd system-test
npm install
npm test
```

### Backend Unit Tests

```bash
cd backend
./gradlew test
```

### Frontend Unit Tests

```bash
cd frontend
npm test
```

## API Endpoints

### Backend API

- `GET /api/echo` - Health check endpoint, returns "Echo"
- `GET /api/todos/{id}` - Fetches a todo item by ID from external API

## Project Structure

```
.
├── backend/              # Java Spring Boot backend service
│   ├── src/
│   ├── build.gradle
│   ├── Dockerfile
│   └── README.md
├── frontend/             # React frontend application
│   ├── src/
│   ├── public/
│   ├── package.json
│   ├── Dockerfile
│   └── README.md
├── monolith/             # Legacy monolithic application (reference)
│   └── ...
└── system-test/          # End-to-end system tests
    ├── test/
    ├── docker-compose.yml
    └── README.md
```

## Key Changes from Monolith

1. **Separation of Concerns**: Frontend and backend are now separate services
2. **Technology Specialization**: 
   - Backend focuses on API logic with Spring Boot
   - Frontend uses modern React framework
3. **Independent Deployment**: Each service can be deployed and scaled independently
4. **API Communication**: Frontend communicates with backend via REST API
5. **CORS Configuration**: Backend enables CORS for frontend access
6. **Nginx Reverse Proxy**: Frontend uses Nginx to proxy API requests

## Development Guidelines

### Adding New Backend Endpoints

1. Create a new controller in `backend/src/main/java/.../controllers/`
2. Add `@CrossOrigin` annotation for CORS support
3. Write unit tests
4. Update API documentation

### Adding New Frontend Pages

1. Create a new component in `frontend/src/pages/`
2. Add route in `frontend/src/App.js`
3. Create corresponding CSS file
4. Write component tests

## Docker Images

Images are published to GitHub Container Registry:
- `ghcr.io/optivem/atdd-accelerator-template-multi-comp/backend:latest`
- `ghcr.io/optivem/atdd-accelerator-template-multi-comp/frontend:latest`

## License

See LICENSE file for details.