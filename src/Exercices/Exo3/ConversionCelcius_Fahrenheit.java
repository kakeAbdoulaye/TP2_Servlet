package Exercices.Exo3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConversionCelcius_Fahrenheit extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6435705259338397564L;

	
	public void doGet(HttpServletRequest request  , HttpServletResponse response) throws IOException , ServletException
	{
		response.setContentType("text/Html");
		response.setCharacterEncoding("UTF-8");
		
		StringBuffer htmltext = new StringBuffer();
		PrintWriter out = response.getWriter();
		String Valeur = request.getParameter("nombreCelcius");
		int calculFahr = Integer.parseInt(Valeur)* 9/5 + 32;
		htmltext.append("<html>");
		htmltext.append("<head>");
		htmltext.append("<title>");
		htmltext.append(" Conversion de la valeur  "+Valeur+" en fahrenheit ");
		htmltext.append("</title>");
		htmltext.append("</head>");
		htmltext.append("<body>");
		htmltext.append(" En Fahrenheit  : "+calculFahr);
		htmltext.append("</body>");
		htmltext.append("</html>");
		out.println(htmltext);
		
		
	}
}
