package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Authentication;

@WebServlet("/AuthServlet")
public class AuthServlet extends HttpServlet {
	
	public static final String UserName        = "userName";
    public static final String PassWord         = "passWord";

   
	private static final long serialVersionUID = 1L;
       
   
    public AuthServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	 public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		 String type=request.getParameter("type");
		 if(type.equals("form1")) {
		 
	    	
	    	Authentication authentication = new Authentication(request.getParameter("uname"),request.getParameter("pword"));
	 
	    	if (authentication.getUsername().equals("aaa")) {
	    		/* Création ou récupération de la session */
	    		HttpSession session = request.getSession();

	    		session.setAttribute( "user", authentication );
	    		RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/WEB-INF/welcome.jsp");
	    		dispatcher.include(request, response);
	    	}else {
	    		RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/WEB-INF/error.jsp");
		    	dispatcher.include(request, response);
	    	}
		 }
		 if(type.equals("form2")) {
			 HttpSession session = request.getSession(false);
			 session.removeAttribute("user");
			 if(session != null)
			     session.invalidate();
			 
			 request.getRequestDispatcher("/WEB-INF/goodbye.jsp").forward(request,response);
			 
		 }
	    }

}
