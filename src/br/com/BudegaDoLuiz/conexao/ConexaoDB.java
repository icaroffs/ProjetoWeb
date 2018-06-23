package br.com.BudegaDoLuiz.conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/budegadoluizdb","root","root");
			System.out.println("Conectado com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro ao conectar "+e.getMessage());	
		}
		return conn;
	}
}

