package com.assignment.ticket.reservation.dao;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SeatsDAOImpl implements SeatsDAO {

	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(SeatsDAOImpl.class);

	private static final String GET_TOTAL_NUMBER_OF_SEATS_BY_LEVEL = "SELECT COUNT(*) FROM SEATS as s JOIN SEAT_REL_LEVEL srl ON s.seat_id=srl.seat_id JOIN SEAT_LEVELS sl ON sl.level_id=srl.level_id WHERE sl.level_id = ? GROUP BY (sl.level_id,sl.level_name)";

	private static final String GET_TOTAL_NUMBER_OF_RESERVED_BY_LEVEL = "SELECT COUNT(*) FROM SEAT_RESERVATION as sr JOIN CUSTOMER_RESERVATIONS cr ON sr.reservation_id=cr.reservation_id JOIN CUSTOMER cust ON cust.customer_email=cr.customer_email JOIN SEAT_REL_LEVEL srl ON cr.seat_id = srl.seat_id JOIN SEAT_LEVELS sl ON sl.level_id = srl.level_id WHERE srl.level_id = ? GROUP BY (srl.level_id)";

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.assignment.ticket.reservation.dao.SeatsDAO#
	 * getTotalNumberOfSeatsByLevel(java.lang.Integer)
	 */
	@Override
	public int getTotalNumberOfSeatsByLevel(Integer seatLevel) {
		Session session = sessionFactory.openSession();
		SQLQuery sqlQuery = session.createSQLQuery(GET_TOTAL_NUMBER_OF_SEATS_BY_LEVEL);
		sqlQuery.setParameter(0, seatLevel.intValue());
		Integer noOfSeats = ((Number) sqlQuery.list().get(0)).intValue();
		session.close();
		return noOfSeats;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.assignment.ticket.reservation.dao.SeatsDAO#
	 * getNumberOfReservedSeatsByLevel(java.lang.Integer)
	 */
	@Override
	public int getNumberOfReservedSeatsByLevel(Integer seatLevel) {
		Session session = sessionFactory.openSession();
		SQLQuery sqlQuery = session.createSQLQuery(GET_TOTAL_NUMBER_OF_RESERVED_BY_LEVEL);
		sqlQuery.setParameter(0, seatLevel.intValue());
		Integer noOfSeats = ((Number) sqlQuery.list().get(0)).intValue();
		session.close();
		return noOfSeats;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.assignment.ticket.reservation.dao.SeatsDAO#
	 * findAndHoldSeatsBetweenLevels(int, int, int, java.lang.String)
	 */
	@Override
	public int findAndHoldSeatsBetweenLevels(int numSeats, int minSeatLevel, int maxSeatLevel, String customerEmail) {
		return 0;
	}

}
