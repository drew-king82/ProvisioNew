package model;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Reservation;

public class JdbcReservationDao implements ReservationDao{
	JdbcManager db;	
	public JdbcReservationDao(){		
	db = new JdbcManager();
	}
	
	@Override
	public void create(Reservation reservation){
		//connect to the database
		Connection con=db.getConn();
		//Create new customer object
		Reservation newReservation=reservation;
		if (con!=null) {
			try {
			  Statement S1=con.createStatement();	
			  String addQuery=
			"insert into reservation(customerId, roomSize, wifi, breakfast, parking, guests, checkIn, checkOut, numberNights)values"
			+ "('"+newReservation.getCustomerId()+
			"', '" + newReservation.getRoomSize()+
			"','" + newReservation.getWifi()+
			"','" + newReservation.getBreakfast()+
			"','" + newReservation.getGuests()+
			"','" + newReservation.getParking()+
			"','" + newReservation.getCheckIn()+
			"','" + newReservation.getCheckOut()+
			"','" + newReservation.getNumberNights() +"')";
	
			try {
				S1.executeUpdate(addQuery);
			}
			finally {
				S1.close();
			}
			}
			catch(Exception e) {
				System.out.println(e);
			}
				
			}
	}
	@Override
	public List<Reservation> findReservations(int customerId) {
		ArrayList<Reservation> reservations = new ArrayList<Reservation>();
	
		//connect to the database
		Connection con=db.getConn();
		//Create new customer object
		if (con!=null) {
			try {
				Statement S1=con.createStatement();	
				String findQuery="select from reservation where customerId =" + customerId;
				try {
					ResultSet result = S1.executeQuery(findQuery);
					try {
						while(result.next()) {
							Reservation newReservation=new Reservation(result.getInt(1), result.getInt(2), result.getBoolean(3), result.getBoolean(4),result.getBoolean(5), result.getInt(6), result.getString(7), result.getString(8), result.getInt(9));
							reservations.add(newReservation);
						}
					}catch (Exception e){
						System.out.println(e);	
					}
				} catch(Exception e) {
					System.out.println(e);
				} finally {
					S1.close();
					db.closeConn(con);
				}
				
				}catch (Exception e) {
					System.out.println(e);
				}
			}
		return reservations;
		}
	@Override
	public int getPoints(int customerId) {
		Connection con=db.getConn();
		int points;
		int nights=0;
		if(con!=null) {
			try {
				Statement S1=con.createStatement();
				String pointsQuery=
					"SELECT numberNights FROM reservations where customerId=" + customerId;
				try {
					ResultSet result=S1.executeQuery(pointsQuery);
					try {
						while (result.next()) {
							nights= nights + result.getInt(1);
						}
					} finally { 
						result.close();
					}
					
				} finally {
					S1.close();
				} 
			} catch (Exception e) {
				System.out.println(e);
			} 
		}
		points = nights * 150;
		return points;
	}
}
			
	
	