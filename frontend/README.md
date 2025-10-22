# Frontend Service

This is the frontend UI service for the ATDD Accelerator Template, built with React.

## Features

- React-based single-page application
- React Router for navigation
- Home page with welcome message
- Todo Fetcher page to query and display todos
- Responsive design

## Pages

- `/` - Home page with welcome message
- `/todos` - Todo Fetcher page

## Running Locally

First, install dependencies:

```bash
npm install
```

Then start the development server:

```bash
npm start
```

The app will open at http://localhost:8080.

**Note:** For local development, make sure the backend service is running on port 8081, or update the proxy setting in `package.json`.

## Building for Production

```bash
npm run build
```

This creates an optimized production build in the `build` folder.

## Docker

Build the Docker image:

```bash
docker build -t frontend .
```

Run the container:

```bash
docker run -p 8080:8080 frontend
```

## Technology Stack

- React 18
- React Router DOM 6
- React Scripts 5