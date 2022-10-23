# Signatre

Aplicação responsável por expor endpoints de assinaturas de quadras

# Requisitos

- Java 11
- postgres

# Comandos

docker container ls

docker run --name postgres -e POSTGRES_PASSWORD=123456 -d -p 5432:5432 postgres:14.0

docker start postgres

docker run -d  --name rabbitmq -p 15672:15672 -p 5672:5672 rabbitmq:3-management

docker start rabbitmq

# Sobre

Para mais informações sobre o projeto, favor entrar em contato com o time André, Bruna e Odair .
