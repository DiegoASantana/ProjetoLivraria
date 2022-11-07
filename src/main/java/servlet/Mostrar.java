package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Mostrar")
public class Mostrar extends HttpServlet {
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
		int codLivro = Integer.parseInt(request.getParameter("codLivro"));
		
		try {
			LivroDao dao;
			dao = new LivroDao();
			List<Livro> livros = dao.getMostrar(codLivro);
			
		
			out.println("<html>");
			out.println("<body>");
			int count = 0;
			for(Livro livro: livros) {
				out.println("<h1>Titulo: "+ livro.getTitulo()+ "</h1>");
				out.println("<h2>Autor: "+ livro.getAutor()+ "</h2>");
				out.println("<p><strong>Categoria:</strong> "+ livro.getCategora()+ "</p>");
				out.println("<p><strong>Valor: R$ "+ livro.getValor()+ "</strong></p>");
				out.println("<a href='ExcluirLivro?codLivro="+  livro.getCodLivro()+"'><Button>Excluir Livro</button></a>");
				out.println("<hr>");
				count+=1;
			}
			if(count == 0){
				out.println("<h1>Não Foram Encontrados Registros</h1>");
			}
			
			
			out.println("</div>");
			
			out.println("</body>");
			out.println("</html>");
		}catch(Throwable e) {
			out.println("Deu ERRO" + e);
			e.printStackTrace();
		}
	}

}
