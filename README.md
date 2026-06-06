# 🏦 Sistema de Contas Bancárias em Java

## 📌 Sobre o projeto

Este projeto simula um **sistema bancário digital simplificado**, desenvolvido em Java com foco em **Programação Orientada a Objetos (POO)**.

O sistema implementa diferentes tipos de contas bancárias com comportamentos específicos, aplicando conceitos como **herança, polimorfismo, interfaces e tratamento de exceções**, além de regras de negócio próximas de um cenário real de instituição financeira.

A arquitetura foi projetada para ser **extensível**, permitindo a adição de novos tipos de conta sem necessidade de alteração na estrutura base.

---

## 🧠 Conceitos aplicados

- Classes abstratas  
- Métodos abstratos  
- Herança  
- Polimorfismo  
- Interfaces  
- Encapsulamento  
- Sobrescrita de métodos  
- Exceções customizadas  
- Separação de responsabilidades  

---

## ⚠️ Exceções do sistema

### ❌ OperacaoInvalidaException (Checked)

Lançada quando o usuário tenta realizar qualquer operação em uma conta bloqueada.

#### 📌 Justificativa (Checked)

Essa exceção foi definida como **Checked Exception** porque:

- Representa uma regra de negócio obrigatória  
- O sistema deve forçar o tratamento explícito da situação  
- Operações em contas bloqueadas são previsíveis e controláveis  
- Garante que o desenvolvedor não ignore essa condição por acidente  

👉 Ou seja: o compilador obriga o tratamento, aumentando a segurança do sistema.

---

### ❌ SaldoInsuficienteException (Unchecked)

Lançada quando o usuário tenta sacar um valor maior que o saldo disponível ou limite permitido.

#### 📌 Justificativa (Unchecked)

Essa exceção foi definida como **Unchecked Exception (RuntimeException)** porque:

- Representa um erro de lógica de uso do sistema  
- Pode ocorrer em diversos pontos sem necessidade de tratamento obrigatório  
- Faz parte do fluxo natural de validação de regras financeiras  
- Não exige que todos os métodos declarem ou tratem explicitamente  

👉 Ou seja: indica uso incorreto ou inválido da operação, não um erro estrutural do sistema.

---

## 🏗️ Estrutura do projeto

### 🔷 ContaBancaria (classe abstrata)

Classe base responsável por definir atributos e comportamentos comuns:

- numero  
- titular  
- saldo  
- ativa  

---

### 🔒 Bloqueavel (interface)

Define controle de estado da conta:

- bloquear()  
- desbloquear()  
- isAtiva()  

---

### 🧾 Tributavel (interface)

Define comportamento de tributação:

- calcularImposto()  

---

## 💳 Tipos de Conta

### 🟦 ContaCorrente

- Cheque especial: até R$ 1.000,00  
- Rendimento: 0  
- Imposto: 0,38% sobre saldo  

---

### 🟩 ContaPoupanca

- Rendimento: 0,5% ao mês  
- Imposto: 22,5% sobre rendimento  

---

### 🟨 ContaSalario

- Sem rendimento  
- Sem imposto  

---

## 🔄 Polimorfismo

O sistema demonstra polimorfismo ao armazenar diferentes tipos de contas em uma estrutura comum (`List<ContaBancaria>`) e executar comportamentos específicos em tempo de execução.

```java
for (ContaBancaria conta : contas) {
    System.out.println("Titular: " + conta.getTitular());
    System.out.println("Tipo: " + conta.getClass().getSimpleName());
    System.out.println("Saldo: R$ " + conta.getSaldo());
    System.out.println("Rendimento: R$ " + conta.calcularRendimento());
}

````
# 👨‍💻 Autor

### 👤 Giovane Ferreira Paes Ribeiro

- Centro Universitário Santo Agostinho — UNIFSA
- Disciplina: Programação Orientada a Objeto - POO
- Professora: Heloisa Guimarães Coelho
