# Run with docker compose

## Create local volume
```bash
docker volume create mongodb_data
```

## docker-compose up

```bash
docker-compose up
```

```yaml
version: '3.8'

services:
  mongodb:
    container_name: chat-mongodb
    image: bitnami/mongodb:7.0.7
#    restart: always
    ports:
      - "27017:27017"
    volumes:
      - 'mongodb_data:/data/db' 
#    command: mongod --noauth

volumes:
  mongodb_data:
    driver: local
```

**NOTE**: The path has to be '/data/db' in volumes

# Run with docker directly
```bash
docker run -p 27017:27017 --name mongo bitnami/mongodb:7.0.7
```bash


# Connect to MongoDB
- MongoDB Shell

```bash
mongosh

mongosh --port 27017

mongosh "mongodb://localhost:27017"

mongosh --host localhost --port 27017
```

- MongoDB Compass(GUI)
**Basic connection string**
```
mongodb://localhost:27017
```


# Commands to start

```
show dbs;

show collections;

db.<collection_name>.find()

db.<collection_name>.find({"json_path":"value"})
db.<collection_name>.find({"models.name":"gpt-3.5"})
```


# References:
[MongoDB Cheat Sheet](https://www.mongodb.com/developer/products/mongodb/cheat-sheet/)
[Tools](https://www.mongodb.com/try/download/shell)