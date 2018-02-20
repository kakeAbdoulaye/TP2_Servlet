package Exercices.Exo7;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

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
		/*response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");*/
		
		final String path =getServletContext().getRealPath("/")+"newImage.jpg";
		System.out.println(path);
		final Part filepart = request.getPart("selectedImage");
		final String filename =getFileName(filepart);
		
		OutputStream out = null;
		InputStream filecontent = null ;
		PrintWriter writer = null;
		StringBuffer htmltext = new StringBuffer();
		
		try
		{
			writer = response.getWriter();
			
			out = new FileOutputStream(path);
			filecontent = filepart.getInputStream();
			
			int read = 0 ;
			byte [] bytes = new byte[1024];
			
			while((read = filecontent.read(bytes)) !=-1)
			{
				out.write(bytes,0,read);
			}
			
			htmltext.append("<html>");
			htmltext.append("<head>");
			htmltext.append("<title>");
			htmltext.append(" Moyenne des Notes des etudiants  ");
			htmltext.append("</title>");
			htmltext.append("</head>");
			htmltext.append("<body>");
		
			htmltext.append("L'image : ");
			htmltext.append("<img src=\""+path+"\"/>");
			htmltext.append("</body>");
			htmltext.append("</html>");
			writer.println(htmltext);
		
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
	        if (out != null) {
	            out.close();
	        }
	        if (filecontent != null) {
	            filecontent.close();
	        }
	        if (writer != null) {
	            writer.close();
	        }
	    }
		
	}
	
	private String getFileName(final Part part) {
	    for (String content :  part.getHeader("content-disposition").split(";")) {
	        if (content.trim().startsWith("filename")) {
	            return content.substring(
	                    content.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }
	    return null;
	}
}
