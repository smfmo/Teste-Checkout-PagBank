<h1 align="center">🚀 Integração com Checkout Padrão do PagBank</h1>

<p align="center">
 <img src="https://assets.pagseguro.com.br/access-fe/v0.1/_next/static/media/logo-pagbank.11b4ead9.svg" alt="PagBank" width="250"/><br>
  <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="Spring Boot" width="70" />
  <img src="https://www.vectorlogo.zone/logos/java/java-icon.svg" alt="Java" width="70" />
</p>

---

## 📌 Descrição

Este projeto tem como objetivo integrar o **Checkout Padrão do PagBank** utilizando o **Spring Boot** com **Java 21**. A aplicação é capaz de **criar**, **consultar**, **Ativar** e **inativar** checkouts via chamadas HTTP para a API oficial do PagBank.

### Como funciona o Checkout PagBank?
O Checkout PagBank simplifica a oferta de métodos de pagamento, eliminando a necessidade de integrações complexas. O cliente é direcionado para uma página exclusiva do PagBank para efetuar o checkout. Após a transação, ele será redirecionado para a página especificada.

---

## 💻 Tecnologias Utilizadas

- 🍃 **Spring Boot**
- ☕ **Java 21**
- 🔐 **Bearer Token Authentication**
- 🌐 **HTTP Requests (POST & GET)**
- 🔧 **RestTemplate**
- 🧾 **API PagBank (Checkout Padrão)**

---

## 📦 Funcionalidades

| Método HTTP | Endpoint                   | Descrição                                                           |
|-------------|----------------------------|---------------------------------------------------------------------|
| `POST`      | `/pagbank/checkout`        | Cria um novo checkout                                               |
| `GET`       | `/pagbank/{id}`            | Consulta um checkout por ID                                         |
| `POST`      | `/pagbank/{id}/inactivate` | inativar o Checkout caso tenha algum contratempo                    |
| `POST`      | `/pagbank/{id}/activate`   | Este Endpoint ativa o checkout novamente caso tenha sido desativado |

---

# Resposta para cada Endpoint

## POST: 
```
{
  "id": "checkout_id",
  "reference_id": "pedido123",
  "created_at": "2025-05-21T10:26:23-03:00",
  "status": "ACTIVE",
  "customer": {
    "name": "Josivan Pereira",
    "email": "Josivan@email.com",
    "tax_id": "12345678909"
  },
  "customer_modifiable": true,
  "items": [
    {
      "name": "Camiseta Preta",
      "quantity": 1,
      "description": "camiseta polo preta gg",
      "unit_amount": 5000
    }
  ],
  "additional_amount": 0,
  "discount_amount": 0,
  "payment_methods": [
    {
      "type": "PIX"
    },
    {
      "type": "CREDIT_CARD"
    },
    {
      "type": "BOLETO"
    }
  ],
  "payment_methods_configs": [
    {
      "type": "CREDIT_CARD",
      "config_options": [
        {
          "option": "INSTALLMENTS_LIMIT",
          "value": "10"
        }
      ]
    }
  ],
  "notification_urls": [
    "https://meusite.com.br/notificacoes"
  ],
  "payment_notification_urls": [
    "https://meusite.com.br/notificacoes"
  ],
  "links": [
    {
      "rel": "SELF",
      "href": "https://sandbox.api.pagseguro.com/checkouts/{checkout_id}",
      "method": "GET"
    },
    {
      "rel": "PAY",
      "href": "https://pagamento.sandbox.pagbank.com.br/pagamento?code=12345",
      "method": "GET"
    },
    {
      "rel": "INACTIVATE",
      "href": "https://sandbox.api.pagseguro.com/checkouts/{checkout_id}/inactivate",
      "method": "POST"
    }
  ]
}
```
## GET:
```
{
  "id": "checkout_id",
  "reference_id": "pedido123",
  "created_at": "2025-05-21T08:39:22-03:00",
  "status": "ACTIVE",
  "customer": {
    "name": "Josivan Pereira",
    "email": "Josivan@email.com",
    "tax_id": "12345678909"
  },
  "customer_modifiable": true,
  "items": [
    {
      "name": "Camiseta Preta",
      "quantity": 1,
      "description": "camiseta polo preta gg",
      "unit_amount": 5000
    }
  ],
  "additional_amount": 0,
  "discount_amount": 0,
  "payment_methods": [
    {
      "type": "PIX"
    },
    {
      "type": "CREDIT_CARD"
    },
    {
      "type": "BOLETO"
    }
  ],
  "payment_methods_configs": [
    {
      "type": "CREDIT_CARD",
      "config_options": [
        {
          "option": "INSTALLMENTS_LIMIT",
          "value": "10"
        }
      ]
    }
  ],
  "notification_urls": [
    "https://meusite.com.br/notificacoes"
  ],
  "payment_notification_urls": [
    "https://meusite.com.br/notificacoes"
  ],
  "links": [
    {
      "rel": "SELF",
      "href": "https://sandbox.api.pagseguro.com/checkouts/{checkout_id}",
      "method": "GET"
    },
    {
      "rel": "PAY",
      "href": "https://pagamento.sandbox.pagbank.com.br/pagamento?code=12345",
      "method": "GET"
    },
    {
      "rel": "INACTIVATE",
      "href": "https://sandbox.api.pagseguro.com/checkouts/{checkout_id}/inactivate",
      "method": "POST"
    }
  ]
}
```
## POST (INACTIVATE):

 ```
 {
  "id": "checkout_id",
  "status": "INACTIVE",
  "links": [
    {
      "rel": "SELF",
      "href": "https://sandbox.api.pagseguro.com/checkouts/checkout_id",
      "method": "GET"
    },
    {
      "rel": "ACTIVATE",
      "href": "https://sandbox.api.pagseguro.com/checkouts/checkout_id/activate",
      "method": "POST"
    }
  ]
}
 ```

## POST (ACTIVATE):
```
{
  "id": "checkout_id",
  "status": "ACTIVE",
  "links": [
    {
      "rel": "SELF",
      "href": "https://sandbox.api.pagseguro.com/checkouts/checkout_id",
      "method": "GET"
    },
    {
      "rel": "PAY",
      "href": "https://pagamento.sandbox.pagbank.com.br/pagamento?code=12345",
      "method": "GET"
    },
    {
      "rel": "INACTIVATE",
      "href": "https://sandbox.api.pagseguro.com/checkouts/{checkout_id}/inactivate",
      "method": "POST"
    }
  ]
}
```
---

## Desenvolvimento:
- Samuel Monteiro Ferreira