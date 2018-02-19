package Exercices.Exo6;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoteEtudiant extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7502218628166760052L;
	
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter() ;
		StringBuffer htmltext = new StringBuffer();
		
		String url ="jdbc:mysql://localhost:3306/gestionsetudiants";
		String userName="root";
		String password="";
		
		
		// Prendre le driver 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			System.err.println("Le driver n'est pas trouver ");
			e.printStackTrace();
		}
		
		// Se connecter à la base de données 
		Connection connexion  = null;
		try {
			 connexion = DriverManager.getConnection(url, userName, password);
			 
			 /// Recuepration des données entrer par l'utilisateur
			 String insert = "insert into etudiants(Numero,Nom,Prenom,Note) values(?,?,?,?)";
			 PreparedStatement inserState = connexion.prepareStatement(insert);
			 inserState.setString(1,request.getParameter("numtext"));
			 inserState.setString(2,request.getParameter("nomtext"));
			 inserState.setString(3,request.getParameter("prenomtext"));
			 inserState.setInt(4, Integer.parseInt(request.getParameter("noteent")));
			 inserState.executeUpdate();
			 inserState.close();
			 
			 // Calculer la moyenne et afficher 
			 Statement moyenRequete = connexion.createStatement();
			 ResultSet moyenneNote = moyenRequete.executeQuery("Select AVG(Note) from etudiants;");
			 double moyenne = moyenneNote.getDouble(1);
			 htmltext.append("<html>");
			htmltext.append("<head>");
			htmltext.append("<title>");
			htmltext.append(" Moyenne des Notes des etudiants  ");
			htmltext.append("</title>");
			htmltext.append("</head>");
			htmltext.append("<body>");
			htmltext.append("La moyenne des notes des etudiants  : "+moyenne);
			htmltext.append("</body>");
			htmltext.append("</html>");
			out.println(htmltext);
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			 if ( connexion != null )
			        try {
			            /* Fermeture de la connexion */
			            connexion.close();
			        } catch ( SQLException ignore ) {
			            /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
			        }
		}
	}
	
	
	
	
	
	

}
