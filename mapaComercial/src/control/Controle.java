package control;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import entity.Cliente;
import persistence.ClienteDao;

@WebServlet("/Controle")
public class Controle extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String path;
	
	private File file;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String cmd = request.getParameter("cmd");
		
		if (cmd.equalsIgnoreCase("sair")) {
			LerCliente(request, response);
			}
			
	}

	public void LerCliente(HttpServletRequest request, HttpServletResponse response) {
		

		  
			  try {
				
					  
				ServletContext context = request.getServletContext();
				path = context.getRealPath("/");
				
		
				// Cria arquivo
				file = new File(path + "Output.json");

				// Se o arquivo nao existir, ele gera
				if (!file.exists()) {
					file.createNewFile();
				}

				Writer writer = new FileWriter(file);

				Gson gson = new GsonBuilder().create();
				
						  
				List<Cliente> reg3 = new ClienteDao().findAll();
								
				gson.toJson(reg3, writer);

				writer.close();
				
			  } catch (Exception e) {
					// TODO: handle exception
				}			
	
	}
	

}
