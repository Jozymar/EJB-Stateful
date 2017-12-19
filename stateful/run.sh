docker build -t jozimar/core-stateful ./core-stateful
docker run -p 8080:8080 -p 3700:3700 -d --name core-stateful jozimar/core-stateful
docker build -t jozimar/web-stateful ./web-stateful
docker run -p 8081:8080 -d --name web-stateful --link core-stateful:host-core jozimar/web-stateful
docker build -t jozimar/jsf-stateful ./jsf-stateful
docker run -p 8082:8080 -d --name jsf-stateful --link core-stateful:host-core jozimar/jsf-stateful





