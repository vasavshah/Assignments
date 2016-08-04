package com.assignment.ticket.reservation.dao;

public interface SeatsDAO {
	/**
	 * This method returns total number of available seats in a given Level
	 * 
	 * @param level
	 *            - Level of Seat
	 * @return - returns Total Number Seats in a Level if valid level is
	 * 
	 */
	int getTotalNumberOfSeatsByLevel(Integer seatLevel);

	/**
	 * This method returns total number of seats which are either Reserved Or
	 * Hold in a given Level.
	 * 
	 * @param seatLevel
	 * @return Total No. Of Reserved and Hold Seats
	 */
	int getNumberOfReservedSeatsByLevel(Integer seatLevel);

	/**
	 * This method holds the specified seats for customer between provided seat
	 * levels
	 * 
	 * @param numSeats - Number Of Seats To be Hold
	 * @param minSeatLevel - min Seat Level
	 * @param maxSeatLevel - max Seat Level
	 * @param customerEmail - Customer Email
	 * @return - returns the seat in
	 */
	int findAndHoldSeatsBetweenLevels(int numSeats, int minSeatLevel, int maxSeatLevel, String customerEmail);
}
