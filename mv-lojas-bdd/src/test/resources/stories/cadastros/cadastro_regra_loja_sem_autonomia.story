Narrative:
Como um usuário adm da loja
Eu quero cadastrar uma regra loja sem autonomia
De modo que seja utilizada como um mecanismo para o criação e manutenção de regras para restrição de autonomia de lojas específicas.

Scenario: Cadastrar uma regra loja sem autonomia - UC006 - Fluxo Principal
Meta:
@tag component:Regressao - RELOH
@context CADASTROS
@base RELOH
@grupoInstancias AdmCD
@issue cad-09
@cad-09

Given Eu executo o script de reset cadastro_regra_loja_sem_autonomia.sql
And Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 7380 e senha 1
And Eu acesso o menu Administração > Módulo Atendimento Cliente > Regra Lojas Sem Autonomia
And Eu clico no botao Incluir Lojas regra lojas sem autonomia
And Eu informo loja F291 - DURVAL DE BARROS regra lojas sem autonomia
And Eu seleciono ativo Sim regra loja sem autonomia
And Eu clico no botao Adicionar regra loja sem autonomia
And Eu clico no botao Salvar regra loja sem autonomia
Then Eu valido mensagem sucesso cadastro regra loja sem autonomia

Scenario: Pesquisar/Desativar uma regra loja sem autonomia
Meta:
@tag component:Regressao - RELOH
@context CADASTROS
@base RELOH
@grupoInstancias AdmCD
@issue cad-09
@cad-09

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 7380 e senha 1
And Eu acesso o menu Administração > Módulo Atendimento Cliente > Regra Lojas Sem Autonomia
And Eu informo filtro loja F291 - DURVAL DE BARROS regra loja sem autonomia
And Eu seleciono filtro ativo Sim regra loja sem autonomia
And Eu clico no botao Pesquisar regra loja sem autonomia
And Eu seleciono checkbox ativar/desativar regra loja sem autonomia
And Eu clico botao desativar lojas regra loja sem autonomia
Then Eu valido mensagem sucesso desativacao loja regra loja sem autonomia

Scenario: Pesquisar/Ativar uma regra loja sem autonomia
Meta:
@tag component:Regressao - RELOH
@context CADASTROS
@base RELOH
@grupoInstancias AdmCD
@issue cad-09
@cad-09

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 7380 e senha 1
And Eu acesso o menu Administração > Módulo Atendimento Cliente > Regra Lojas Sem Autonomia
And Eu informo filtro loja F291 - DURVAL DE BARROS regra loja sem autonomia
And Eu seleciono filtro ativo Não regra loja sem autonomia
And Eu clico no botao Pesquisar regra loja sem autonomia
And Eu seleciono checkbox ativar/desativar regra loja sem autonomia
And Eu clico botao ativar lojas regra loja sem autonomia
Then Eu valido mensagem sucesso ativacao loja regra loja sem autonomia