# Running MySQL 8 in Docker with Windows Desktop 10

## Create local folders

- c:\docker\mysql\conf --- /c/docker/mysql/conf
- c:\docker\mysql\data --- /c/docker/mysql/data
- c:\docker\mysql\log  --- /c/docker/mysql/log
- c:\docker\mysql8\mysql-files --- /c/docker/mysql8/mysql-files

## Pull mysql image
```sh
docker pull mysql
```
## Run mysql image to generate docker container without volume mount 
Only for the first time to check the actual path in mysql image
```sh
docker run --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 -d mysql
```

## Copy my.cnf to local folder
```sh
docker cp mysql:/etc/my.cnf c:\docker\mysql
```
## Stop and remove the pre-generated docker container for mysql
```sh
docker stop mysql
docker rm mysql
```

## Re-run docker image to generate the docker container with volume mount
```sh
 docker run -p 3306:3306 --name mysql \
 --restart=always \
 -v /c/Users/googo/docker/mysql/mysql-files:/var/lib/mysql-files \
 -v /c/Users/googo/docker/mysql/log:/var/log/mysql \
 -v /c/Users/googo/docker/mysql/data:/var/lib/mysql \
 -v /c/Users/googo/docker/mysql/my.cnf:/etc/my.cnf \
 -v /c/Users/googo/docker/mysql/conf:/etc/mysql/conf.d \
 -e MYSQL_ROOT_PASSWORD=123456 -d mysql
```

## Exec into mysql bash
```sh
docker exec -it mysql /bin/bash
```

## Run next time if mysql docker is down
```sh
docker run mysql
```
