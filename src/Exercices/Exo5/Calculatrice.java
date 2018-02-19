package Exercices.Exo5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Calculatrice extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 626483011046140L;
	
	public synchronized void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException 
	{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter() ;
		StringBuffer htmltext = new StringBuffer();
		
		
		String strvaleur1 = request.getParameter("valeur1");
		String strvaleur2 = request.getParameter("valeur2");
		String strop = request.getParameter("operateur");
		
		htmltext.append("<html>");
		htmltext.append("<head>");
		htmltext.append("<title>");
		htmltext.append(" Calculatrice 1.0 ");
		htmltext.append("</title>");
		htmltext.append("</head>");
		htmltext.append("<body>");
		
		if(strvaleur1 != null && strvaleur2 != null && strop != null)
		{
			htmltext.append("<i>le resultat de votre operation "+strvaleur1);
			
			if(strop.equals("op+")) 
			{
				htmltext.append(" +  "+strvaleur2+" :  </i>");
				htmltext.append(Double.parseDouble(strvaleur1)+Double.parseDouble(strvaleur2));
			}
			if(strop.equals("op-")) 
			{
				htmltext.append(" -  "+strvaleur2+" :  </i>");
				htmltext.append(Double.parseDouble(strvaleur1)-Double.parseDouble(strvaleur2));
			}
			if(strop.equals("op*")) 
			{
				htmltext.append(" *  "+strvaleur2+" :  </i>");
				htmltext.append(Double.parseDouble(strvaleur1)*Double.parseDouble(strvaleur2));
			}
			if(strop.equals("op/")) 
			{
				htmltext.append(" /  "+strvaleur2+" :  </i>");
				htmltext.append(Double.parseDouble(strvaleur1)/Double.parseDouble(strvaleur2));
			}
			if(strop.equals("op%")) 
			{
				htmltext.append(" %  "+strvaleur2+" :  </i>");
				htmltext.append(Double.parseDouble(strvaleur1)%Double.parseDouble(strvaleur2));
			}
		}
		else
		{
			htmltext.append("Veillez entrer et chosir des nombre , operateur . Merci !");
		}
		htmltext.append("</body>");
		htmltext.append("</html>");
		out.println(htmltext);
	}

}
