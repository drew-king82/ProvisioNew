<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Welcome to the Proviso Portal</title>
    <link rel=stylesheet href="../css/site.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link href="https://fonts.googleapis.com/css2?family=Assistant:wght@200;300;400;500;600&display=swap" rel="stylesheet">
</head>


<body>


<div id="site">
	<div id="container">
<jsp:include page="./TopNav.jsp"></jsp:include>

<div>
    <div id="logo"><img src="../images/proviso1.png" /></div>

    <p>

    </p>
    <div>
        <table>
            <form>
             <input type="hidden" name="action" value="login" /> 
                <tr>
                    <td>User Name:</td>
                    <td><input type="text" class="text_input" name="user" /></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" class="text_input" name="password" /></td>
                </tr>
                <tr>
                    <td><input type=submit value=submit /></td>
                    <td><input type=reset value=clear /></td>
                </tr>
                <tr>
                    <td colspan=100%>
                        Not a Member? Join Today!
                    </td>
                </tr>
                <br />


            </form>
        </table>

    </div>



</div>

<jsp:include page="./Footer.jsp"></jsp:include>
</html>
<jsp:include page="./Footer.jsp"></jsp:include>
</div>
</div>
</div>
</body>
</html>