package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Listar")
public class Listar extends HttpServlet {
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
		String categoria = request.getParameter("categoria");
		System.out.println(categoria);
		
		try {
			LivroDao dao;
			dao = new LivroDao();
			List<Livro> livros = dao.getListaLivro();
		
			out.println("<html>");
			out.println("<body>");
			out.println("<table border = 1 >");
			out.println("<tr><th>Cod</th><th>Título</th><th>Autor</th><th>Categoria</th><th>Valor</th></tr>");
			int count = 0;
			for(Livro livro: livros) {
				
				if(livro.getCategora().equals(categoria)) {
					out.println("<tr>");
					out.println("<td>"+ livro.getCodLivro()+ "</td>");
					out.println("<td>"+ livro.getTitulo()+ "</td>");
					out.println("<td>"+ livro.getAutor()+ "</td>");
					out.println("<td>"+ livro.getCategora()+ "</td>");
					out.println("<td>"+ livro.getValor()+ "</td>");
					out.println("</tr>");
					count+=1;
				}
				
			}
			if(count == 0){
				out.println("<h1>Não Foram Encontrados Registros</h1>");
			}
			
			
			out.println("</table>");
			
			out.println("</body>");
			out.println("</html>");
		}catch(Throwable e) {
			out.println("Deu ERRO" + e);
			e.printStackTrace();
		}
	}

}
