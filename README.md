# Java_Challenge

Este repositório se destina ao desafio técnico na linguagem java.  O desafio consistem em um endpoint responsável por agrupar e ordenar uma determinada listagem de produtos informada.

O endpoint foi escrito em Java 8 utilizando o maven.

#startup

Executar os seguintes comandos.

$ mvn clean
$ mvn install
$ java -jar target/ML_Challenge-1.0.0-SNAPSHOT.jar 

#Payload de Entrada

Verbo utilizado: POST
URI: localhost:5000/products/groupAndSort?filter=&order_by=&group_by=
Exemplo parâmetros para configuração: 
    filter=id:123
    order_by=price:asc
    group_by=title

Para retornar default basta não informar nenhum valor.

No corpo da requisição irá receber uma lista de objetos no formato JSON.
Exemplo Body:
[					 
    {									
        "id":	"123",									
        "ean":	"7898100848355",									
        "title":	"Cruzador	espacial	Nikana	- 3000m	- sem	garantia",									
        "brand":	"nikana",									
        "price":	820900.90,									
        "stock":	1					
    },					
    {									
        "id":	"u7042",									
        "ean":	"7898054800492",									
        "title":	"Espada	de	fótons	Nikana	Azul",									
        "brand":	"nikana",									
        "price":	2199.90,									
        "stock":	82				
    },					
    {									
        "id":	"bb2r3s0",									
        "ean":	"2059251400402",									
        "title":	"Corredor	POD	3000hp	Nikana",					
        "brand":	"nikana",									
        "price":	17832.90,									
        "stock":	8					
    }
]

#Payload de Resposta

Em caso de sucesso na requisição, irá retornar status code 200 e o conteúdo no seguinte formato (exemplo):

{
    "data": [
        {
            "description": "Cruzador\tespacial\tNikana\t- 3000m\t- sem\tgarantia",
            "items": [
                {
                    "id": "123",
                    "ean": "7898100848355",
                    "title": "Cruzador\tespacial\tNikana\t- 3000m\t- sem\tgarantia",
                    "brand": "nikana",
                    "price": "820900.90",
                    "stock": "1"
                }
            ]
        }
    ]
}