package servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class LivroDao {
	// a conexão com o banco de dados
		private Connection connection;
		
		public LivroDao() throws ClassNotFoundException{
			this.connection = new ConnectionFactory().getConnection();
		}
		
		public void AdicionaLivro(Livro livro) {
			String sql = "insert into tblivros (codlivro,titulo,autor,categoria,valor) values (?,?,?,?,?)";
			
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
		
		public List<Livro> getListaLivro(String categoria){
			try {
				List<Livro> livros = new ArrayList<Livro>();
				PreparedStatement stmt = this.connection.prepareStatement("select * from tblivros where categoria like '"+categoria+"'");
				
				stmt.execute();
				ResultSet rs = stmt.executeQuery();
				
				while (rs.next()) {
					Livro livro = new Livro();
					livro.setCodLivro(rs.getLong("codlivro"));
					livro.setTitulo(rs.getString("titulo"));
					livro.setAutor(rs.getString("autor"));
					livro.setCategora(rs.getString("categoria"));
					livro.setValor(rs.getFloat("valor"));
					livros.add(livro);
				}
				rs.close();
				stmt.close();
				return livros;
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		public void excluir(long codLivro) {
			String sql = "delete from tblivros where CodLivro = ?";
			
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				// setar os valores
				stmt.setLong(1,codLivro);
				//executa
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
}
