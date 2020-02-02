Eicon - Teste

Api Cadastro de Clientes e Produtos

Tecnologias Ultilizadas:

Java 8

Spring Boot 2.1.6

Spring Rest

Spring Data

Maven

Banco de Dados Mysql

Lombok 1.8

Swagger ( url: http://localhost:8080/swagger-ui.html )

JUnit


END POINTS - CLIENTES E PEDIDOS

Cadastro de Clientes :

url: http://localhost:8080/clientes/save

json: 

{
	
	"nome":"Fred Mota",
	"cpf" : "01282929380",
	"telefone" : "012345678",
	"endereco" : "RUA SOUSA MOTA"
	
}


Listar Todos os Clientes: 

url: http://localhost:8080/clientes/list

json de retorno:

{
        "id": 1,
        "nome": "Fred Mota",
        "cpf": "01282929380",
        "telefone": "012345678",
        "endereco": "RUA SOUSA MOTA"
}

Atualizar Cliente :

url: http://localhost:8080/clientes/update

json :

{
  "id": 1,
  "nome": "Fred Mota",
  "cpf": "01282929380",
  "telefone": "012345678",
  "endereco": "RUA SOUSA MOTA"
 }
 
Deletar Cliente :

url : http://localhost:8080/clientes/delete/3

------------------- PEDIDOS ----------------------------

Cadastro de Pedidos :

url : http://localhost:8080/pedidos/save

json:

{
	
	"clienteId"   : 1,
	"observacoes" : "Muito Queijo",
	"valorTotal"  : 70.00,
	
    "itens" : [
        {
            "descricao":"cerveja",
            "valor":35.00,
            "quantidade":1
        },
        {
            "descricao":"mac donalds",
            "valor":35.00,
            "quantidade":1
        }
    ]
}

PESQUISA DE PEDIDOS :

URL : http://localhost:8080/pedidos/list

Filtros : Numero do Pedido , Id do Cliente , Data de Cadastro ( caso não seja passado esses parametros retorna todos os pedidos )

json: 

{
	"clienteId"    : 1,
	"numeroPedido" : 3,
	"dataCadastro" : "02/02/2020"	
}

json de retorno:

[
    {
        "id": 3,
        "observacoes": "Muito Queijo",
        "cliente": {
            "id": 1,
            "nome": "Fred Mota",
            "cpf": "01282929380",
            "telefone": "012345678",
            "endereco": "RUA SOUSA MOTA"
        },
        "createdDate": "02/02/2020 05:21",
        "valorTotal": 460.00,
        "itens": [
            {
                "id": 3,
                "descricao": "cerveja",
                "valor": 35.50,
                "quantidade": 1
            },
            {
                "id": 4,
                "descricao": "mac donalds",
                "valor": 195.50,
                "quantidade": 1
            }
        ],
        "clienteId": null
    }
]
    
