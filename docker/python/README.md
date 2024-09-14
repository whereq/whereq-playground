# WhereQ Docker Image for Python

# Commands

## Build
docker build -t whereq/python:1.0 -f ./dockerfile .

## Run
**Run on windows**

docker run -v %cd%/app:/app -it --entrypoint /bin/bash --name whereq-python whereq/python:1.0 

**Run on linux**

docker run -v $(pwd)/app:/app -it --entrypoint /bin/bash --name whereq-python whereq/python:1.0 

## Enter
docker exec -it whereq-python bash

# Check version
```
root@7c5f821681be:/# python --version
Python 3.12.1
(base) root@b4e800fc1be1:/# conda --version
conda 23.7.4
```
```
root@7c5f821681be:/# python /app/hw.py
Hello WhereQ
```
