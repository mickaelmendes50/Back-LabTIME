# Back-end LabTIME
### Objetivo
Modelar a tabela fornecida em CSV pela equipe em uma base de dados Postgres e devolver um JSON com as informações. 

### Tecnologias
<img alt="Java" src="https://img.shields.io/badge/java-ED1D25.svg?style=for-the-badge&logo=java&logoColor=white"/> <img alt="Spring" src="https://img.shields.io/badge/Spring-6CB52D.svg?style=for-the-badge&logo=spring&logoColor=white"/>

### Ferramentas
<img alt="Git" src="https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white"/> <img alt="GitHub" src="https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white"/> <img alt="PostgreSQL" src="https://img.shields.io/badge/postgresql-31648C.svg?style=for-the-badge&logo=postgresql&logoColor=white"/> <img alt="Postman" src="https://img.shields.io/badge/postman-F76936.svg?style=for-the-badge&logo=postman&logoColor=white"/>

## Utilização
O endpoint está disponível no localhost pela URL: 

```http://localhost:8080/usuarios```

Há uma função de update dedicada à coleta dos informações do arquivo CSV que popula o banco de dados. Essa função deve ser executada pelo menos uma vez para garantir o funcionamento da API.

```http://localhost:8080/usuarios/update```

A API retorna a listagem de todos os usuários cadastrados no banco de dados, podendo ser filtrado pelo nomeCompleto, nomeSocial ou email através de uma query conforme o exemplo:

* ```http://localhost:8080/usuarios```
* ```http://localhost:8080/usuarios?filtro=Andrea%20Cristina```
