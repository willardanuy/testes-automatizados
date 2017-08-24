Narrative:
Como um usuário adm da loja
Eu quero cadastrar uma regra data base
De modo que essa regra seja utilizada para disponibilizar as tratativas para o Cliente

Scenario: Cadastrar uma regra data base - UC004 - Fluxo Principal
Meta:
@tag component:Regressao - RELOH
@context CADASTROS
@base RELOH
@grupoInstancias AdmCD
@issue cad-06
@cad-06

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 7380 e senha 1
And Eu acesso o menu Administração > Módulo Atendimento Cliente > Regra Data Base
And Eu clico no botao Cadastrar Regra Data Base
And Eu informo descricao regra data base Teste Automatizado
And Eu seleciono o tipo regra data base Produto
And Eu informo dias data venda 2
And Eu clico no botao Salvar regra data base
Then Eu valido mensagem de sucesso regra data base

Scenario: Cadastrar uma regra data base ja existente
Meta:
@tag component:Regressao - RELOH
@context CADASTROS
@base RELOH
@grupoInstancias AdmCD
@issue cad-06
@cad-06

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 7380 e senha 1
And Eu acesso o menu Administração > Módulo Atendimento Cliente > Regra Data Base
And Eu clico no botao Cadastrar Regra Data Base
And Eu informo descricao regra data base Teste Automatizado
And Eu seleciono o tipo regra data base Produto
And Eu informo dias data venda 2
And Eu clico no botao Salvar regra data base
Then Eu valido mensagem de regra data base ja existente

Scenario: Pesquisar/Editar uma regra data base
Meta:
@tag component:Regressao - RELOH
@context CADASTROS
@base RELOH
@grupoInstancias AdmCD
@issue cad-06
@cad-06

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 7380 e senha 1
And Eu acesso o menu Administração > Módulo Atendimento Cliente > Regra Data Base
And Na pesquisa de regra data base eu informo descricao Teste Automatizado
And Eu clico no botao Pesquisar Regra Data Base
And Eu clico no icone Editar regra data base
And Eu informo descricao regra data base Teste Automatizado
And Eu seleciono o tipo regra data base Produto
And Eu informo dias data venda 3
And Eu informo dias data entrega 5
And Eu informo dias data montagem 6
And Eu informo dias data faturamento 7
And Eu clico no botao Salvar regra data base
Then Eu valido mensagem de sucesso regra data base

Scenario: Pesquisar/Excluir uma regra data base
Meta:
@tag component:Regressao - RELOH
@context CADASTROS
@base RELOH
@grupoInstancias AdmCD
@issue cad-06
@cad-06

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 7380 e senha 1
And Eu acesso o menu Administração > Módulo Atendimento Cliente > Regra Data Base
And Na pesquisa de regra data base eu informo descricao Teste Automatizado
And Na pesquisa de regra data base eu seleciono tipo regra Produto
And Na pesquisa de regra data base eu informo dias data venda 3
And Na pesquisa de regra data base eu informo dias data entrega 5
And Na pesquisa de regra data base eu informo dias data montagem 6
And Na pesquisa de regra data base eu informo dias data faturamento 7
And Eu clico no botao Pesquisar Regra Data Base
And Eu clico no icone Excluir regra data base
And Eu clico no botao Sim modal regra data base
Then Eu valido mensagem de exclusao regra data base