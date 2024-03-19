# BomBView
API do projeto BomBView - Site de Review de Filmes, Séries e Jogos

## Tarefas

- [ ] CRUD de Filmes
- [ ] CRUD de Series
- [ ] CRUD de Jogos
- [ ] CRUD de Usuários
- [ ] CRUD de Reviews
- [ ] Dashboard
- [ ] Barra de Pesquisa

## Documentação API

## CRUD DE FILMES
### Endpoint
- [Listar Todos os Filmes](#listar-todos-os-filmes)
- [Cadastrar Filme](#cadastrar-filme)
- [Detalhes do Filme](#detalhes-do-filme)
- [Atualizar Filme](#atualizar-filme)
- [Apagar Filme](#apagar-filme)

---
### Listar Todos os Filmes

`GET` /filmes

Retorna um array com todas os filmes já cadastrados

#### Exemplo de Resposta
```
[
    {
        "id": 1,
        "nome": "Em Ritmo de Fuga",
        "genero": "Ação",
        "duracao": "1h 55m",
        "classificacao": 14
    }
]
```

#### Código de Status

|código|descrição|
|------|---------|
|200|Os dados do filme foram retornados com sucesso|
|401|Acesso negado. Você deve se autenticar|
---

### Cadastrar Filme

`POST` /filmes

Cria um novo filme com os dados enviados no corpo da requisição.

#### Corpo da Requisição

|campo|tipo|obrigatório|descrição|
|-----|----|:-----------:|---------|
|nome|string|✅|O nome exato do filme|
|genêro|string|✅|O gênero do filme|
|duração|string|✅|O tempo de duração do filme|
|classificação|int|✅|A classificação indicativa do filme|

```js
{
    "nome": "Em Ritmo de Fuga",
    "genero": "Ação",
    "duracao": "1h 55m",
    "classificacao": 14
}
```

#### Corpo da Resposta 
|código|descrição|
|------|---------|
|201|Filme cadastrado com sucesso|
|400|Dados enviados são inválidos. Verifique o corpo da requisição|
|401|Acesso negado. Você deve se autenticar|

---

### Detalhes do Filme

`GET` /filmes/`{id}`

Retorna os detalhes do filme com o `id` informado como parâmetro de path. 

#### Exemplo de Resposta

```js
[
    {
        "id": 1,
        "nome": "Em Ritmo de Fuga",
        "genero": "Ação",
        "duracao": "1h 55m",
        "classificacao": 14
    }
]
```

#### Códigos de Status

|código|descrição|
|------|---------|
|200|Os dados dos filmes foram retornados com sucesso|
|401|Acesso negado. Você deve se autenticar|
|404|Não existe filme com o `id` informado|

---

### Atualizar Filme

`PUT` /filme/`{id}`

Alteração dos dados de um filme especifico com o `id`, utilizando as informações enviadas no corpo da requisição.

#### Corpo da Requisição

|campo|tipo|obrigatório|descrição|
|-----|----|:-----------:|---------|
|nome|string|✅|O nome exato do filme|
|genêro|string|✅|O gênero do filme|
|duração|string|✅|O tempo de duração do filme|
|classificação|int|✅|A classificação indicativa do filme|

```js
{
    "nome": "Em Ritmo de Fuga",
    "genero": "Ação",
    "duracao": "1h 55m",
    "classificacao": 14
}
```

#### Exemplo de Resposta

```js
[
    {
        "id": 1,
        "nome": "Em Ritmo de Fuga",
        "genero": "Ação",
        "duracao": "1h 55m",
        "classificacao": 14
    }
]
```

#### Códigos de Status

|código|descrição|
|------|---------|
|200|Os dados dos filmes foram retornados com sucesso|
|400|Dados enviados são inválidos. Verifique o corpo da requisição|
|401|Acesso negado. Você deve se autenticar|
|404|Não existe filme com o `id` informado|

---
### Apagar Filme

`DELETE` /filme/`{id}`

Apaga o filme com o `id` especificado no parâmetro de path.

#### Códigos de Status

|código|descrição|
|------|---------|
|204|Filme apagado com sucesso|
|401|Acesso negado. Você deve se autenticar|
|404|Não existe filme com o `id` informado|

---
