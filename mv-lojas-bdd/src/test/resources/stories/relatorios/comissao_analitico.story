Narrative:
Como um usuário adm da loja
Eu quero gerar um relatorio de comissao analitico
De modo que o relatorio seja criado ao finalizar o processo

Scenario: Gerar relatorio analítico
Meta:
@tag component:Regressao - RELOH
@context RELATORIOS
@base RELOH
@issue rel-01
@rel-01

Given Eu acesso a instancia http://10.30.232.81:8080
When Eu faco login na loja 291 com usuario 6699 e senha 1
And Eu acesso o menu Fopag > Relatório > Comissão Analítico
And Eu clico no botao Referencia
And Eu informo o ano 2013 da comissao
And Eu clico no botao pesquisar referencia
And Eu seleciono o mes da referencia
And Eu informo o nro loja do relatorio de comissao analitico 291
And Eu clico no botao imprimir relatorio de comissao analitico
Then Eu valido o relatorio comissao analitico