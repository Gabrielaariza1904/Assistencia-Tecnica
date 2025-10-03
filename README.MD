# Projeto de Assistência Técnica

Este projeto é um sistema de assistência técnica desenvolvido em Java, com o objetivo de gerenciar o atendimento ao cliente, controle de estoque e ordens de serviço.

## Funcionalidades

1. **Cadastro de Cliente**
   - Permite o registro de novos clientes no sistema, armazenando informações como nome, CPF, e contato.

2. **Cadastro de Aparelho**
   - Possibilita o cadastro de aparelhos trazidos pelos clientes para manutenção ou conserto.

3. **Seleção de Peça**
   - Permite consultar a disponibilidade e o preço de peças no estoque antes de realizar o serviço.
   - Digite os IDs das peças separado por virgula que deseja para seu aparelho, assim criamos a ordem de serviço com suas peças.
   
4. **Geração de Ordem de Serviço**
   - Cria ordens de serviço detalhando o serviço a ser realizado, peças utilizadas e valores.

5. **Geração da Notificação ao Cliente**
   - Envia notificações ao cliente sobre o status do serviço, valores e prazos.

## Controle de Estoque

- O módulo `ControleEstoque` é utilizado para buscar peças no estoque, garantindo que apenas peças disponíveis possam ser selecionadas para os serviços.

## Lógica de Ordem de Serviço

Ao criar uma ordem de serviço, os dados do aparelho selecionado pelo cliente também são salvos na tabela de ordem de serviço. Isso garante que cada ordem de serviço registre não apenas as peças e valores, mas também as informações do aparelho que será atendido, facilitando o controle e o histórico de manutenções para cada cliente e dispositivo.

## Estrutura do Projeto

O projeto está organizado em pacotes para facilitar a manutenção e a escalabilidade, incluindo módulos para modelo de dados, controle de estoque, configuração de banco de dados e funcionalidades principais.

---

Este sistema visa otimizar o fluxo de trabalho em assistências técnicas, proporcionando agilidade e organização no atendimento ao cliente e na gestão de serviços.
