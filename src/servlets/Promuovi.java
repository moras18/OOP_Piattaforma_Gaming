package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import frontcontroller.Controller;
import model.dao.UtenteDAO;
import util.Database;
import util.FreeMarker;
import util.SecurityLayer;

/**
 * Servlet implementation class Promuovi
 */
@WebServlet("/Promuovi")
public class Promuovi extends HttpServlet implements Controller{
	private static final long serialVersionUID = 1L;
	Map<String, Object> data= new HashMap<String, Object>();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Promuovi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession s = SecurityLayer.checkSession(request);
		int gruppo=UtenteDAO.checkGroup((int) s.getAttribute("userid"));
		System.out.println(gruppo + "AAAAAAAAAAAAAAAAA");
		data.put("promozione", UtenteDAO.Promo(gruppo));
		data.put("gruppol", gruppo);
		FreeMarker.process("promuovi.html", data, response, getServletContext());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession s = SecurityLayer.checkSession(request);
		String decisione=request.getParameter("decisione");
		int idu=Integer.parseInt(request.getParameter("id"));
	try {
		UtenteDAO.Promozione(idu, decisione);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	doGet(request,response);	
	}

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
