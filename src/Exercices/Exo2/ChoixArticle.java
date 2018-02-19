package Exercices.Exo2;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChoixArticle extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2513026731256348077L;

	public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException , ServletException
	{
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/HTML");
		response.setCharacterEncoding("UTF-8");
		
		String choix = request.getParameter("radioArticle");
		
		StringBuffer htmltext = new StringBuffer() ;
		htmltext.append("<html>");
		htmltext.append("<head>");
		htmltext.append("<title>");
		htmltext.append(" Affichage choix utilisateur  ");
		htmltext.append("</title>");
		htmltext.append("</head>");
		htmltext.append("<body>");
		htmltext.append("Vous avez choisie : "+choix);
		htmltext.append("</body>");
		htmltext.append("</html>");
		out.println(htmltext);
		
	}
	
	
}
