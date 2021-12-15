package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Customer;
import beans.Reservation;
import model.JdbcCustomerDao;
import model.JdbcReservationDao;


/**
 * Servlet implementation class Provisio
 */
@WebServlet("/ProvisoNew/*")
public class provisioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public provisioServlet() {
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
		        //about us page
		        case "about":
		        	url = base + "about.jsp";
		        //contact page
		        case "contact":
		        	url = base + "contact.jsp";
		        //Find reservation Page - should be a basic form that queries by customer ID
		        case "reservationSearch":
		        	url = base + "search.jsp";
		        //This is the function that is called when the find reservation form is submitted
		        //It will return the view reservations page, which should be capable of showing
		        //a number of reservations by customer id
		        case "reservationReturn":
		        	findReservation(request, response);
		        	url = base + "lookup.jsp";
		        //search loyalty points by customer id using form
		        case "loyaltySearch":
		        	url = base + "loyalty.jsp";
		        //return loyalty points along with historical reservations
		        case "points":
		        	getPoints(request, response);
		        	url = base + "points.jsp";
		        }
		        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);

				requestDispatcher.forward(request, response);   
	}
	}
	
	private String login(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		//define fields, may need to be updated based on what we decide for fields
		
		String user=request.getParameter("user");	
		//Need to update to not use plaintext password
		String password=request.getParameter("password");
		
		//create new JdbcCustomerDao object
		JdbcCustomerDao loginJAD=new JdbcCustomerDao();
				
		//call JdbcCustomerDao add method, passing Customer object as parameter
		boolean isValidUser = loginJAD.login(user, password);
		
		if (isValidUser == true) {
			return "booking.jsp";
		} else {
			return "loginError.jsp";
		}
		
		}
	
	private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		//define fields, may need to be updated based on what we decide for fields
		
		String email=  request.getParameter("email");
		String firstname= request.getParameter("firstname");
		String lastname= request.getParameter("lastname");	
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
		boolean wifi = false;
		boolean breakfast = false;
		boolean parking = false;
		
		int customerId = Integer.valueOf(request.getParameter("customerId"));
		//roomsize wifi breakfast parking guests checkin checkout
		int roomSize = Integer.valueOf(request.getParameter("roomSize"));
		if (request.getParameter("wifi") == "true") {
			 wifi = true;
		}
		if (request.getParameter("breakfast") == "true") {
			 breakfast = true;
		}
		if (request.getParameter("parking") == "true") {
			 parking = true;
		}
		int guests = Integer.valueOf(request.getParameter("guests"));
		String checkIn = request.getParameter("checkIn");
		String checkOut = request.getParameter("checkOut");
		int numberNights = Integer.valueOf(request.getParameter("numberNights"));
		
		//create new JdbcCustomerDao object
		JdbcReservationDao createJR=new JdbcReservationDao();
		
		//Create a new Customer object, using defined fields
		Reservation addReservation= new Reservation(customerId, roomSize, wifi, breakfast, parking, guests, checkIn, checkOut, numberNights);
				
		//call JdbcCustomerDao add method, passing Customer object as parameter
		createJR.create(addReservation);
		
		//Print result to user
		System.out.println("The reservation has been created.");
		}
	
	private List<Reservation> findReservation(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		int customerId = Integer.valueOf(request.getParameter("customerId"));
		
		JdbcReservationDao findJR = new JdbcReservationDao();
		
		List<Reservation> reservations = findJR.findReservations(customerId);

		return reservations;
	}
	
	private int getPoints(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		int customerId = Integer.valueOf(request.getParameter("customerId"));
		
		JdbcReservationDao findPoints = new JdbcReservationDao();
		
		int points = findPoints.getPoints(customerId);
		
		return points;
	}
}