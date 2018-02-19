package Exercices.Exo1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
kake Abdoulaye de chez chef kake , un clone vient de modifier bebe*/


public class Heure_Date extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4265865692246539056L;

	public void service(HttpServletRequest request , HttpServletResponse response) throws IOException , ServletException
	{
		Date aujourdhui = new Date();
		DateFormat format = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL, new Locale("FR", "eu"));
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/HTML");
		response.setCharacterEncoding("UTF-8");
		StringBuffer htmltext = new StringBuffer() ;
		htmltext.append("<html>");
		htmltext.append("<head>");
		htmltext.append("<title>");
		htmltext.append(" Affichage de la date et de l'heure ");
		htmltext.append("</title>");
		htmltext.append("</head>");
		htmltext.append("<body>");
		htmltext.append(format.format(aujourdhui));
		htmltext.append("</body>");
		htmltext.append("</html>");
		out.println(htmltext);
		
		
	}
}
