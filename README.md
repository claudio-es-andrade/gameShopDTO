# Java com AI 2024

Java RESTful API.

## Principais Tecnologias
 - **Java 17**: Utilizaremos a versão LTS mais recente do Java para tirar vantagem das últimas inovações que essa linguagem robusta e amplamente utilizada oferece;
 - **Spring Boot 3**: Trabalharemos com a mais nova versão do Spring Boot, que maximiza a produtividade do desenvolvedor por meio de sua poderosa premissa de autoconfiguração;
 - **Spring Data JPA**: Exploraremos como essa ferramenta pode simplificar nossa camada de acesso aos dados, facilitando a integração com bancos de dados SQL;
 - **OpenAPI (Swagger)**: Vamos criar uma documentação de API eficaz e fácil de entender usando a OpenAPI (Swagger), perfeitamente alinhada com a alta produtividade que o Spring Boot oferece;
 - **Railway**: facilita o deploy e monitoramento de nossas soluções na nuvem, além de oferecer diversos bancos de dados como serviço e pipelines de CI/CD.


## Diagrama de Classes (Domínio da API)

```mermaid
classDiagram
    class Category {
        -Long     IdCategory
        -String   nameCategory
    }
    
    class Client {
        -Long     idClient
        -String   nameClient
    }
    
    class Game {
        -Long     idGame
        -String   nameGame
        -Float    price
        Category  category
    }
    
    class Order {
        -Long     idOrder
        -Int      qty
    }
    
    class Invoice {
        -Long      idInvoice
        -String    invoiceClientName
        -Int       invoiceOrderQty
        -String    invoiceGameName
        -Float     invoiceTotalPrice
        -String    invoiceCategoryName
    }
    
    Game  "1" *-- "1" Category      
    Order "1" *-- "1" Client
    Order "1" *-- "1" Game
```

# Documentação da API (Swagger)
## https://gameshopdto-production.up.railway.app/swagger-ui.html

Esta API ficará disponível no Railway por um período de tempo limitado. 


    URL de Produção: https://gameshopdto-production.up.railway.app/invoice/get/All
