docker stop core-stateful
docker rm core-stateful
docker stop web-stateful
docker rm web-stateful
docker stop jsf-stateful
docker rm jsf-stateful
docker rmi -f jozimar/core-stateful
docker rmi -f jozimar/web-stateful
docker rmi -f jozimar/jsf-stateful
