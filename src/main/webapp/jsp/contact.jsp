<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <link rel=stylesheet href="../css/site.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link href="https://fonts.googleapis.com/css2?family=Assistant:wght@200;300;400;500;600&display=swap" rel="stylesheet">

<title>Contact Us!</title>

</head>

<body>
<div id="site">
<jsp:include page="./TopNav.jsp"></jsp:include>
	<div id="container">
		<p>
		&nbsp;
		</p>
		<table class="table-600 table-border">
			<tr><td colspan=100%  class="td-c"><h2>Welcome to the contact page.</h2></td></tr>
			<tr>
				<td>
					<div class="round-box">
					<br />
					<p>&nbsp;<a href="https://bellevue.edu">Bellevue University</a><br />
					&nbsp;1000 Galvin Road South<br />
					&nbsp;Bellevue, Nebraska 68005</p>
					</div>
				</td>
				<td>
					<div class="round-box">
					<br />
						<ul>
						<li>Direct:<a href="tel:402-293-2000">402.293.2000</a></li>
						<li>Toll-free:<a href="tel:800-555-5555">1.800.555.5555</li>
						<li>Fax: 555.555.5555</li>
						</ul>
					</div>
				</td>
			</tr>		
		
		</table>
	</div>

<jsp:include page="./Footer.jsp"></jsp:include>
</div>
</body>
</html>