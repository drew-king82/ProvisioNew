<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
                    <td><input type="text" class="text_input" name="password" /></td>
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