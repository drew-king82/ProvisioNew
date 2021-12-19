<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <link rel=stylesheet href="../css/site.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link href="https://fonts.googleapis.com/css2?family=Assistant:wght@200;300;400;500;600&display=swap" rel="stylesheet">

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Booking Your Stay</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker({dateFormat: 'yy-mm-dd'});
  } );
  $( function() {
	    $( "#datepicker2" ).datepicker({dateFormat: 'yy-mm-dd'});
	  } );
  </script>



</head>

<body>
<div id="site">
<jsp:include page="./TopNav.jsp"></jsp:include>
	<div id="container">
		    <img src="../images/proviso1_transp.png" class="logo logo-50" />
	<h2>Get Ready for a Great Stay!</h2>
	<script type="text/javascript">
		var beds = document.bookingForm.roomSize;
		var size  = document.getElementById("bedSize");
		var event = new Event('change');
	
		for(var i=0; i<beds.length; i++) beds[i].addEventListener('change', changebedSize, false);
	
		beds[0].dispatchEvent(event);
	
		function changebedSize() {
		  var img = document.createElement('img');
		  img.src= "../images/"+ this.dataset.img;
		  size.innerHTML = "";
		  size.appendChild( img );
		}
		
	</script>
	<h3>-><a href="Proviso?action=reservationSearch">Review Current Reservations</a><-</h3>
	<form name="bookingForm" >
	<input type="hidden" name="action" value="createReservation" /> 
	<table class="table-600 table-border">
		<tr class="row-space">
			<td>
				Email: 
				</td>
			<td>
				<input type="text" name="email" class="input-text input-m">
			</td>
		</tr>
	
		<tr class="row-space">

			<td>Start of Stay: 
			</td>
			
			
			<td>
			<input type="text" id="datepicker" name="checkIn"  class="input-text input-m">
			</td>
		</tr>
		<!-- Divide table rows -->
		<tr class="row-space">
			<td>End of Stay:
			</td>
			
			
			<td><input type="text" id="datepicker2" name="checkOut"  class="input-text input-m" >
			</td>
			</tr>
			<tr>
			<td>
			
			Number of Nights: </td>
			<td><input type="text" name="nights"  class="input-text input-s"></td>
			
			</tr>
			
		<tr class="tr">
		<!-- Divide table rows -->		
		<tr class="row-space">
			<td class="td-l">
				Room Size:
			</td>
			<td>
		        <input data-img="double.png" type="radio" name="roomSize" value="1"> Double <br>
		        <input data-img="queen_1.png" type="radio" name="roomSize" value="2" > Queen <br>
		        <input data-img="queen_2.png" type="radio" name="roomSize" value="3" >Two Queens <br>
		        <input data-img="king.png" type="radio" name="roomSize" value="4"> King <br></td>
		      <td><p><div id="bedSize">&nbsp;</div></p></td>

		</tr>
		<!-- Divide table rows -->
		<tr class="row-space">
			<td>
			<br />
			Included Amenities:
			</td>
			
			<td>
			<br />
				<input type="checkbox" id="wifi" name="wifi" value="wifi"> &nbsp; Wifi: ($12.99 - Flat Rate)<br />
				<input type="checkbox" id="parking" name="parking" value="parking"> &nbsp; Parking: ($19.99 Per Night)<br />
				<input type="checkbox" id="breakfast" name="breakfast" value="breakfast"> &nbsp; Breakfast: ($8.99 per Night)
			</td>
		</tr>
		<!-- Divide table rows -->
		<tr class="row-space">
			<td>
			How Many Guests:
			</td>
			
			
			<td>
			<select name="guests" class="input-text td-c input-m">
				<option value="1">1-2 Guests</option>
				<option value="2">3-5 Guests</option>
			</select>
			</td>
		</tr>
		<tr class="row-space">
			<td class="td-c" colspan=100%>
				<input type=submit value="Book Vacation Now" class="button" />&nbsp;
                    <input type=reset value=Clear class="button" />
			</td>
		</tr>
	</table>
	</form>
	</div>

<jsp:include page="./Footer.jsp"></jsp:include>
</div>
   

</body>
</html>