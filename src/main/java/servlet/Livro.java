package servlet;

public class Livro {
	private long codLivro;
	private String titulo;
	private String autor;
	private String categora;
	private float valor;
	
	
	public long getCodLivro() {
		return codLivro;
	}
	public void setCodLivro(long codLivro) {
		this.codLivro = codLivro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getCategora() {
		return categora;
	}
	public void setCategora(String categora) {
		this.categora = categora;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	
}
