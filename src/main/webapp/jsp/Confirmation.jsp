<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <link rel=stylesheet href="../css/site.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link href="https://fonts.googleapis.com/css2?family=Assistant:wght@200;300;400;500;600&display=swap" rel="stylesheet">

<title>We've got your trip!</title>
</head>
<body>
<div id="site">
<jsp:include page="./TopNav.jsp"></jsp:include>
	<div id="container">
	<br />
	<table class="table-400">
		<tr>
			<td>
				<h2>THANK YOU!</h2> <br />
				Your trip has been booked! <br />
				Please go to the <a href="Proviso?action=reservationReturn">Reservations page</a> to view your trips.
			</td>	
		</tr>
	</table>


<jsp:include page="./Footer.jsp"></jsp:include>
</div>
</body>
</html>
	
	
</body>
</html>