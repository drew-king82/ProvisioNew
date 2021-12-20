package beans;

import java.text.DecimalFormat;

//Some of this will need to be adjusted based on what fields we decide on for the database
public class Reservation {
 private int reservationId;
 private int customerId;
 private String roomSize;
 private int wifi;
 private int breakfast;
 private int parking;
 private int guests;
 private String checkIn;
 private String checkOut;
 private int numberNights;
 private double cost;
 private int loyalty;
 private DecimalFormat df = new DecimalFormat("#.##");
 
 public Reservation(int reservationId, int customerId, String roomSize, int wifi, int breakfast, int parking, int guests, String checkIn, String checkOut, int numberNights, int cost) {
	 	this.reservationId = reservationId;
		this.customerId = customerId;
		this.roomSize = roomSize;
		this.wifi = wifi;
		this.breakfast = breakfast;
		this.parking = parking;
		this.guests = guests;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.numberNights=numberNights;
		this.cost=getCost(guests, numberNights, wifi, breakfast, parking);
		this.loyalty=numberNights * 150;
	}

 public Reservation(int customerId, String roomSize, int wifi, int breakfast, int parking, int guests, String checkIn, String checkOut, int numberNights, int cost) {
		this.customerId = customerId;
		this.roomSize = roomSize;
		this.wifi = wifi;
		this.breakfast = breakfast;
		this.parking = parking;
		this.guests = guests;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.numberNights=numberNights;
		this.cost=Math.round(getCost(guests, numberNights, wifi, breakfast, parking)*100/100);
		this.loyalty=numberNights * 150;
	}
 
 	public void setReservationId(int reservationId) {
 		this.reservationId = reservationId;
 	}
 	public int getReservationId() {
 		return reservationId;
 	}
	public void setCustomerId(int customerId) {
		 this.customerId=customerId;
	 }
	 public int getCustomerId () {
		 return customerId;
	 }
	 public void setRoomSize(String roomSize) {
		 this.roomSize=roomSize;
	 }
	 public String getRoomSize() {
		 return roomSize;
	 }
	 public void setWifi(int wifi) {
		 this.wifi=wifi;
	 }
	 public int getWifi () {
		 return wifi;
	 }
	 public void setBreakfast(int breakfast) {
		 this.breakfast=breakfast;
	 }
	 public int getBreakfast () {
		 return breakfast;
	 }
	 public void setParking(int parking) {
		 this.parking=parking;
	 }
	 public int getParking () {
		 return parking;
	 }
	 public void setGuests(int guests) {
		 this.guests=guests;
	 }
	 public int getGuests () {
		 return guests;
	 }
	 public void setCheckIn(String checkIn) {
		 this.checkIn=checkIn;
	 }
	 public String getCheckIn () {
		 return checkIn;
	 }
	 public void setCheckOut(String checkOut) {
		 this.checkOut=checkOut;
	 }
	 public String getCheckOut () {
		 return checkOut;
	 }
	 public void setNumberNights(int numberNights) {
		 this.numberNights=numberNights;
	 }
	 public int getNumberNights() {
		 return numberNights;
	 }
	 public double getCost(int guests, int numberNights, int wifi, int breakfast, int parking) {
		 double price;
		 //set price per night based on number of guests
		 if (guests < 3) {
			 price = 115;
		 }else {
			 price = 150;
		 }
		 //breakfast is charged per night
		 if (breakfast == 1) {
			 price = price + 8.99;
		 }
		 //parking is charged per night
		 if (parking == 1) {
			 price = price + 19.99;
		 }	
		 //total price including parking and breakfast per night times number of nights
		 cost = price * numberNights;
		 //wifi is charged per stay, so is added to cost rather than price
		 if (wifi == 1) {
			 cost = cost + 19.99;
		 }
		 return cost;	 
	 }
	@Override 
	public String toString(){
		//TODO add string that correlates booleans to the prices, room size int to actual bed size
		return "Some String";
	}
}