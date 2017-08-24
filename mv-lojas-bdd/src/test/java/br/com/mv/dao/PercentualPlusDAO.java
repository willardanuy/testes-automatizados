package br.com.mv.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.mv.jdbc.Conexao;
import br.com.mv.utils.Utils;

public class PercentualPlusDAO {

	Connection connection;
	
	public int buscarQtdeMatrizPercentuais(String nroPercentualPlusPrdSrv) throws IOException {
		
		connection = new Conexao().getConexao();
		
		String sql = "select count(*) as qtde_percentuais from MV_PERCENTUAL_PLUS_PRD_SRV where nro_percentual_plus_prd_srv = " + nroPercentualPlusPrdSrv;
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			int qtdPercentuais = 0;
			
			while (rs.next()) {
				qtdPercentuais = rs.getInt("qtde_percentuais");
			}
			
			stmt.close();
			connection.close();
			
			return qtdPercentuais;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage());
		}
	}
}
