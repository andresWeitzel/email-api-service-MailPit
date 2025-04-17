#!/bin/bash

echo "🐳 Starting Development Environment..."

docker-compose -f docker-compose.yml -f docker-compose.dev.yml up --build
