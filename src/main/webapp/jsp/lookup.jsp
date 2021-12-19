<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <link rel=stylesheet href="../css/site.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link href="https://fonts.googleapis.com/css2?family=Assistant:wght@200;300;400;500;600&display=swap" rel="stylesheet">

<title>These are your Upcoming and Past Reservations</title>
</head>
<body>
<div id="site">
<jsp:include page="./TopNav.jsp"></jsp:include>
	<div id="container">
	<br />
	<p>
	<h2>View, Edit and Cancel your reservations</h2>
	</p>
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
		
		<tr>
			<td class="td-c">
	
			</td>
			<td class="td-c">
	
			</td>
			<td class="td-c">

			</td>
			<td class="td-c">

			</td>
			<td class="td-c">

			</td>
			<td class="td-c">

			</td>
			<td class="td-c">

			</td>																		
		</tr>
		
		
	
	
	
	</table>
	
	</div>

<jsp:include page="./Footer.jsp"></jsp:include>
</div>
</body>
</html>
	
	
</body>
</html>