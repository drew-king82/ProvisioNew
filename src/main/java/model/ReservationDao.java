package model;

import java.util.List;

import beans.Reservation;

public interface ReservationDao{
	//create reservation
	void create(Reservation reservation);
	List<Reservation> findReservations(int customerId);
	int getPoints(int customerId);
	}