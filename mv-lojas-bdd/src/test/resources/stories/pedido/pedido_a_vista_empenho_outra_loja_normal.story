Narrative:
Como um usuário vendedor da loja
Eu quero elaborar um pedido a vista com empenho em outra loja/normal
De modo que o pedido seja criado ao finalizar o processo

Scenario: Elaborar um pedido a vista com empenho em outra loja/normal
Meta:
@tag component:Smoke testing - RELOH
@context SMOKE_TESTING
@base RELOH
@grupoInstancias Pedidos
@issue smk-03
@smk-03

Given Eu acesso a instancia padrao
When Eu faco login na loja 291 com usuario 69930 e senha 1
And Eu pesquiso o cpf 37778670550
And Eu clico no botao 'Elaborar Pedido'

And Eu seleciono o tipo de venda 1 - A VISTA

And Eu clico no botao adicionar produto
And Eu pesquiso e seleciono o produto 711
And Eu clico no icone detalhes do produto 711
And Eu seleciono o local de empenho OUTRA LOJA
And Eu seleciono a opcao de entrega NORMAL
And Eu clico no botao Reservar
And Eu seleciono a loja disponivel 286

And Eu clico na aba Liberações
And Eu seleciono a liberacao LIBERACAO DE RESERVA OUTRA LOJA com flags A;C;D;G;R;V para o produto 711
And Eu clico no botao Liberar
And Eu clico no botao Ok do modal
And Eu clico no botao Ok do modal
And Eu clico na aba Liberações
And Eu seleciono a liberacao LIBERACAO DE RESERVA OUTRA LOJA com flags A;C;D;G;R;V para o produto 711
And Eu clico no botao Liberar
And Eu informo a observacao OBS LIBERACAO da liberacao
And Eu clico no botao Ok do modal

And Eu clico na aba Planilha
And Eu clico no botao Adicionar Forma Pagamento
And Eu seleciono o 1 º tipo de pagamento V
And Eu seleciono a 1 ª forma de pagamento Dinheiro

Then Eu clico no botao Salvar
And Eu clico no botao Ok do modal
And Eu clico no botao Fechamento Total
And Eu valido o status do pedido 30 - Ag. Receb. ou em Analise p/Troca Minha Casa Melhor
And Eu salvo o pedido do teste @smk-03 no relatorio