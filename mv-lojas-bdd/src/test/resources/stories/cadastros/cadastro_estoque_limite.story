Narrative:
Como um usuário adm da loja
Eu quero cadastrar o estoque limite para determinadas lojas
De modo que esse limite seja utilizado no calculo do ressuprimento automatico

Scenario: Cadastra o estoque limite para uma loja
Meta:
@tag component:Regressao - RELOH
@context CADASTROS
@base RELOH
@grupoInstancias AdmCD
@issue cad-03
@cad-03

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 7380 e senha 1
And Eu acesso o menu Faturamento > Abastecimento > Abastecimento Padrao > Estoque Limite V2

And Eu clico no botao Adicionar Novo estoque limite
And Eu seleciono a opcao Loja do campo selecao de lojas
And No estoque limite eu informo a loja F291 - DURVAL DE BARROS
And Eu seleciono a opcao Produto do campo selecao de produtos
And Eu informo a quantidade 10
And Eu informo o produto 39547

And Eu clico no botao Adicionar estoque limite
And Eu clico no botao Salvar estoque limite
And Eu clico Sim no modal estoque limite
Then Eu valido a mensagem de sucesso do cadastro estoque limite

Scenario: Pesquisa / Edita o estoque limite para uma loja
Meta:
@tag component:Regressao - RELOH
@context CADASTROS
@base RELOH
@grupoInstancias AdmCD
@issue cad-03
@cad-03

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 7380 e senha 1
And Eu acesso o menu Faturamento > Abastecimento > Abastecimento Padrao > Estoque Limite V2

And Na pesquisa estoque limite eu seleciono a opcao Loja da selecao de lojas
And Na pesquisa estoque limite eu informo a loja F291 - DURVAL DE BARROS
And Eu clico no botao Pesquisar estoque limite

And Eu clico no icone Editar estoque limite
And Eu informo a quantidade 11
And Eu clico no botao Confirmar Edicao estoque limite

And Eu clico no botao Salvar estoque limite

Scenario: Exclui o estoque limite para uma loja
Meta:
@tag component:Regressao - RELOH
@context CADASTROS
@base RELOH
@grupoInstancias AdmCD
@issue cad-03
@cad-03

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 7380 e senha 1
And Eu acesso o menu Faturamento > Abastecimento > Abastecimento Padrao > Estoque Limite V2

And Na pesquisa estoque limite eu seleciono a opcao Loja da selecao de lojas
And Na pesquisa estoque limite eu informo a loja F291 - DURVAL DE BARROS
And Eu clico no botao Pesquisar estoque limite

And Eu seleciono o estoque limite para excluir
And Eu clico no botao Excluir estoque limite
And Eu clico Sim no modal estoque limite
Then Eu valido a mensagem de exclusao de estoque limite