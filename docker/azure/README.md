# WhereQ Docker Image for Microsoft Azure Functions

# Commands

## Build
docker build -t whereq/azure-func:1.0 -f ./dockerfile .

## Run
**Run on windows**

docker run -v %cd%/app:/app -it --entrypoint /bin/bash --name whereq-azure-func whereq/azure-func:1.0 

**Run on linux**

docker run -v $(pwd)/app:/app -it --entrypoint /bin/bash --name whereq-azure-func whereq/azure-func:1.0 

## Enter
docker exec -it whereq-azure-func bash

# Check version
```
root@7c5f821681be:/# python --version
Python 3.12.1
root@7c5f821681be:/# node --version
v20.5.1
root@7c5f821681be:/# func --version
4.0.5455
```
```
root@7c5f821681be:/# python /app/hw.py
Hello WhereQ
```
