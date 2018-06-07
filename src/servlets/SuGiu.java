package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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
 * Servlet implementation class SuGiu
 */
@WebServlet("/SuGiu")
public class SuGiu extends HttpServlet implements Controller {
	private static final long serialVersionUID = 1L;
	Map<String, Object> data= new HashMap<String, Object>();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuGiu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FreeMarker.process("sugiu.html", data, response, getServletContext());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession s = SecurityLayer.checkSession(request);
		int userid=(int) s.getAttribute("userid");
		int esperienza=0;
		
		try {
			Database.connect();
			ResultSet a=Database.selectRecord("utente", "utente.id=" + userid);
			while(a.next()){
				 esperienza=a.getInt("esperienza");
			}
			if(esperienza<500){
			UtenteDAO.aggExp(userid);}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String giocata=request.getParameter("gioca");
		Random random = new Random();
		int numero = random.nextInt(9);
		data.put("casuale", numero);
		if(giocata.equals("su") && numero>4){
			data.put("messaggio", "hai vinto");
		} else if(giocata.equals("giu") && numero<5){
			data.put("messaggio", "hai vinto");
		} else {
			data.put("messaggio", "hai perso");
		} 
		FreeMarker.process("sugiu.html", data, response, getServletContext());
	}

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
