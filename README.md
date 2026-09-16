Markdown
# Teste Prático Iniflex - Gestão de Funcionários

Projeto feito em Java para o teste prático da Iniflex. O objetivo é gerenciar uma lista de funcionários e realizar algumas operações solicitadas, como cálculos de aumento, ordenação, agrupamentos por função e formatação de datas e valores.

## 🛠️ Tecnologias
* Java 17
* IDE (IntelliJ IDEA)

## 📁 Como o projeto foi organizado
Dividi o código em pacotes para organizar melhor as responsabilidades:

* `model`: Classes `Pessoa` e `Funcionario` (com herança).
* `service`: Classe `FuncionarioService` onde ficam os métodos e regras do teste.
* `util`: Classe `Formatador` com as regras de formatação de data (`dd/MM/yyyy`) e valor monetário (`R$`).
* `Main.java`: Classe principal para rodar o projeto e testar todas as saídas no console.

## ⚙️ Como rodar o projeto

### Pela IDE (IntelliJ / Eclipse / VS Code)
1. Baixe ou clone o repositório.
2. Abra a pasta do projeto na sua IDE.
3. Abra o arquivo `src/Main.java`.
4. Clique no botão de **Run** (ou use o atalho `Shift + F10` no IntelliJ).

### Pelo Terminal
1. Entre na pasta `src` do projeto:
   ```bash
   cd caminho/para/o/projeto/src