package Exercices.Exo4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyBlog extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8259703765585301708L;

	
	public void doPost(HttpServletRequest request  , HttpServletResponse response) throws IOException , ServletException
	{
		response.setContentType("text/Html");
		response.setCharacterEncoding("UTF-8");
		
		StringBuffer htmltext = new StringBuffer();
		PrintWriter out = response.getWriter();
		String tnom = request.getParameter("nomUser");
		String tpassword = request.getParameter("passUser");
		
		
		htmltext.append("<html>");
		htmltext.append("<head>");
		htmltext.append("<title>");
		htmltext.append(" MyBlog.fr");
		htmltext.append("</title>");
		htmltext.append("</head>");
		htmltext.append("<body>");
		if(tnom.equals(this.getInitParameter("nomUser")) && tpassword.equals(this.getInitParameter("passUser")))
		{
			htmltext.append(" Vous êtes connectés Mr "+tnom);
		}
		else
		{
			htmltext.append(" Identifiant ou mot de passe incorrecte ");
		}
		htmltext.append("</body>");
		htmltext.append("</html>");
		out.println(htmltext);
		
		
	}
}
