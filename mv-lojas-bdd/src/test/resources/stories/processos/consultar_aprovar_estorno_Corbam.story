Narrative:
Como um usuário do financeiro
Eu quero consultar e aprovar o estorno do corespondente bancario
De modo que o estorno seja aprovado para usuaria de caixa
					 
Scenario:   Aprovar o estono selecionado
Meta:
@base RELOH

Given Eu acesso a instancia http://10.30.232.18:8080
When Eu faco login na loja 291 com usuario 7380 e senha 1
And Eu acesso o menu Administração > Correspondente Bancario> Aprovação de estorno/reimpressão cupons correspondente bancário
And Eu seleciono a opção Pendentes de aprovação
And Eu valido se os registros são do dia
And	Eu seleciono o registro na grid
Then Eu clico no botão Aprovar
And Eu valido a remoção do registro na fila

			 
Scenario: Reprovar o estono selecionado
Meta:
@base RELOH
Given Eu acesso a instancia http://10.30.232.18:8080
When Eu faco login na loja 291 com usuario 7380 e senha 1
And Eu acesso o menu Administração > Correspondente Bancario> Aprovação de estorno/reimpressão cupons correspondente bancário
And Eu seleciono a opção Pendentes de aprovação
And Eu valido se os registros são do dia
And	Eu seleciono o registro na grid
Then Eu clico no botão Reprovar
And Eu valido a remoção do registro na fila

