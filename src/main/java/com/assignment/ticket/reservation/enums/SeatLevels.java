package com.assignment.ticket.reservation.enums;

public enum SeatLevels {
	ORCHESTRA(1), MAIN(2), BALCONY1(3), BALCONY2(4);

	private final int seatLevel;

	private SeatLevels(int seatLevel) {
		this.seatLevel = seatLevel;
	}

	public int getSeatLevel() {
		return seatLevel;
	}
}
