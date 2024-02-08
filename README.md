# Projeto de Estudo - Princípios SOLID em Java

## Descrição

Este projeto é uma implementação de exemplos práticos dos princípios SOLID em Java. Cada pacote representa um princípio específico, abordando os conceitos de Responsabilidade Única, Aberto/Fechado, Substituição de Liskov, Segregação de Interface e Inversão de Dependência.

## Princípios SOLID

### 1. SRP - Princípio da Responsabilidade Única
  - `SRP.violacao.Cliente`: Exemplo de violação do SRP.
  - `SRP.solucao.Cliente`: Aplicação do SRP com a separação de responsabilidades.

### 2. OCP - Princípio Aberto/Fechado
  - `OCP.Violacao.DebitoConta`: Exemplo de violação do OCP.
  - `OCP.Solucao.DebitoConta`, `DebitoContaCorrente` e `DebitoContaPoupanca`: Aplicação do OCP com extensibilidade.

### 3. LSP - Princípio da Substituição de Liskov
  - `LSP.Violacao.CalculoArea`: Exemplo de violação do LSP.
  - `LSP.Solucao.Quadrado`, `LSP.Solucao.Retangulo` e `LSP.Solucao.Paralelogramo`: Aplicação do LSP.

### 4. ISP - Princípio da Segregação de Interface
  - `ISP.Violacao.Cliente`: Exemplo de violação do ISP.
  - `ISP.Solucao.ICliente` e `ISP.Solucao.Cliente`: Aplicação do ISP com interfaces segregadas.

### 5. DIP - Princípio da Inversão de Dependência
  - `DIP.Violacao.Cliente`, `EmailServices` e `CPFServices`: Exemplo de violação do DIP.
  - `DIP.Solucao.Cliente`, `ClienteRepository`, `ClienteServices` e interfaces correspondentes: Aplicação do DIP com inversão de dependência.

## Contribuição

Sinta-se à vontade para contribuir ou fornecer feedback sobre os exemplos apresentados. Se desejar adicionar mais princípios SOLID ou melhorar a implementação existente, siga as etapas usuais de fork e pull request.
