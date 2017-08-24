Narrative:
Como um usuário adm da loja
Eu quero cadastrar o um percentual plus para determinadas lojas
De modo que esse percentual seja utilizado no calculo da comissao dos vendedores

Scenario: Cadastra o percentual plus
Meta:
@tag component:Regressao - MVSH
@context CADASTROS
@base MVSH
@grupoInstancias AdmCD
@issue cad-05
@cad-05

Given Eu acesso a instancia padrao
When Eu faco login na loja 1183 com usuario 7380 e senha 1
And Eu acesso o menu Fopag > Cadastro > Percentual Plus

And Eu clico no botao Criar Matriz Plus
And Na matriz plus eu informo a quantidade de produtos 2 para gerar tabela
And Na matriz plus eu informo a quantidade de servicos 2 para gerar tabela
And Eu clico no botao Gerar tabela percentual plus
And Eu informo a data inicio 01/01/2018
And Eu informo a data fim 01/01/2018
And Eu informo os valores da tabela percentual para 2 produtos e 2 servicos
And Eu clico no botao Salvar matriz percentual
Then Eu valido a mensagem de sucesso do cadastro percentual plus

Scenario: Valida mensagem de matriz ja cadastrada
Meta:
@tag component:Regressao - MVSH
@context CADASTROS
@base MVSH
@grupoInstancias AdmCD
@issue cad-05
@cad-05

Given Eu acesso a instancia padrao
When Eu faco login na loja 1183 com usuario 7380 e senha 1
And Eu acesso o menu Fopag > Cadastro > Percentual Plus

And Eu clico no botao Criar Matriz Plus
And Na matriz plus eu informo a quantidade de produtos 2 para gerar tabela
And Na matriz plus eu informo a quantidade de servicos 2 para gerar tabela
And Eu clico no botao Gerar tabela percentual plus
And Eu informo a data inicio 01/01/2018
And Eu informo a data fim 01/01/2018
And Eu informo os valores da tabela percentual para 2 produtos e 2 servicos
And Eu clico no botao Salvar matriz percentual
Then Eu valido a mensagem de matriz percentual plus ja existente

Scenario: Pesquisa / Edita o percentual plus
Meta:
@tag component:Regressao - MVSH
@context CADASTROS
@base MVSH
@grupoInstancias AdmCD
@issue cad-05
@cad-05

Given Eu acesso a instancia padrao
When Eu faco login na loja 1183 com usuario 7380 e senha 1
And Eu acesso o menu Fopag > Cadastro > Percentual Plus

And Eu informo a data inicio 01/01/2018
And Eu informo a data fim 01/01/2018
And Eu clico no botao Pesquisar matriz plus

And Eu valido os percentuais no base de dados
And Eu clico na chave do percentual plus

And Eu informo a data inicio 03/01/2018
And Eu informo a data fim 03/01/2018
And Na matriz plus eu informo a loja F1183 - CAPINZAL - SC

And Eu clico no botao Salvar matriz percentual
Then Eu valido a mensagem de sucesso do cadastro percentual plus

Scenario: Exclui o percentual plus
Meta:
@tag component:Regressao - MVSH
@context CADASTROS
@base MVSH
@grupoInstancias AdmCD
@issue cad-05
@cad-05

Given Eu acesso a instancia padrao
When Eu faco login na loja 1183 com usuario 7380 e senha 1
And Eu acesso o menu Fopag > Cadastro > Percentual Plus

And Eu informo a data inicio 03/01/2018
And Eu informo a data fim 03/01/2018
And Na pesquisa matriz plus eu informo a loja F1183 - CAPINZAL - SC

And Eu clico no botao Pesquisar matriz plus

And Eu confirmo exclusao tabela percentual
Then Eu valido a mensagem de exclusao de tabela percentual

Scenario: Cria pedido para validar percentual plus calculado para o vendedor
Meta:
@tag component:Regressao - MVSH
@context CADASTROS
@base MVSH
@grupoInstancias Pedidos
@issue cad-05
@cad-05-1

Given Eu acesso a instancia padrao
When Eu faco login na loja 1183 com usuario 7380 e senha 1
And Eu pesquiso o cpf 191
And Eu clico no botao 'Elaborar Pedido'

And Eu seleciono o tipo de venda 76 - CREDCASA
And Eu seleciono o plano 10 X

And Eu clico no botao Salvar
And Eu clico no botao Ok do modal

And Eu clico no botao adicionar produto
And Eu pesquiso e seleciono o produto 296495

Then Eu clico no botao Salvar
And Eu clico no botao Ok do modal
And Eu valido o valor do campo plus juros
