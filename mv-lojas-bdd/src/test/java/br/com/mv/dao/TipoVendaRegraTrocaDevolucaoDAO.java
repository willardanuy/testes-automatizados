package br.com.mv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.mv.jdbc.Conexao;

public class TipoVendaRegraTrocaDevolucaoDAO {

	Connection connection = new Conexao().getConexao();
	
	public void inserirTipoVendaRegraTrocaDevolucao(int nroTipoVenda, int nroSeqRegra) {
		
		String sql = "insert into MV_TIPO_VENDA_X_REGRA_TROCADE(nro_tipo_venda, nro_seq_regra, dt_inclusao, dt_alteracao)" +
					 "values(?, ?, to_char(sysdate, 'dd/mm/yy'), to_char(sysdate, 'dd/mm/yy'))";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, nroTipoVenda);
			stmt.setInt(2, nroSeqRegra);
			stmt.execute();
			stmt.close();
			
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage());
		}
	}

	public void excluirTipoVendaRegraTrocaDevolucao (int nroTipoVenda, int nroSeqRegra) {
		
		String sql = "delete from MV_TIPO_VENDA_X_REGRA_TROCADE where nro_tipo_venda = ? and nro_seq_regra = ?";
	
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, nroTipoVenda);
			stmt.setInt(2, nroSeqRegra);
			stmt.execute();
			stmt.close();
			
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
}
