package frontcontroller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlets.Approva;
import servlets.Dettagli;
import servlets.Home;
import servlets.Ini;
import servlets.Profilo;
import servlets.Promuovi;
import servlets.RegModeratore;
import servlets.Registrati;
import servlets.SuGiu;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Controller> controllers = new HashMap<String, Controller>(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
 
	@Override
	public void init() throws ServletException {
	  super.init();
	  controllers.put("index.html", new Home());
	  controllers.put("approva.html", new Approva());
	  controllers.put("dettagli.html", new Dettagli());
	  controllers.put("profilo.html", new Profilo());
	  controllers.put("promuovi.html", new Promuovi());
	  controllers.put("registrati.html", new Registrati());
	  controllers.put("regmod.html", new RegModeratore());
	  controllers.put("sugiu.html", new SuGiu());
	  controllers.put("home.html", new Ini());
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		internalExecute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		internalExecute(request, response);
	}
	
	
	private void internalExecute(HttpServletRequest req, HttpServletResponse resp)
		      throws ServletException, IOException {
		    // attenzione: nessun controllo degli errori!
		    String uri = req.getRequestURI();
		    System.out.println(uri +" CI PASSI, DIMMI DI SI!!!!!");
		    if(!uri.equals("/Gaming/")){
		   
		    // 1 - ricava il nome del Controller a partire dalla URI specificata
		    Pattern pat = Pattern.compile(req.getContextPath() + "/(.*)");
		    System.out.println(pat +" CI PASSI, DIMMI DI SI!!!!!");
		    String controllerName = pat.matcher(uri).group(1);
		    // 2 - carica l'implementazione del Controller
		    Controller c = controllers.get(controllerName);
		    // 3 - esegui il controller
		    String outcome = c.action(req, resp);
		    // 4 - mostra la view specificata
		    req.getRequestDispatcher(outcome).forward(req, resp);}
		    else{
		    resp.sendRedirect("Home");}
		  }
	


}
