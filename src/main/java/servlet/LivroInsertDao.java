package servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LivroInsertDao {
	// a conexão com o banco de dados
		private Connection connection;
		
		public LivroInsertDao() throws ClassNotFoundException{
			this.connection = new ConnectionFactory().getConnection();
		}
		
		public void AdicionaLivro(Livro livro) {
			String sql = "insert into tblivros (codlivro, titulo,autor,categoria,valor) values (?,?,?,?,?)";
			
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				// setar os valores
				stmt.setLong(1, livro.getCodLivro());
				stmt.setString(2, livro.getTitulo());
				stmt.setString(3, livro.getAutor());
				stmt.setString(4, livro.getCategora());
				stmt.setFloat(5, livro.getValor());
				//executa
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
}
