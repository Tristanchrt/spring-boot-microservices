## Microservices projet

## Settings 

- change the file /etc/hosts with the serveral lines :
```
127.0.0.1 eola.local
127.0.0.1 front.eola.local
127.0.0.1 internal.eola.local
```

- Login docker gitlab : docker login registry.gitlab.com

#### Lancer le docker-compose avec docker-compose up

- Go to http://front.eola.local
- Account 1 : test@test.com / test
- Account 2 : test2@test.com / test

## Run project : 

```
cd infra-docker
cd traefik
docker-compose up -d
```

### Schema :

![Alt text](schema.png?raw=true "Title")