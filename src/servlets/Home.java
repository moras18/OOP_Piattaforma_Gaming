package servlets;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import frontcontroller.Controller;
import model.Gioco;
import model.dao.GiochiDAO;
import model.dao.UtenteDAO;
import util.DataUtil;
import util.Database;
import util.FreeMarker;
import util.SecurityLayer;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet implements Controller {
	private static final long serialVersionUID = 1L;
	Map data= new HashMap();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		  
		data = new HashMap<String, Object>();
    	
   		 FreeMarker.process("index.html", data, response, getServletContext());
   		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FreeMarker.process("index.html", data, response, getServletContext());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession s = SecurityLayer.checkSession(request);
		
		  String email = request.getParameter("email");
          String pass = request.getParameter("pass");
          System.out.println(pass);
          
          int userid=0;
          
          try {
        	  Database.connect();
			userid=DataUtil.checkUser(email,pass);
			
			s.setAttribute("userid", userid);
			Database.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          if(userid==0){
        	 FreeMarker.process("index.html", data, response, getServletContext()); 
          } else{
        	  int group=UtenteDAO.checkGroup(userid);
        	  System.out.println(group + "gruppo di appartenenza");
        	  System.out.println(userid);
        	  
        	  SecurityLayer.createSession(request, email , userid);
        	  
        	  if(group==3 || group==2){
        		  System.out.println("ENTRIIIII QUAAAA");
        		  //FreeMarker.process("profilo.html", data, response, getServletContext());
        		  response.sendRedirect("Approva");
        	  } else{
        	  
        	  List<Gioco> lista=new ArrayList<Gioco>();
      		try {
      			lista=GiochiDAO.returnListaGiochi();
      			System.out.println(lista);
      		} catch (Exception e) {
      			// TODO Auto-generated catch block
      			e.printStackTrace();
      		}
      		data.put("lista", lista);
      		
        	  FreeMarker.process("home.html", data, response, getServletContext());}
          }
	}
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
