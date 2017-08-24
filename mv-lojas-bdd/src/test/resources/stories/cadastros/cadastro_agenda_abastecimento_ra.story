Narrative:
Como um usuário adm da loja
Eu quero cadastrar a agenda de abastecimento 
De modo que essa agenda seja utilizada para abastecer as lojas que necessitam de produtos para uma ação promocional

Scenario: Cadastrar uma agenda de abastecimento para um loja - UC03 - Fluxo Principal
Meta:
@tag component:Regressao - RELOH
@context CADASTROS
@base RELOH
@grupoInstancias AdmCD
@issue cad-04
@cad-04

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 7380 e senha 1
And Eu acesso o menu Faturamento > Abastecimento > Abastecimento Padrao > Agenda Abastecimento RA
And Eu clico no botao Criar Agenda Abastecimento
And Eu informo o titulo Agenda Teste da agenda
And Eu informo a situacao Ativo
And Eu informo a data inicio 20/07/2017
And Na agenda abastecimento eu informo uma data fim valida
And Eu seleciono o tipo de praca Loja da agenda
And No cadastro de agenda de abastecimento eu informo o produto 39547
And Eu informo a expectativa de venda 5
And Na agenda de abastecimento eu informo a loja F291 - DURVAL DE BARROS
And Eu clico no botao Adicionar produto na agenda
And Eu clico no botao Salvar agenda abastecimento
Then Eu valido a mensagem de sucesso da agenda de abastecimento

Scenario: Editar uma agenda de abastecimento - UC03 - FA01 e FA02
Meta:
@tag component:Regressao - RELOH
@context CADASTROS
@base RELOH
@grupoInstancias AdmCD
@issue cad-04
@cad-04

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 7380 e senha 1
And Eu acesso o menu Faturamento > Abastecimento > Abastecimento Padrao > Agenda Abastecimento RA
And Eu informo a situacao Sim
And Eu clico no botao Pesquisar agenda de abastecimento
And Eu clico no icone Editar agenda

And Eu informo o titulo Agenda Teste da agenda
And Eu clico no botao Salvar agenda abastecimento
Then Eu valido a mensagem de sucesso da agenda de abastecimento

Scenario: Excluir uma agenda de abastecimento - UC03 - FA03
Meta:
@tag component:Regressao - RELOH
@context CADASTROS
@base RELOH
@grupoInstancias AdmCD
@issue cad-04
@cad-04

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 7380 e senha 1
And Eu acesso o menu Faturamento > Abastecimento > Abastecimento Padrao > Agenda Abastecimento RA
And Eu informo a situacao Sim
And Eu clico no botao Pesquisar agenda de abastecimento

And Eu clico no icone Excluir agenda
And Eu clico Sim no modal agenda abastecimento
Then Eu valido a mensagem de exclusao da agenda de abastecimento