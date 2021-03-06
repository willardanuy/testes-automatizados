package br.com.mv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.mv.jdbc.Conexao;

public class RotaDAO {
	Connection connection;
			
	/**
	 * Pega as notas fiscais necessárias na hora de efetuar a troca ou devolução de um produto/serviço/pedido
	 * @param nroLoja, int com o número da loja
	 * @param nroPedido, int com o número do pedido
	 * @param nroTiposNf, String com todos os tipos de nf separados por ','. Ex.: ("1,10")
	 * @return
	 */
	public void removerRota(String rota) {
		
		connection = new Conexao().getConexao();
		
		String sql = "delete from mv_rotas where nro_loja_refat = 1101 and rota = '" + rota + "'";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.executeQuery();
			
			stmt.close();
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
}