<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <link rel=stylesheet href="../css/site.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link href="https://fonts.googleapis.com/css2?family=Assistant:wght@200;300;400;500;600&display=swap" rel="stylesheet">
<jsp:useBean id="ReservationDao" scope="application" class="model.JdbcReservationDao" />
<jsp:useBean id ="CustomerDao" scope="application" class="model.JdbcCustomerDao" />
<%@ page import="beans.Reservation" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<title>These are your Upcoming and Past Reservations</title>
</head>
<body>
<div id="site">
<jsp:include page="./TopNav.jsp"></jsp:include>
	<div id="container">
	<br />
	<p>
	<h2>View your reservations</h2>
	</p>
	<table class="table-400">
		<tr>
			<td>
				Your current point balance is: <%
				Integer myName=(Integer)session.getAttribute("id");
				int points = ReservationDao.getPoints(myName);
				%><%=points %>
			</td>	
		</tr>
	</table>
	<table class="table-800 table-border">
		<tr>
			<td class="td-c">
				Reservation ID:
			</td>
			<td class="td-c">
				Room Size:
			</td>
			<td class="td-c">
				Amenities: 
			</td>
			<td class="td-c">
				CheckIn
			</td>
			<td class="td-c">
				Checkout
			</td>
			<td class="td-c">
				Length of Stay
			</td>
			<td class="td-c">
				Total Cost
			</td>																		
		</tr>
				<%-- begin iteration of reservation here --%>
				<%-- add cancel button --%>
		<tr>
		
		<%  
				List<Reservation> reservations=ReservationDao.findReservations(myName);
            	int counter=1;
            	Iterator<Reservation> iterator=reservations.iterator();
            	String amenities="";
            	while (iterator.hasNext()){
            		Reservation reservation=(Reservation)iterator.next();
            			%>

          		 	<td class = "td-c">
          		    <%
          		    if (reservation.getBreakfast() == 1){
          		    	amenities = amenities + " breakfast "+ "<br>";
          		    }
          		  	if (reservation.getWifi() == 1){
        		    	amenities = amenities + " wifi "+ "<br>";
        		    }
          		  	if (reservation.getParking() == 1){
        		    	amenities = amenities + " parking "+ "<br>";
        		    }
          		    reservation.getReservationId(); %></td><td class = "td-c">
                    <%=reservation.getRoomSize()%></td><td class = "td-c">
                    <%=amenities%></td><td class = "td-c">
                    <%=reservation.getCheckIn() %></td><td class = "td-c">
                    <%=reservation.getCheckOut() %></td><td class = "td-c">
                    <%=reservation.getNumberNights() %></td><td class = "td-c">
                    <%=reservation.getCost(reservation.getGuests(), reservation.getNumberNights(), reservation.getWifi(), reservation.getBreakfast(), reservation.getParking()) %></td><td>
					</tr>
				<% }%>	
	</table>
	
	</div>

<jsp:include page="./Footer.jsp"></jsp:include>
</div>
</body>
</html>
