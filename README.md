## Autor
**Alcemir R P Junior**  
E-mail: [al.junior.dev@gmail.com](mailto:al.junior.dev@gmail.com)

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
├── application
│   └── port/
│      └── in/
│      └── out/
├── domain/
├── infra
│   └── adapter/
│      └── in/
│      └── out/
│   └── shared/
```

## Exemplos de Uso

Este repositório inclui exemplos práticos de como as Feature Flags podem ser aplicadas em diferentes cenários dentro de um projeto com arquitetura hexagonal. Os exemplos abordam diferentes camadas e aspectos da aplicação, demonstrando a flexibilidade e a escalabilidade dessa abordagem.

### 1. Ao Adicionar Padrão de Projeto Strategy
Demonstramos como a implementação do padrão **Strategy** pode ser controlada por Feature Flags, permitindo habilitar ou desabilitar diferentes estratégias de forma dinâmica, sem impactar o núcleo do domínio.

### 2. Ao Adicionar Novo Repositório
Mostramos como novos repositórios podem ser integrados e gerenciados utilizando Feature Flags, possibilitando a transição suave entre diferentes fontes de dados sem afetar outras partes do sistema.

### 3. Ao Alterar Swagger
Ilustramos como as Feature Flags podem ser aplicadas para habilitar ou desabilitar determinadas rotas ou recursos documentados no **Swagger**, permitindo uma configuração controlada da documentação da API conforme novas funcionalidades são liberadas.

### 4. Ao Alterar Regras de Domínio
Este exemplo explora o uso de Feature Flags para controlar mudanças nas **regras de negócio**. Isso permite que novas regras sejam implementadas e testadas em ambientes específicos antes de serem totalmente liberadas em produção.

