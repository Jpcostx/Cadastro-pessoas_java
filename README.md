# Cadastro de Pessoas (Java MVC)

Sistema para cadastro, listagem, busca e remoção de pessoas desenvolvido em Java, utilizando o padrão arquitetural **MVC**, manipulação em memória com `ArrayList` e persistência em arquivo `.csv`.

## 📌 Funcionalidades

- **Cadastro de Pessoas:** Registra `id`, `nome`, `idade` e `altura`.
- **Persistência de Dados:** Salva e carrega automaticamente as informações no arquivo `pessoas.csv`.
- **Validações de Entrada:**
  - O campo **nome** recusa entradas com números.
  - O campo **altura** exige obrigatoriamente o uso do ponto (`.`) como separador decimal.
  - Tratamento de exceções para entradas numéricas inválidas no terminal.
- **Arquitetura MVC:** Separação clara de responsabilidades entre Modelo, Visão e Controle.

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java (JDK 11+)
- **Estrutura de Dados:** `ArrayList`
- **Persistência:** Manipulação de arquivos (`BufferedReader`, `BufferedWriter`, `FileWriter`)
- **Arquitetura:** Model-View-Controller (MVC) + Data Access Object (DAO)

## 📁 Estrutura do Projeto

```text
src/
├── model/
│   ├── Pessoa.java       # Entidade com os atributos (id, nome, idade, altura)
│   └── PessoaDAO.java    # Gerenciamento da lista e leitura/escrita no CSV
├── view/
│   └── PessoaView.java   # Interface de terminal e validação de entradas
├── controller/
│   └── PessoaController.java # Intermediador do fluxo MVC
└── Main.java             # Classe principal para inicialização da aplicação
