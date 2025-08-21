# 🚀 auth-api

Uma **API de autenticação** desenvolvida com **Spring Boot** para aprender e aplicar conceitos de **Spring Security**, utilizando **services**, **controllers**, **repositories** e configurações manuais.  

A API utiliza **JWT (Bearer Token)** para autenticação e autorização, e expõe endpoints REST para cadastro e listagem de entidades **Product**.  

---

## ⚙️ Tecnologias

- Java + Spring Boot  
- Spring Security (configuração manual)  
- JWT (Bearer Token) para autenticação  
- Controllers, Services e Repositories  
- Arquitetura REST  

---

## 📌 Funcionalidades

- **Autenticação** via JWT: geração e validação de tokens Bearer.  
- **Autorização**: acesso controlado aos endpoints de `Product`.  
- **CRUD parcial de Product**:
  - `POST /product` – criar um novo produto  
  - `GET /product` – listar todos os produtos  

---
## 🚀 Passo a passo para testar a API

### 1️⃣ Registrar um usuário

**Endpoint:** `POST /auth/register`  
**Exemplo de requisição:**

```json
{
  "login": "joao",
  "password": "123456",
  "role": "ADMIN"
}
```

- role pode ser "ADMIN" ou "USER".

- Retorna 200 OK se o registro for bem-sucedido.

- Retorna 400 Bad Request se o usuário já existir.


### 2️⃣ Fazer login e obter o token JWT

**Endpoint:** `POST /auth/login`  
**Exemplo de requisição:**

```json
{
  "login": "joao",
  "password": "123456",
}
```

**Exemplo de resposta:**

```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2FvIiwiaWF0IjoxNjk4NDQ0MjM4LCJleHAiOjE2OTg0NDc4Mzh9._ExemploAssinaturaJWT_"
}
```

- ⚠️ Guarde o token, ele será usado nos próximos endpoints.

### 3️⃣ Criar um novo produto

**Endpoint:** `POST /product`
**Cabeçalho necessário:**

```pgsql
Authorization: Bearer <TOKEN_JWT>
Content-Type: application/json
```

**Exemplo de requisição:**

```json
{
  "name": "Mouse Gamer",
  "price": 120
}
```

- Retorna 200 OK se o produto for criado com sucesso.

### 4️⃣ Listar todos os produtos

**Endpoint:** `GET /product`
**Cabeçalho necessário:**

```makefile
Authorization: Bearer <TOKEN_JWT>
```

**Exemplo de Resposta:**
```json
[
  {
    "id": "9f0a2bce-7e6a-4b8a-9a0e-123456789abc",
    "name": "Notebook Dell",
    "price": 5000
  },
  {
    "id": "af36e2c1-4a7b-49d9-bb55-987654321def",
    "name": "Mouse Gamer",
    "price": 120
  }
]
```

## 🔑 Observações

- Todos os endpoints de Product exigem autenticação via token JWT.

- O token expira de acordo com a configuração do TokenService.

- Para novos usuários, é necessário repetir o passo 1 antes de logar.
