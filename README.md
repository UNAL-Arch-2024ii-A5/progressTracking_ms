# README

### Ejecución

Para ejecutar el microservicio en docker, ejecute los siguientes comandos ubicado dentro de la carpeta raíz del proyecto:

1. `docker build -t progress_tracking .`
2. `docker run -p 8082:8080 --name progress_tracking_container progress_tracking`
