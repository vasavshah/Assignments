package com.assignment.ticket.reservation.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.assignment.ticket.reservation.bean.SeatHold;
import com.assignment.ticket.reservation.dao.SeatsDAO;

@Service
public class TicketServiceImpl implements TicketService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TicketServiceImpl.class);

	private static final String PROBLEM_RETRIVING_NUMBER_OF_AVAILABLE_SEATS = "Problem while retrieving Number Of Available Seats";

	@Autowired
	private SeatsDAO seatsDAO;

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public int numSeatsAvailable(Integer seatLevel) {
		try {
			int totalNoOfSeats = seatsDAO.getTotalNumberOfSeatsByLevel(seatLevel);
			int totalNoOfReservedSeats = seatsDAO.getNumberOfReservedSeatsByLevel(seatLevel);
			return totalNoOfSeats - totalNoOfReservedSeats;
		} catch (Exception e) {
			LOGGER.error(PROBLEM_RETRIVING_NUMBER_OF_AVAILABLE_SEATS, e);
			throw e;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public SeatHold findAndHoldSeats(int numSeats, Integer minLevel, Integer maxLevel, String customerEmail) {
		return null;
	}

	public String reserveSeats(int seatHoldId, String customerEmail) {
		// TODO Auto-generated method stub
		return null;
	}

}