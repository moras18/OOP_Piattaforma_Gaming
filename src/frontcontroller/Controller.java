package frontcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	
	 public String action(HttpServletRequest request, HttpServletResponse response);

}
