package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import frontcontroller.Controller;
import model.dao.UtenteDAO;
import util.FreeMarker;
import util.DataUtil;
import util.Database;

/**
 * Servlet implementation class Registrati
 */
@WebServlet("/Registrati")
public class Registrati extends HttpServlet implements Controller {
	private static final long serialVersionUID = 1L;

	Map data= new HashMap<String, Object>();	
	
	
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
    	
		FreeMarker.process("registrati.html", data, response, getServletContext());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String email=request.getParameter("email");
		String password=request.getParameter("pass");
		String nome=request.getParameter("nome");
		String cognome=request.getParameter("cognome");
		int esperienza=0;
		int gruppo=1;
		UtenteDAO.Registrazione(email,password,nome,cognome,esperienza,gruppo);
		
			FreeMarker.process("index.html", data, response, getServletContext());
		}

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}
			
	
}


