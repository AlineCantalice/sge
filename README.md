# sge

O seguinte projeto foi desenvolvido como aplicação spring boot, sendo necessário instalar as dependencias liquibase, docker compose, postgresql, lombok, mapstruct, junit-jupyter e maven para seu funcionamento.

A aplicação corresponde a um sistema de gerenciamento de eventos em que os participantes do evento podem se cadastrar com seu nome e sobrenome, além disso podem ser cadastradas salas e espaços de descanso a partir do nome do espaço e a lotação. Quando as pessoas e salas estiverem cadastradas serão divididas as duas etapas do evento.

O banco da aplicação possui 3 tabelas: pessoa, espaço e etapa, em que as pessoas são salvas com o nome e sobrenome e as salas com nome e lotação, além de possuir uma coluna booleana chamada sala que corresponde a uma sala se verdadeira e a um espaço de descanso se falsa. Já a tabela etapa é preenchida automaticamente a partir do id da pessoa e do espaço quando todos esses dados forem cadastrados.

Para a solução foi pensado em criar uma aplicação web completa tendo o back-end em Java e o front-end com o framework Angular, devido a não ter certeza se poderia ou não ser uma aplicação do formato web a solução não possui o front-end sendo necessário a utilização do postman para a realização de cadastro de dados.

