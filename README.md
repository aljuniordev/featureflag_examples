# Feature Flag em Arquitetura Hexagonal

Este projeto foi criado com o propósito de demonstrar o uso de **Feature Flags** dentro de uma aplicação baseada na **Arquitetura Hexagonal**. 

A **Feature Flag** é uma técnica de desenvolvimento que permite ativar ou desativar funcionalidades em uma aplicação sem a necessidade de realizar um novo deploy. Isso é especialmente útil para o controle gradual de funcionalidades, testes A/B, lançamento controlado de novas funcionalidades, entre outros.

## Objetivos

- Implementar **Feature Flags** utilizando boas práticas de arquitetura.
- Demonstrar como uma **Arquitetura Hexagonal** facilita a separação de preocupações e a evolução da aplicação sem acoplamento direto nas camadas de infraestrutura ou de aplicação.
- Apresentar exemplos práticos de ativação/desativação de funcionalidades utilizando **Feature Flags**.

## Estrutura do Projeto

O projeto segue os princípios da **Arquitetura Hexagonal** (ou **Arquitetura de Portas e Adaptadores**), garantindo a separação de responsabilidades entre o domínio da aplicação, a lógica de negócios e os detalhes de implementação.

### Camadas

1. **Domínio**: Contém as regras de negócio e a lógica central da aplicação. Aqui é onde as funcionalidades são implementadas de forma independente de qualquer tecnologia específica.
   
2. **Port**: Camada que orquestra o uso do domínio e define casos de uso da aplicação.

3. **Adapter**: A camada que conecta a aplicação a serviços externos, como banco de dados, APIs externas, bibliotecas de Feature Flag, etc.

### Exemplo de Organização de Pastas

```bash
src/
├── port/
│   └── in/
│   └── out/
├── domain/
├── adapter/
│   └── in/
│   └── out/
└── shared/
