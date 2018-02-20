package Exercices.Exo7;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig 
public class PageWebImage extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9106517198161017349L;

	
	public void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException , IOException
	{
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		final String path = "/ss";
		final Part filepart = request.getPart("selectedImage");
		//final String filename =getFileName(filepart);
		System.out.println(filepart);
		
	}
}
