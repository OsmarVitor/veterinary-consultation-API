# Veterinary Conultation API! 


[![License](https://camo.githubusercontent.com/74c423b91b6157c4920363ddff99e1e1aeee0d83/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6c6963656e73652d4d49542d726564)](https://github.com/OsmarVitor/github-developers-api/blob/main/LICENSE.txt)    [![Author](http://img.shields.io/badge/made%20by-Osmar%20Perez-red)](https://github.com/OsmarVitor/github-developers-api/blob/main/LICENSE.txt)

#  Projeto
> O escopo do projeto consiste em desenvolver um serviço web para gerenciamento de consultas veterinárias via API's

### :computer: Tecnologias

Este projeto foi desenvolvido utilizando as seguintes tecnologia:

* [Java 11](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html) - Linguagem de Programação do Projeto
* [Spring Boot 2.2.10 RELEASE](https://spring.io/blog/2021/06/24/spring-boot-2-5-2-is-now-available) - Framework Web
* [Hibernate](https://hibernate.org/) -Ferramenta ORM
* [JPA](https://www.oracle.com/java/technologies/persistence-jsp.html) - API para frameworks de persistência de dados
* [Postgres](https://www.postgresql.org/) - Banco de dados
* [Lombok](https://projectlombok.org/) - Ferramenta para aumentar a produtividade
* [Junit 5](https://junit.org/junit5/docs/current/user-guide/) - Ferramenta para testes
* [H2](https://www.h2database.com/html/main.html) - Bando de dados relacional em memória
* [Swagger](https://swagger.io/) - Ferramenta para mapear e documentar as API's
* [Gson](https://github.com/google/gson) - Biblioteca para serializar e desserializar objetos Java para JSON.

## Requisitos para Compilação

## :heavy_check_mark: Step 1

Faça o Download do projeto:
````
git clone https://github.com/OsmarVitor/veterinary-consultation-API
````

## :heavy_check_mark: Step 2

Para o compilar e tesar o projeto é necessário instalar as seguintes tecnologias:

:coffee: Java 11 - Caso você não tenha o Java 11 instalado bastar fazer o download por este link (Linux e WIndows): [Download Java 11](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html)

:elephant: Postgres - Caso você não tenha o Postgres instalado basta fazer o download por este link (Linux e WIndows): [Download Postgres](https://www.postgresql.org/download/)

## :whale: Instalação do Postgres via Docker (Recomendado)

Se assim como eu você prefere usar o Docker para a instalação do banco de dados segue os comandos para instalação via Docker:
Não tem o Docker instalado? Faça o Download por este link: [Download Docker](https://www.docker.com/products/docker-desktop)

Após instalar e iniciar o Docker execute o seguinte comando para obter uma imagem do Postgres:
````
docker pull postgres
````
Com esse comando criamos um contêiner com a conexão com o banco de dados Postgres na porta padrão :5432 com a senha  **postgres**
````
docker run --name some-postgres -e POSTGRES_PASSWORD=postgres -d postgres
````
## :heavy_check_mark: Step 3
Com o Java 11 e o Postgres instalado precisamos criar o banco de dados com o nome `hapvida` que o projeto usa para o desenvolvimento.
Você pode criar manualmente com alguma ferramenta (Recomendo o [DBeaver](https://dbeaver.io/)). 


Feito isso, é só importar o projeto para a sua IDE favorita e testar! 


# Curiosidades

### :heavy_exclamation_mark: E o Banco para Testes?
Não é necessário criar um Banco de dados para testes, pois o H2 cria um banco em memória para os teste, e quando os testes terminam o banco em memória é apagado!

### :recycle: Como contribuir?
* Fork o repositório
* Crie uma branch: `git checkout -b my-feature`
* Commit suas mudanças: `git commit -m 'feat: My new feature`
* Push a sua branch: `git push origin my-feature`

### :balance_scale: Licença
Esse projeto está sob a licença MIT. 

### :star: Bônus
Gostou do padrão de **commits** e quer saber mais quando usar o `feat`, `refactor`, `fix`, `docs` e etc?
Segue o link de referência: [Padrão de Commits](https://github.com/stone-payments/stoneco-best-practices/blob/master/gitStyleGuide/README.md) 

Gostou da maneira que foi estruturada o README.md?
Segue o link de referência: [README.md Guideline](https://github.com/stone-payments/stoneco-best-practices/blob/master/readme/README.md)
Os emojis foram tirados daqui: [Emojis](https://gist.github.com/rxaviers/7360908)

