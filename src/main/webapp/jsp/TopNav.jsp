<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<div class="navBar">
<!-- TODO update booking/reservation - need to redirect to login page before reserving.  about and contact pages not resolving -->
    <div class="navBar">
        <div class="navButton">
            <a href="Proviso" class="nav_link">Home</a>
        </div>
        <div class="navButton">
            <a href="Proviso?action=newCustomer" class="nav_link">Member Login</a>
        </div>
        <div class="navButton">
            <a href="Proviso?action=reservation" class="nav_link">My Reservation</a>
        </div>
        <div class="navButton">
            <a href="Proviso?action=about" class="nav_link">About Us</a>
        </div>
        <div class="navButton">
            <a href="Proviso?action=contact" class="nav_link">Contact Us</a>
        </div>
    </div>
    </div>
</body>
</html>