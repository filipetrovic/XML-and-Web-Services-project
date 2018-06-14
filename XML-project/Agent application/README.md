# Web Service

#### Requirements
``docker``

#### How to setup development environment?

```bash
1. git clone //TODO
2. Make sure you are in Agent application folder!
3. sudo docker-compose up
```

#### How to test it?
```bash
WS-AGENT-1 is running on port: 8080
WS-AGENT-2 is running on port: 8081
```

#### How to access mysql container
```bash
example:
sudo docker -exec agent-1-mysql /bin/bash
```

#### About 
This is Spring Boot WebService with MySql and Docker.
Application is on start creating by default 2 agent instance
Application will use XML instead of JSON.
