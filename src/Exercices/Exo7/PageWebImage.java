package Exercices.Exo7;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageWebImage extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9106517198161017349L;

	
	public void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException , IOException
	{
		
		
		 response.setContentType("image/jpg");  
         ServletOutputStream out;  
         out = response.getOutputStream();  
         System.out.println(request.getParameter("selectedImage"));
         FileInputStream fin = new FileInputStream(request.getParameter("selectedImage"));  
         

         
           
         BufferedInputStream bin = new BufferedInputStream(fin);  
         BufferedOutputStream bout = new BufferedOutputStream(out);  
         int ch =0; ;  
         while((ch=bin.read())!=-1)  
         {  
         bout.write(ch);  
         }  
           
         bin.close();  
         fin.close();  
         bout.close();  
         out.close();  
          
		
	}
}
