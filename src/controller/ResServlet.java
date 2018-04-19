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
		HttpSession session = request.getSession(false);
		if(session.getAttribute("user")==null) {
		      response.sendRedirect("index.jsp");
	    }else {
		String book = request.getParameter("book");
		
		Reservation reservation = new Reservation();
		reservation.setBook(book);
		reservation.load();
		reservation.search();
		
		request.setAttribute("book", reservation);
		
		session.setAttribute("res",reservation);
		RequestDispatcher dispatcher;
		dispatcher=getServletContext().getRequestDispatcher("/books.jsp");
		dispatcher.include(request, response);
	}
	}

	 public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		 HttpSession session = request.getSession();
		 
		 if(session.getAttribute("user")==null) {
		      response.sendRedirect("index.jsp");
	    }else {
	    	Reservation reservation = (Reservation) session.getAttribute("res");
			 reservation.book();
	    	
	    	request.setAttribute("res", reservation);
			
			RequestDispatcher dispatcher;
			if(reservation.getIsBooked()) {
				dispatcher=getServletContext().getRequestDispatcher("/WEB-INF/confirmation.jsp");
			}else {
				dispatcher=getServletContext().getRequestDispatcher("/WEB-INF/confirmation2.jsp");
			}
			
			dispatcher.include(request, response);
	    	
	    }
		 
	 }

	
}
