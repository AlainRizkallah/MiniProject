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
import model.Reservation;

@WebServlet("/ResServlet")
public class ResServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String book = request.getParameter("book");
		Reservation res = new Reservation();
		res.setBook(book);
		res.load();
		res.search();
		request.setAttribute("book", res);
		HttpSession s=request.getSession(true);
		s.setAttribute("res",res);
		RequestDispatcher dispatcher;
		dispatcher=getServletContext().getRequestDispatcher("/books.jsp");
		dispatcher.include(request, response);
	}

	 public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		 HttpSession session = request.getSession();
		 if(session.getAttribute("user")==null) {
		      response.sendRedirect("index.jsp");
	    }
		 
	 }

	
}
