# E-commerce Order Processing - Refactoring

Projeto focado na refatoração de uma base de código procedural e acoplada para uma arquitetura Orientada a Objetos limpa, modular e testável. O sistema é responsável por processar itens de pedidos, calcular subtotais e descontos, imprimir faturas e acionar serviços de notificação.

## 🛠️ Tecnologias e Práticas Utilizadas

* **Linguagem:** Java 25
* **Gerenciamento de Dependências:** Maven
* **Testes Unitários:** JUnit 5
* **Conteinerização:** Docker (Multi-stage build)
* **Engenharia de Software:** 
    * Princípio da Responsabilidade Única (SRP)
    * Encapsulamento de coleções e registros (Uso de `Records`)
    * Substituição de tipos primitivos por objetos de domínio
    * Programação defensiva e imutabilidade

## 📂 Estrutura do Projeto

O sistema foi refatorado para seguir os princípios de modularização e separação de responsabilidades exigidos:
* **com.leonardomuniz (Raiz):** Contém o ponto de entrada do sistema (App.java)
* **model:** Agrupa as classes de domínio e objetos de valor encapsulados (Order, Client, Item)
* **service:** Gerencia a lógica de negócio auxiliar e a comunicação com serviços externos (DiscountPolicy, EmailService)
* **view:** Camada responsável exclusivamente pela formatação e saída de dados no console (InvoicePrinter).

## ⚙️ Como Executar

### Via Docker
A aplicação está conteinerizada para facilitar a execução em qualquer ambiente.

1. Clone o repositório:
```bash
git clone https://github.com/leonardocmuniz/ecommerce-refatoracao.git
cd ecommerce-refatoracao
```

2. Construa a imagem e execute o contêiner:
```bash
docker build -t ecommerce-refatoracao .
docker run --rm ecommerce-refatoracao
```

### Via Maven (Local)

Para executar a aplicação principal:
```bash
mvn exec:java -Dexec.mainClass="com.leonardomuniz.App"
```

Para rodar a suíte de testes unitários localmente:
```bash
mvn clean test
```
