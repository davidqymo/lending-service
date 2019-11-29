# ActiveMQ Docker installation note

### 1. Get the Docker image from Docker HUB

```
docker search activemq

docker pull activemq
```

### 2. Start the container with the image


```
docker run -d --name myactivemq -p 61617:61616 -p 8162:8161 docker.io/webcenter/activemq:latest
```
note:  docker run command parameters

-name : container name

-p :  port mapping between host and container

-d :  container run in background

-i :  container run as interactive mode

above command mq port is : 61617, http manage port: 8162

##### for queue conntion:


```
tcp://localhost:81617
username = admin  (default)
password = admin  (default)
```


##### for management web page


```
http://localhost:8162

username: admin
passwork: admin
```


##### ++Other Docker command to manage++

###### List all images


```
docker images
```


###### List all available containers


```
docker ps -a
```


###### start up container


```
docker container start xxxx
```


where xxxx is container name

###### check container's live logs


```
docker logs xxxx
```


where container's name