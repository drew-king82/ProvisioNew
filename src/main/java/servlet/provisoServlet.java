package servlet;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;

import beans.Customer;
import beans.Reservation;
import model.JdbcCustomerDao;
import model.JdbcReservationDao;


/**
 * Servlet implementation class proviso
 */
@WebServlet("/Proviso/*")
public class provisoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public provisoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
		      HttpServletResponse response) throws ServletException, IOException {
		    String base = "/jsp/";
		    String url = base + "index.jsp";
		    String action = request.getParameter("action");

		    System.out.println("Action value from the doPost method: " + action);
            System.out.println("URL value from the doPost method: " + url);
		    
		    if (action != null) {
		        switch (action) {
		        //if user clicks on the "create an account" button, it will take
		        //them to the customer.jsp which will house the form for 
		        //creating a new user
		        case "newCustomer":
			        url = base + "customer.jsp";
			        break;
			    //once the user clicks "submit" on the cutomer.jsp, the 
			    //user will be created, and redirected to the login page
		        case "createCustomer":
		        	createCustomer(request,response);
		        	HttpSession session = request.getSession(true);
		        	url = base + "login.jsp";
		        	break;
		        //once the user clicks "login" on the welcome page, the login 
		        //will get validated, and redirected to the booking page if the 
		        //login is successful, or to the login error page if not
		        case "login":
		        	url = base + login(request,response);
		        	break;
		        //if user clicks on a new reservation button, the booking page is
		        //displayed
		        case "reservation":
		        	url = base + "booking.jsp";
		        	break;
		        //if user clicks submit on booking page, the reservation is created
		        //and the user is redirected to the booking confirmation page
		        case "createReservation":
		        	createReservation(request,response);
		        	url = base + "confirmation.jsp";
		        	break;
		        //about us page
		        //Find reservation Page - should be a basic form that queries by customer ID
		        case "reservationSearch":
		        	url = base + "search.jsp";
		        	break;
		        //This is the function that is called when the find reservation form is submitted
		        //It will return the view reservations page, which should be capable of showing
		        //a number of reservations by customer id
		        case "reservationReturn":
		        	findReservation(request, response);
		        	getPoints(request, response);
		        	url = base + "lookup.jsp";
		        	break;
		        //search loyalty points by customer id using form
		        case "loyaltySearch":
		        	url = base + "loyalty.jsp";
		        	break;
		        //return loyalty points along with historical reservations
		        case "points":
		        	getPoints(request, response);
		        	url = base + "points.jsp";
		        	break;
		        case "about":
		        	url = base + "about.jsp";
		        	break;
		        //contact page
		        case "contact":
		        	url = base + "contact.jsp";
		        	break;
		        case "loginPage":
		        	url = base + "login.jsp";
		        	break;
		        }
 
	}
			    RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);

				requestDispatcher.forward(request, response);  
	}
	
	private String login(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		//define fields, may need to be updated based on what we decide for fields
		
		String user=request.getParameter("name");	
		//Need to update to not use plaintext password
		String password=request.getParameter("password");
		
		//create new JdbcCustomerDao object
		JdbcCustomerDao loginJAD=new JdbcCustomerDao();
		int userId= loginJAD.findId(user);
		
		//call JdbcCustomerDao add method, passing Customer object as parameter
		boolean isValidUser = loginJAD.login(user, password);
		
		if (isValidUser == true) {
			HttpSession session = request.getSession(false);
			session.setAttribute("id", userId);
			return "booking.jsp";
		} else {
			return "loginError.jsp";
		}
		
		}
	
	private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		//define fields, may need to be updated based on what we decide for fields
		
		String email=  request.getParameter("email");
		String firstname= request.getParameter("fname");
		String lastname= request.getParameter("lname");	
		//Need to update to not use plaintext password
		String password= request.getParameter("password");
		
		//create new JdbcCustomerDao object
		JdbcCustomerDao createJAD=new JdbcCustomerDao();
		
		//Create a new Customer object, using defined fields
		Customer addCustomer= new Customer(email, firstname, lastname, password);
				
		//call JdbcCustomerDao add method, passing Customer object as parameter
		createJAD.create(addCustomer);
		
		//Print result to user
		System.out.println("The new customer has been added.");
		}
	
	private void createReservation(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		//define fields, may need to be updated based on what we decide for fields
		int wifi = 0;
		int breakfast = 0;
		int parking = 0;
		int cost = 0;
		String email = request.getParameter("email");
	
		//roomsize wifi breakfast parking guests checkin checkout
		String roomSize =request.getParameter("roomSize");
		if (request.getParameter("wifi") == "wifi") {
			 wifi = 1;
		}
		if (request.getParameter("breakfast") == "breakfast") {
			 breakfast = 1;
		}
		if (request.getParameter("parking") == "parking") {
			 parking = 1;
		}
		int guests = Integer.valueOf(request.getParameter("guests"));
		String checkIn = request.getParameter("checkIn");
		
		
		String checkOut = request.getParameter("checkOut");
		
		int numberNights = Integer.valueOf(request.getParameter("nights"));
		
		//create new JdbcCustomerDao object
		JdbcReservationDao createJR=new JdbcReservationDao();
		JdbcCustomerDao newCustomer = new JdbcCustomerDao();
		int customerId =  newCustomer.findId(email);
		
		//Create a new Customer object, using defined fields
		Reservation addReservation= new Reservation(customerId, roomSize, wifi, breakfast, parking, guests, checkIn, checkOut, numberNights, cost);
				
		//call JdbcCustomerDao add method, passing Customer object as parameter
		createJR.create(addReservation);
		
		//Print result to user
		System.out.println("The reservation has been created.");
		}
	
	private List<Reservation> findReservation(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		String email = request.getParameter("email");
		
		JdbcCustomerDao newCustomer = new JdbcCustomerDao();
		int customerId =  newCustomer.findId(email);
		
		JdbcReservationDao findJR = new JdbcReservationDao();
		
		List<Reservation> reservations = findJR.findReservations(customerId);

		return reservations;
	}
	
	private int getPoints(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		HttpSession session=request.getSession(false);
		Integer customerId=(Integer)session.getAttribute("id");
		
		JdbcReservationDao findPoints = new JdbcReservationDao();
		
		int points = findPoints.getPoints(customerId);
		
		return points;
	}
}