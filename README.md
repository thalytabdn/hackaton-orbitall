![Projeto Customers](http://revistapress.com.br/wp-content/uploads/2018/12/Sem-t%C3%ADtulo19.png)

By [Stefanini](https://stefanini.com/).

# Desafio Final - Hackaton Orbitall Corp 2021

## Estória da Hackaton Orbitall Corp 2021
O cliente X solicitou a Orbitall Corp que necessita ter cartões virtuais de crédito para oferecer ao seus clientes o uso na APP Store. Dado a isto, precisamos que seja criado uma entidade de cartão (card) com os dados pessoais, conforme a diagrama de classe Card abaixo:

```sh
+----------------+
| Card           | -> nome da classe
+----------------+
| id             |
| cardNumber     |
| embossName     |
| customerName   |
| documentNumber | -> atributos da classe
| motherName     |
| address        |
| city           |
+----------------+
| getters        |
| setters        | -> getters / setters da classe
+----------------+
```

Conforme a estória citada acima, temos um recurso chamado cartão, então, devemos desenvolver uma REST API deste recurso:

Recurso: Card

```sh
GET     /cards
POST    /cards
PUT     /cards/{id}
DELETE  /cards/{id}
GET     /cards/{id}
GET     /cards/paginationAndSorting ***
```

É necessário desenvolver o REST Full tanto em Node.js como no Java. Importante que no último REST API acima (/cards/paginationAndSorting), é necessário implementar o conceito de paginação e ordernação.

Boa sorte!

Orbitall Corp Teams
23/Janeiro/2021

## *** DICAS ****

### ** GIT **
```sh
$ git clone <branch>
$ git add .
$ git commit -m 'Seu comentário'
$ git push origin <branch>
```

PS: Cuidado com o artefato oculto chamado .git, você tem que basear na sua repositória e não o que foi clonado!!!

### ** Paginação & Ordenação **
#### NeBD -> https://github.com/louischatriot/nedb
#### Spring Boot -> https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/PagingAndSortingRepository.html

