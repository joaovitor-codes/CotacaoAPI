# 💰 ConvertCoins 💸

Este é o projeto de frontend para o conversor de moedas **ConvertCoins**, desenvolvido como parte de um trabalho de faculdade. A aplicação é construída em **Angular** e consome uma API backend (Spring Boot) para fornecer cotações em tempo real.

O design foi focado em uma estética "tech" moderna, utilizando um fundo estático "blueprint" e um card flutuante com efeito de "vidro fosco" (frosted glass).

## ✨ Funcionalidades (Features)

* **Conversão em Tempo Real:** Converte valores com base em cotações atualizadas.
* **Restrição de API:** A interface é "travada" para converter apenas de **USD** para outras moedas, seguindo a regra de negócio da API.
* **Design "Hi-Tech":** Interface com fundo estático "blueprint" e um card central com efeito de vidro fosco para uma estética moderna.
* **Tratamento de Erros Inteligente:** Exibe mensagens de erro amigáveis diretamente do backend (ex: "Moeda não encontrada" ou "Sistema sobrecarregado") em vez de erros genéricos.

## 🛠️ Tecnologias Utilizadas

* **Angular**
* **TypeScript**
* **HTML5**
* **CSS3** (com design responsivo)

## 🚀 Como Executar o Projeto

Para rodar este projeto localmente, você precisará ter o Node.js, o Angular CLI e o backend da aplicação rodando.

### Pré-requisitos

* **Node.js** (v18 ou superior)
* **Angular CLI** (`npm install -g @angular/cli`)
* O **Backend (ExchangeApi)** deve estar em execução na porta `localhost:8080`.
  * (Link para o repositório do backend: `https://github.com/[seu-usuario]/ExchangeApi-Backend`)

### Passos para Instalação

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/](https://github.com/)[seu-usuario]/ExchangeApi-Frontend.git
    ```

2.  **Entre na pasta do projeto:**
    ```bash
    cd ExchangeApi-Frontend
    ```

3.  **Instale as dependências do Node.js:**
    ```bash
    npm install
    ```

4.  **Execute a aplicação:**
    ```bash
    ng serve --open
    ```

A aplicação será aberta automaticamente no seu navegador em `http://localhost:4200/`.

## 🔗 Conexão com o Backend

Este frontend foi projetado para consumir o **[ExchangeApi-Backend](https://github.com/[seu-usuario]/ExchangeApi-Backend)**.

A URL da API está configurada no arquivo `src/app/conversion.service.ts` e aponta para `http://localhost:8080/conversion`.

**Certifique-se de que o backend esteja rodando antes de iniciar o frontend!**
