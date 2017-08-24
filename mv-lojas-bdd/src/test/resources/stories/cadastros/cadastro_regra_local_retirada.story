Narrative:
Como um usuário adm da loja
Eu quero cadastrar uma regra local retirada
De modo que essa regra seja utilizada nos processos troca, devolução, assistência técnica e reclamação

Scenario: Cadastrar uma regra local de retirada - UC005 - Fluxo Principal
Meta:
@tag component:Regressao - RELOH
@context CADASTROS
@base RELOH
@grupoInstancias AdmCD
@issue cad-07
@cad-07

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 7380 e senha 1
And Eu acesso o menu Administração > Módulo Atendimento Cliente > Regra Local de Retirada
And Eu clico no botao Cadastrar regra local retirada
And Eu informo descricao regra local retirada Teste Automatizado
And Eu seleciono retirada loja Sim regra local retirada
And Eu seleciono retirada cd Não regra local retirada
And Eu seleciono regra retirada loja base Sim regra local retirada
And Eu clico no botao Salvar regra local retirada
Then Eu valido mensagem de sucesso regra local retirada

Scenario: Pesquisar/Editar uma regra local de retirada
Meta:
@tag component:Regressao - RELOH
@context CADASTROS
@base RELOH
@grupoInstancias AdmCD
@issue cad-07
@cad-07

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 7380 e senha 1
And Eu acesso o menu Administração > Módulo Atendimento Cliente > Regra Local de Retirada
And Eu informo descricao regra local retirada Teste Automatizado
And Eu seleciono o filtro retirada loja Sim regra local retirada
And Eu seleciono o filtro retirada cd Não regra local retirada
And Eu seleciono o filtro regra retirada loja base Sim regra local retirada
And Eu clico no botao Pesquisar Regra Local Retirada
And Eu clico no icone Editar Regra Local Retirada
And Eu seleciono retirada loja Não regra local retirada
And Eu seleciono retirada cd Sim regra local retirada
And Eu seleciono regra retirada loja base Não regra local retirada
And Eu clico no botao Salvar regra data base
Then Eu valido mensagem de sucesso regra data base

Scenario: Pesquisar/Excluir uma local de retirada
Meta:
@tag component:Regressao - RELOH
@context CADASTROS
@base RELOH
@grupoInstancias AdmCD
@issue cad-07
@cad-07

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 7380 e senha 1
And Eu acesso o menu Administração > Módulo Atendimento Cliente > Regra Local de Retirada
And Eu informo descricao regra local retirada Teste Automatizado
And Eu seleciono o filtro retirada loja Não regra local retirada
And Eu seleciono o filtro retirada cd Sim regra local retirada
And Eu seleciono o filtro regra retirada loja base Não regra local retirada
And Eu clico no botao Pesquisar Regra Local Retirada
And Eu clico no icone Excluir regra local retirada
And Eu clico no botao Sim modal regra local retirada
Then Eu valido mensagem sucesso de exclusao regra local retirada