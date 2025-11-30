Sapatos Luxos — Sistema de Gerenciamento de Loja

Projeto desenvolvido para avaliação da disciplina de Programação Orientada a Objetos (POO) e Banco de Dados.

📌 📚 Requisitos do Trabalho (atendidos)

✔ Código organizado em POO
✔ Implementado com todas as camadas vistas em sala:
model, dao, repository, service, view
✔ Projeto conectado a um banco de dados MySQL
✔ Projeto possui README completo
✔ Comunicação com o cliente através de menu em português (terminal)
✔ Código do sistema em inglês, interface com o usuário em português
✔ Consumo de API externa (ViaCEP) para consulta de endereço
✔ Projeto acompanha o arquivo SQL para importação do banco
✔ README explica como configurar o banco, rodar o projeto, instalar dependências
✔ Funciona no IntelliJ IDEA Community + MySQL Workbench

📘 1. O que é o projeto?

Sapatos Luxos é um sistema simples de gerenciamento de loja de sapatos.
O programa permite:

Cadastrar clientes

Cadastrar sapatos

Listar clientes e sapatos

Criar pedidos

Listar pedidos

Buscar endereço automaticamente usando API ViaCEP

Este projeto foi criado para demonstrar organização em camadas, regras da POO, banco de dados integrado e uso de API externa.

🧠 2. Tecnologias Utilizadas

Java 17 ou superior

IntelliJ IDEA Community

MySQL Workbench

MySQL Server

Driver JDBC: mysql-connector-j

API pública ViaCEP

🗂 3. Estrutura do Projeto
/src
 ├── model/               → Classes da aplicação (Customer, Shoe, Order...)
 ├── dao/                 → Acesso ao banco de dados (DAO)
 ├── repository/          → Regras de persistência
 ├── service/             → Regras de negócio
 ├── view/                → Menu principal (interface do cliente)
 ├── jdbc/                → Classe de conexão com o banco de dados
 └── lib/                 → mysql-connector-j-9.4.0.jar

🛠 4. Como instalar o projeto (passo a passo)
✔️ 4.1 Baixar o projeto

Baixe o repositório do GitHub ou receba o .zip

Extraia o projeto em:

C:\Sapatos_Luxos

✔️ 4.2 Instalar MySQL Server + MySQL Workbench

Baixe o MySQL Installer

Instale MySQL Server e MySQL Workbench

Crie um usuário root com sua senha (exemplo usado no projeto: "Gabriel10")

✔️ 4.3 Criar o banco de dados

No MySQL Workbench, execute:

CREATE DATABASE sapatos_luxos;
USE sapatos_luxos;


Agora importe o arquivo SQL que vem com o projeto:

MySQL Workbench

Server → Data Import

Escolha o arquivo sapatos_luxos.sql

Clique em Start Import

As tabelas serão criadas automaticamente:

customer

shoe

orders

order_item

✔️ 4.4 Configurar o JDBC no projeto

Dentro de:

src/lib/


deve existir o arquivo:

mysql-connector-j-9.4.0.jar

Agora adicione ao IntelliJ:

Vá em File → Project Structure

Clique em Modules

Aba Dependencies

Clique no +

Escolha JARs or Directories

Selecione o arquivo:

src/lib/mysql-connector-j-9.4.0.jar


Coloque Scope: Compile

Clique Apply → OK

✔️ 4.5 Configurar a conexão no código

Arquivo:

src/jdbc/DatabaseConnection.java


Exemplo de configuração:

private static final String URL = "jdbc:mysql://localhost:3306/sapatos_luxos";
private static final String USER = "root";
private static final String PASSWORD = "SUA_SENHA_AQUI";

Teste a conexão:

Rode:

jdbc/ConnectionTest.java


Se aparecer:

Conectado ao banco com sucesso!


Está tudo ok.

🌐 5. Consumo da API ViaCEP

O projeto usa a API ViaCEP para buscar endereço automático pelo CEP.

Exemplo:

URL url = new URL("https://viacep.com.br/ws/" + cep + "/json/");


Isso preenche automaticamente o endereço de cada cliente.

💻 6. Como rodar o projeto (IntelliJ)

Abra o IntelliJ

Clique em Open

Selecione a pasta:

C:\Sapatos_Luxos


No painel esquerdo:

src/view/MainMenu.java


Clique em Run ▶

🧑‍💼 7. Como usar o sistema

O menu principal aparece:

=== LOJA DE SAPATOS LUXOS ===
1 - Cadastrar Cliente
2 - Listar Clientes
3 - Cadastrar Sapato
4 - Listar Sapatos
5 - Criar Pedido
6 - Listar Pedidos
0 - Sair


A interface é em português, conforme pedido do professor.

📦 8. Arquivo SQL Incluso

O projeto acompanha:

sapatos_luxos.sql


Para importação direta no MySQL Workbench.

🎯 9. Padrão do Código

✔ Classes e métodos em inglês
✔ Interface do usuário em português
✔ Padrão MVC/Multicamadas
✔ Boa separação de responsabilidades
✔ Métodos limpos, organizados e com POO aplicada

📝 10. Autor

Projeto desenvolvido por:
Gabriel Augusto de Lacerda e Silva 




