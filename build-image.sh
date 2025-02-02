docker build -t cursos-app:latest .

docker tag cursos-app:latest coelhosgabi/cursos-app:latest

docker push coelhosgabi/cursos-app:latest
