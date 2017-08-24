DECLARE
  
BEGIN
	

update mv_estoque_produto set qtde_estoque = 1000 where nro_produto = 135156 and nro_loja = 1101 and nro_grupo_estoque = 1;
update mv_estoque_produto set qtde_estoque = 1000 where nro_produto = 87607 and nro_loja = 1101 and nro_grupo_estoque = 1;
update mv_estoque_produto set qtde_estoque = 1000 where nro_produto = 93417 and nro_loja = 1101 and nro_grupo_estoque = 1;


END;