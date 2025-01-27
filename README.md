# Aplicativo com Padrão de Arquitetura MVVM (Model-View-ViewModel)  
![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white) ![Android Studio](https://img.shields.io/badge/android%20studio-346ac1?style=for-the-badge&logo=android%20studio&logoColor=white)

Este projeto demonstra como implementar a arquitetura **MVVM (Model-View-ViewModel)** em um aplicativo Android. O objetivo principal é consumir postagens da API [JsonPlaceHolder](https://jsonplaceholder.typicode.com/) e organizar o código de forma clara e modular, seguindo os princípios dessa arquitetura.

## 🛠️ Estrutura do Projeto  

### 🟥 Model  
Responsável por:  
- Realizar chamadas à API para recuperar as postagens.  
- Processar e fornecer os dados ao **ViewModel**.  

### 🟩 View  
Responsável por:  
- Exibir as informações para o usuário.  
- Observar o **LiveData** do **ViewModel** para receber atualizações e exibir os dados.  

No projeto, a **View** é implementada pela `MainActivity`, que:  
- Apresenta os dados na interface do usuário.  
- Observa o **LiveData** do **PostagemViewModel** para atualizar a UI com a lista de postagens.  
- Chama o **ViewModel** no método `onStart()` para iniciar o fluxo de dados.

### 🟪 ViewModel  
Responsável por:  
- Fornecer dados para a **View** por meio de **LiveData**.  
- Controlar o fluxo de dados entre o **Model** e a **View**.  
- Solicitar dados do **Model** e expor de maneira que a **View** possa observar e reagir a mudanças.

### 🟦 Model  
Responsável por:  
- Fazer as requisições à API.  
- Retornar os dados para o **ViewModel**.

## Fluxo de Funcionamento  
1. A **View** (`MainActivity`) chama o **ViewModel** no método `onStart()` para iniciar a solicitação de dados.  
2. O **ViewModel** solicita os dados ao **Model** (API).  
3. O **Model** realiza a chamada à API e retorna os dados ao **ViewModel**.  
4. O **ViewModel** atualiza o **LiveData** com os dados recebidos.  
5. A **View** observa o **LiveData** e é notificada automaticamente quando os dados são atualizados, exibindo-os na interface do usuário.

## 📂 Organização dos Pacotes

- `model`: Contém as classes responsáveis pela lógica de dados, como:

   - **Representações de Dados**: Classes como `Postagem`, que representam as entidades de dados manipuladas dentro do sistema.
   - **PostagemAPI**: Classe que faz a recuperação de postagens da API, realizando chamadas configuradas no pacote `api`.

- `api`: Contém as configurações relacionadas ao acesso à API externa, como:

   - **RetrofitService**: Objeto singleton responsável por criar e fornecer a instância de `JsonPlaceAPI` utilizando o cliente Retrofit, configurado com o URL base e o conversor Gson.
   - **JsonPlaceAPI**: Interface que define os endpoints e métodos de chamada para a API externa.

- `view`: Contém as classes responsáveis pela interface com o usuário (UI), como a `MainActivity`.

- `viewmodel`: Contém as classes responsáveis pela lógica de apresentação, como:

   - **PostagemViewModel**: Classe responsável por gerenciar os dados da `Postagem` e expô-los via `LiveData`, fazendo a intermediação entre o `Model` e a `View`.

## 💡 Vantagens do MVVM

A arquitetura **MVVM (Model-View-ViewModel)** oferece várias vantagens:

### 1. **Melhor Separação de Responsabilidades**
   - A **View** (ex: `MainActivity`) foca apenas na exibição dos dados, enquanto o **ViewModel** lida com a lógica de apresentação, tornando o código mais modular e fácil de manter.

### 2. **Uso de LiveData**
   - O **LiveData** permite observar dados de forma eficiente e "anexado" ao ciclo de vida da **Activity**, garantindo atualizações automáticas da UI sem preocupação com o ciclo de vida e **memory leak**.

### 3. **Persistência de Dados em Mudanças de Ciclo de Vida**
   - O **ViewModel** mantém os dados durante mudanças de configuração, como a rotação da tela, evitando recarregamento desnecessário de dados e melhorando a experiência do usuário.

### 4. **Desacoplamento entre View e ViewModel e facilidade nos testes**
   - O **ViewModel** não tem conhecimento da **View**, facilitando testes unitários e reduzindo o acoplamento, ao contrário do **Presenter** no **MVP**, que precisa interagir diretamente com a **View**.

## 🧑‍💻 Contato
Entre em contato! 😁

**Bruno Vivian Carvalho**

[![Linkedin Badge](https://img.shields.io/badge/-LinkedIn-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/bvcarvalho/)](https://www.linkedin.com/in/bvcarvalho/)
