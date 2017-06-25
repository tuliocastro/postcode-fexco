<img src="https://s3videos.travelmole.tv/mailtmtvupload/Quarter4_2013/Roger_mechri_v1.jpg" height="100" alt="FEXCO">

# FEXCO - Postcoder Search

This project is used to search at Postcoder API for Ireland and UK addresses.

### Architecture

The proprosal solution is divided in modules and micro services, with the same API options to garantee the maintenance of existing projects.

 - [API Module](api/README.md) - Some explaining
 - [Front Module](FRONT_MODULE) - Some explaining
 - [Cache Module](CACHE_MODULE) - Some explaining


### How to Start the Environment
All modules is ready to run, with a few commands your environment is ready to go.

#### Requirements
- [Java 8](JAVA_8)
- [Docker](DOCKER)

> Docker host has to be set and daemon exposed. [Read more ...](DOCKER_DAEMON_READ_MORE)


#### Building API Image

First we need to build and create the API Docker Image

    (cd api/ ; ./mvnw clean package docker:build) //Unix
    
    "api/mvnw clean package docker:build" //Windows
    
    
#### Running project (all modules)
Then, the other two modules is already ready to run, the docker compose will get the modules and run together. Just execute the following command:

    docker-compose up


### Access the running project

After these commands, the front project can be viewed at:

> [http://localhost:8081](http://localhost:8081)
    

[FRONT_MODULE]: front/README.md
[CACHE_MODULE]: cache/README.md
[JAVA_8]: http://www.oracle.com/technetwork/java/javase/downloads/index.html
[DOCKER]: https://docs.docker.com/engine/installation/
[DOCKER_DAEMON_READ_MORE]: https://docs.docker.com/engine/reference/commandline/dockerd/#bind-docker-to-another-hostport-or-a-unix-socket
