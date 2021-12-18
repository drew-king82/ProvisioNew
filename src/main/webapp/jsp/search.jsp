<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <link rel=stylesheet href="../css/site.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link href="https://fonts.googleapis.com/css2?family=Assistant:wght@200;300;400;500;600&display=swap" rel="stylesheet">

<title>Search for your Reservation to Proviso!</title>

</head>

<body>
<div id="site">
<jsp:include page="./TopNav.jsp"></jsp:include>
	<div id="container">
		<img src="../images/proviso1_transp.png" class="logo" />
		<form>
            <table class="table-500 table-border">
            <input type="hidden" name="action" value="reservationReturn" /> 
            	<tr>
                    <td colspan=100% class="td-c">
                        <h2>Reservation Search</h2>
                    </td>
                </tr>
                <tr>
                    <td class="td-l" colspan=30%>Last Name:</td>
                    <td class="td-c"><input type="text" class="input-text" name="lname" /></td>
                </tr>
                                <tr>
                    <td class="td-l" colspan=30%>Email:</td>
                    <td class="td-c"><input type="text" class="input-text" name="email" /></td>
                </tr>
                <td colspan=100% class="td-c">
                       &nbsp;
                    </td>
                <tr>
                <tr>
                    <td colspan=100% class="td-c">

                    <input type=submit value=Submit class="button" />&nbsp;
                    <input type=reset value=Clear class="button" />
                    <br />
                    <br />
                    </td>
                </tr>
             <br />
        </table>
	</form>
	
	</div>

<jsp:include page="./Footer.jsp"></jsp:include>
</div>
</body>
</html>