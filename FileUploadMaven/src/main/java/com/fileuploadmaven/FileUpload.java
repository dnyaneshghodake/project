package com.fileuploadmaven;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUpload extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		try
		{
			ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
			List<FileItem> multiFiles = sf.parseRequest(request);
			
			for(FileItem item : multiFiles)
			{
				item.write(new File("C:/Users/dnyaneshwar.ghodake/Desktop/Stuff/fileupload/" + item.getName()));
			}
			
			System.out.println("Files uploaded...");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
