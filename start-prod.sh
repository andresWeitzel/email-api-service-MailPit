#!/bin/bash

echo "🔨 Building app..."
./mvnw clean package -DskipTests

echo "🐳 Starting Production Environment..."

docker-compose -f docker-compose.yml -f docker-compose.prod.yml up --build
