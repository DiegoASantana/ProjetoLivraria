package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Cadastrar")
public class Cadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter out = response.getWriter();
		long codLivro = Integer.parseInt(request.getParameter("codLivro"));
		String titulo = request.getParameter("titulo");
		String autor = request.getParameter("autor");
		String categoria = request.getParameter("categoria");
		float valor = Float.parseFloat(request.getParameter("valor"));
		
		Livro livro = new Livro();
		livro.setCodLivro(codLivro);
		livro.setTitulo(titulo);
		livro.setAutor(autor);
		livro.setCategora(categoria);
		livro.setValor(valor);
		
		try {
			LivroInsertDao dao;
			dao = new LivroInsertDao();
			dao.AdicionaLivro(livro);
			out.println("<html>");
			out.println("<body>");
			out.println("Livro " + livro.getTitulo() + " foi adicionado");
			out.println("</body>");
			out.println("</html>");
		}catch(Throwable e) {
			out.println("Deu ERRO" + e);
			e.printStackTrace();
		}
	}

}
