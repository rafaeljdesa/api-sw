# Star Wars API

## Introdução

API REST para manter dados de planetas.

Para cada planeta, os seguintes dados devem ser obtidos do banco de dados da aplicação, sendo inserido manualmente: 

- Nome

- Clima

- Terreno

- Para cada planeta também devemos ter a quantidade de aparições em filmes, que podem ser obtidas pela API pública do Star Wars: [SWAPI](https://swapi.co/) 

## Tecnologias/ferramentas utilizadas

[Spring](https://spring.io/) -  Framework open source para a plataforma Java

[JUnit](https://junit.org/junit5/) - Framework open-source para testes da API

[Maven](https://maven.apache.org/) - Ferramenta de automação de compilação

[MongoDB](https://www.mongodb.com/) - Banco de dados NoSQL, orientado a documentos 

[Postman](https://www.getpostman.com/) - Aplicação que permite enviar e receber dados via requisições HTTP

## Criação do banco de dados

Após instalar e inicializar o servidor, iniciar o cliente

```bash
mongo
```

Criar banco de dados

```bash
use swdb
```

## Inicializa aplicação

```bash
$ ./mvnw clean spring-boot:run
```


## Utilização

Listar planetas

![Image description](https://github.com/rafaeljdesa/sw-api/blob/master/src/main/resources/img/listar.JPG)

Buscar por ID

![Image description](https://github.com/rafaeljdesa/sw-api/blob/master/src/main/resources/img/buscarId.JPG)

Buscar por Nome

![Image description](https://github.com/rafaeljdesa/sw-api/blob/master/src/main/resources/img/buscarNome.JPG)

Adicionar planeta

![Image description](https://github.com/rafaeljdesa/sw-api/blob/master/src/main/resources/img/adicionar.JPG)

Alterar planeta

![Image description](https://github.com/rafaeljdesa/sw-api/blob/master/src/main/resources/img/alterar.JPG)

Remover planeta

![Image description](https://github.com/rafaeljdesa/sw-api/blob/master/src/main/resources/img/remover.JPG)
