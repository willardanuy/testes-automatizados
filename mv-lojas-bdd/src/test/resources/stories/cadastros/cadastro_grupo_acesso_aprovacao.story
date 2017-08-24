Narrative:
Como um usuário adm da loja
Eu quero cadastrar um grupo de acesso aprovacao
De modo que seja utilizada como um mecanismo para armazenar os perfis de acesso que poderão aprovar os atendimentos caso a loja esteja presente na lista de lojas sem autonomia.

Scenario: Cadastrar um grupo de acesso- UC006 - Fluxo Principal
Meta:
@tag component:Regressao - RELOH
@context CADASTROS
@base RELOH
@grupoInstancias AdmCD
@issue cad-10
@cad-10

Given Eu executo o script de reset cadastro_grupo_acesso_aprovacao.sql
And Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 7380 e senha 1
And Eu acesso o menu Administração > Módulo Atendimento Cliente > Grupo Acesso Aprovação
And Eu clico no botao Cadastrar grupo acesso aprovacao
And Eu informo perfil acesso Gerente de Lojas grupo acesso aprovacao
And Eu seleciono Sim ativo grupo acesso aprovacao
And Eu clico no botao Salvar grupo acesso aprovacao
Then Eu valido mensagem sucesso grupo acesso aprovacao

Scenario: Pesquisar/Editar um grupo de acesso
Meta:
@tag component:Regressao - RELOH
@context CADASTROS
@base RELOH
@grupoInstancias AdmCD
@issue cad-10
@cad-10

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 7380 e senha 1
And Eu acesso o menu Administração > Módulo Atendimento Cliente > Grupo Acesso Aprovação
And Eu informo filtro perfil acesso Gerente de Lojas grupo acesso aprovacao
And No filtro grupo acesso aprovacao eu seleciono Sim ativo
And Eu clino no botao Pesquisar grupo acesso aprovacao
And Eu clico no botao icone Editar grupo acesso aprovacao
And Eu seleciono Não ativo grupo acesso aprovacao
And Eu clico no botao Salvar grupo acesso aprovacao
Then Eu valido mensagem sucesso grupo acesso aprovacao