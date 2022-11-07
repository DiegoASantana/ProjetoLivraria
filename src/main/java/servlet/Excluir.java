package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Excluir")
public class Excluir extends HttpServlet {
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
		int id = Integer.parseInt(request.getParameter("codLivro"));
		
		try {
			LivroDao dao;
			dao = new LivroDao();
			dao.excluir(id);
		
			out.println("<html>");
			out.println("<body>");
			out.println("<h1> Livro Excluído com Sucesso</h1>");
			out.println("</body>");
			out.println("</html>");
		}catch(Throwable e) {
			out.println("Deu ERRO" + e);
			e.printStackTrace();
		}
		
	}

}
