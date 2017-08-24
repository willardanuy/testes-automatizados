Narrative:
Como um usuário adm da loja
Eu quero cadastrar uma regra linha produto
De modo que essa regra seja utilizada na criação e matutenção de regras relacionadas a linhas de produto

Scenario: Cadastrar uma regra linha de produto - UC002 - Fluxo Principal
Meta:
@tag component:Regressao - RELOH
@context CADASTROS
@base RELOH
@grupoInstancias AdmCD
@issue cad-08
@cad-08

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 7380 e senha 1
And Eu acesso o menu Administração > Módulo Atendimento Cliente > Regra Linha de Produto
And Eu clico no botao Cadastrar regra linha produto
And Eu informo descricao regra linha produto Teste Automatizado
And Eu seleciono departamento 03 AUDIO_ regra linha produto
And Eu clico no botao Adicionar departamento regra linha produto
And Eu clico no botao Salvar regra linha produto
Then Eu valido mensagem sucesso cadastro regra linha produto

Scenario: Pesquisar/Editar uma regra linha de produto
Meta:
@tag component:Regressao - RELOH
@context CADASTROS
@base RELOH
@grupoInstancias AdmCD
@issue cad-08
@cad-08

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 7380 e senha 1
And Eu acesso o menu Administração > Módulo Atendimento Cliente > Regra Linha de Produto
And Eu informo descricao regra linha produto Teste Automatizado
And Eu seleciono departamento 03 AUDIO_ regra linha produto
And Eu clico no botao Pesquisar regra linha produto
And Eu clico no icone Editar regra linha produto
And Eu seleciono departamento 04 INFORMATICA_ regra linha produto
And Eu clico no botao Adicionar departamento regra linha produto
And Eu clico no botao Salvar regra linha produto
Then Eu valido mensagem sucesso cadastro regra linha produto

Scenario: Pesquisar/Excluir uma regra linha de produto
Meta:
@tag component:Regressao - RELOH
@context CADASTROS
@base RELOH
@grupoInstancias AdmCD
@issue cad-08
@cad-08

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 7380 e senha 1
And Eu acesso o menu Administração > Módulo Atendimento Cliente > Regra Linha de Produto
And Eu informo descricao regra linha produto Teste Automatizado
And Eu seleciono departamento 03 AUDIO_ regra linha produto
And Eu clico no botao Pesquisar regra linha produto
And Eu clico no icone Excluir regra linha produto
And Eu clico no botao Sim modal regra linha produto
Then Eu valido mensagem sucesso de exclusao regra linha produto