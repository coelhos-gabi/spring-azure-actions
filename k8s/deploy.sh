#!/bin/bash

# Habilita o modo de saída em caso de erro
set -e

echo "Aplicando Secrets..."
kubectl apply -f secrets.yml

echo "Aplicando Persistent Volume"
kubectl apply -f persistentVolumeClaim.yml

echo "Aplicando Persistent Volume Claims"
kubectl apply -f persistentVolumeClaim.yml

echo "Aplicando MySQL service"
kubectl apply -f mysql-service.yml

echo "Aplicando service cursos-app"
kubectl apply -f cursos-app-service.yml

echo "Aplicando Deployment do MySQL..."
kubectl apply -f mysql-deployment.yml

echo "Aguardando MySQL iniciar..."
kubectl rollout status deployment/mysql-deployment

echo "Aplicando Deployment do cursos-app..."
kubectl apply -f cursos-app-deployment.yml

echo "Aguardando app iniciar..."
kubectl rollout status deployment/cursos-app-deployment

echo "Listando os recursos implantados..."
kubectl get pods
kubectl get services
