<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <link rel=stylesheet href="../css/site.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link href="https://fonts.googleapis.com/css2?family=Assistant:wght@200;300;400;500;600&display=swap" rel="stylesheet">

<title>Oops! Something went wrong!</title>

</head>

<body>
<div id="site">
<jsp:include page="./TopNav.jsp"></jsp:include>
	<div id="container">
		 <img src="../images/proviso1_transp.png" class="logo" />
		 
		<div>
		<h3>It looks like your login information was incorrect. <br /> Please <a href="Proviso?action=createCustomer">LogIn</a> again.</h3>
			 <img src="../images/404-error-gaf25dcae5_640.png" class="picture picture-200-square" />
		</div>
	
	</div>

<jsp:include page="./Footer.jsp"></jsp:include>
</div>
</body>
</html>