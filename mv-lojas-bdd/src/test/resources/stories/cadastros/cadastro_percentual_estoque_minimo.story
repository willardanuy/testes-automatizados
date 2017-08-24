Narrative:
Como um usuário adm da loja
Eu quero cadastrar o estoque mínimo a ser presenvado no CD
De modo que esse estoque mínimo seja utilizado no calculo do ressuprimento automatico

Scenario: Cadastrar o estoque mínimo para um CD - UC01 - Fluxo Principal
Meta:
@tag component:Regressao - RELOH
@context CADASTROS
@base RELOH
@grupoInstancias AdmCD
@issue cad-02
@cad-02

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 7380 e senha 1
And Eu acesso o menu Faturamento > Abastecimento > Abastecimento Padrao > Percentual Estoque Mínimo RA
And Eu clico no botao Criar Percentual Estoque Minimo
And Eu informo o percentual minimo 5,00
And Eu informo a data inicio 20/07/2017
And Eu informo a data fim 20/07/2017
And Eu informo o CD CD 47 - CD CONTAGEM 1 - MG
And Eu informo a situacao Sim
And Eu clico no botao Salvar percentual estoque minimo
Then Eu valido a mensagem de sucesso do percentual estoque minimo

Scenario: Pesquisar/Editar o estoque mínimo para um CD - UC01 - FA01
Meta:
@tag component:Regressao - RELOH
@context CADASTROS
@base RELOH
@grupoInstancias AdmCD
@issue cad-02
@cad-02

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 7380 e senha 1
And Eu acesso o menu Faturamento > Abastecimento > Abastecimento Padrao > Percentual Estoque Mínimo RA
And Na pesquisa eu informo o cd CD 47 - CD CONTAGEM 1 - MG
And Eu clico no botao Pesquisar percentual minimo
And Eu clico no icone Editar percentual minimo
And Eu informo o percentual minimo 5,00
And Eu clico no botao Salvar percentual estoque minimo
Then Eu valido a mensagem de sucesso do percentual estoque minimo

Scenario: Pesquisar/Excluir o estoque mínimo para um CD - UC01 - FA03
Meta:
@tag component:Regressao - RELOH
@context CADASTROS
@base RELOH
@grupoInstancias AdmCD
@issue cad-02
@cad-02

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 7380 e senha 1
And Eu acesso o menu Faturamento > Abastecimento > Abastecimento Padrao > Percentual Estoque Mínimo RA

And Na pesquisa eu informo o cd CD 47 - CD CONTAGEM 1 - MG
And Eu clico no botao Pesquisar percentual minimo

!-- Exclui um percentual
And Eu clico no botao Excluir do registro encontrado
And Eu clico Sim no modal percentual estoque minimo

Then Eu valido mensagem de exclusao percentual estoque minimo