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
import model.Gioco;
import model.dao.CommentiDAO;
import model.dao.GiochiDAO;
import util.Database;
import util.FreeMarker;
import util.SecurityLayer;

/**
 * Servlet implementation class Dettagli
 */
@WebServlet("/Dettagli")
public class Dettagli extends HttpServlet implements Controller {
	private static final long serialVersionUID = 1L;
	Map data= new HashMap<String, Object>();  
	int id=0;
    /**
     * @see HttpServlet#HttpServlet()
     */
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession s = SecurityLayer.checkSession(request);
		
		id=Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		
	data.put("dettagli", GiochiDAO.dettGioco(id));
	data.put("commenti", CommentiDAO.Comment(id));
	try {
		data.put("media", CommentiDAO.Media(id));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		FreeMarker.process("dettagli.html", data, response, getServletContext());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession s = SecurityLayer.checkSession(request);
		
		System.out.println(id + "COMMENTO");
		int voto=Integer.parseInt(request.getParameter("inlineRadioOptions"));
		String testo=request.getParameter("testo");
		String titolo=request.getParameter("titolo");
		
		int userid=(int) s.getAttribute("userid");
		System.out.println(userid + "USERIDDDDDD");
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("titolo", titolo);
		map.put("testo", testo);
		map.put("idutente", userid);
		map.put("idgioco", id);
		map.put("valutazione", voto);
		map.put("approvato", 0);
		try {
			Database.connect();
			Database.insertRecord("commenti", map);
			Database.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("dettagli?id=" +id);	
	}

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
