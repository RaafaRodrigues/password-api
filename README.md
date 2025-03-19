# Password API

Esta é uma API desenvolvida em Java utilizando o framework Spring Boot.

## Funcionalidade

A API expõe um único endpoint:

- **POST /password/validate**: Valida uma senha com base em regras de segurança.

As senhas são validadas contra as seguintes regras:

- A senha deve ter pelo menos **9 caracteres**.
- A senha deve conter pelo menos **um dígito**.
- A senha deve conter pelo menos **uma letra minúscula**.
- A senha deve conter pelo menos **uma letra maiúscula**.
- A senha deve conter pelo menos **um caractere especial** da lista `!@#$%^&*()-+`.

## Como usar

### Requisitos

- [JDK 11 ou superior](https://adoptium.net/).
- [Maven](https://maven.apache.org/) ou [Gradle](https://gradle.org/) (caso deseje compilar o projeto).
- [Docker](https://docs.docker.com/get-docker/) e [Docker Compose](https://docs.docker.com/compose/) (para execução via contêiner).
- [GIT](https://git-scm.com) (se for para clonar o projeto) ou baixar o zip.
- IDE de sua preferência ou linha de comando.

### Rodando o projeto

1. Clone o repositório:

```bash
git clone https://github.com/RaafaRodrigues/password-api.git
```

2. Navegue até o diretório do projeto:

```bash
cd password-api
```

3. Execute a aplicação com o Maven:

```bash
mvn spring-boot:run
```

Ou com o Gradle:

```bash
./gradlew bootRun
```

### Rodando com Docker

1. Construa a imagem Docker:

```bash
docker build -t password-api .
```

2. Execute o contêiner:

```bash
docker run -p 8080:8080 password-api
```

### Rodando com Docker Compose

Caso prefira utilizar o Docker Compose, execute:

```bash
docker-compose up -d
```

Isso iniciará a aplicação em segundo plano na porta 8080.

### Testando o endpoint

Uma vez que a aplicação esteja rodando, você pode testar a API utilizando ferramentas como [Postman](https://www.postman.com/) ou `curl`.

Exemplo de requisição com `curl`:

```bash
curl -X POST http://localhost:8080/password/validate -H "Content-Type: application/json" -d '{"password":"Senha123!"}'
```

O corpo da requisição deve ser um JSON contendo a senha a ser validada. O retorno será um valor booleano `true` ou `false`, indicando se a senha atende a todos os critérios de segurança.

### Documentação da API

A documentação da API é gerada automaticamente usando o Swagger e pode ser acessada em:

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## Estrutura do Código

### `PasswordApplication`

Classe principal que configura e inicializa o Spring Boot.

### `SwaggerConfig`
Configura a documentação OpenAPI com o Swagger.

### `PasswordController`

Controlador que expõe o endpoint `/password/validate` para validação de senhas.

### `PasswordService`

Camada de serviço.

### `PasswordValidator`

Responsavel por realizar a validação da senha.

### `PasswordStrategy`

Interface que define o contrato para todas as regras de validação de senha.

### Regras de validação:

- **`LengthRule`**: Valida o comprimento da senha.
- **`DigitRule`**: Verifica se a senha contém ao menos um dígito.
- **`LowercaseRule`**: Verifica se a senha contém ao menos uma letra minúscula.
- **`UppercaseRule`**: Verifica se a senha contém ao menos uma letra maiúscula.
- **`SpecialCharacterRule`**: Verifica se a senha contém pelo menos um caractere especial.
- **`NoRepeatedCharactersRule`**: Verifica se a senha contém repetição de caracter no conjunto.


## Bibliotecas utilizadas

- [Spring Boot](https://spring.io/projects/spring-boot) - Framework para aplicações Java.
- [Spring Web](https://spring.io/guides/gs/rest-service/) - Módulo para construção de APIs REST.
- [Spring Boot Starter Validation](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation) - Biblioteca para validação de dados.
- [OpenAPI/Swagger](https://springdoc.org/) - Ferramenta para documentação da API.
