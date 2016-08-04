package com.assignment.ticket.reservation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "Seat")
@Table(name = "SEATS")
public class Seat {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SEAT_ID")
	private int seatid;

	@Column(name = "SEAT_ROW")
	private char seatRow;

	@Column(name = "SEAT_NUMBER")
	private int seatNumber;

	@ManyToOne
	@JoinTable(name = "SEAT_REL_LEVEL", joinColumns = @JoinColumn(name = "SEAT_ID") , inverseJoinColumns = @JoinColumn(name = "LEVEL_ID") )
	private SeatLevels seatLevel;

	@OneToOne(mappedBy = "seat")
	@JoinTable(name = "CUSTOMER_RESERVATIONS")
	private SeatReservation seatReservation;

	public SeatLevels getSeatLevel() {
		return seatLevel;
	}

	public void setSeatLevel(SeatLevels seatLevel) {
		this.seatLevel = seatLevel;
	}

	public Seat() {
	}

	public Seat(int seatid, char seatRow, int seatNumber, int levelId) {
		setSeatid(seatid);
		setSeatRow(seatRow);
		setSeatNumber(seatNumber);
	}

	public int getSeatid() {
		return seatid;
	}

	public void setSeatid(int seatid) {
		this.seatid = seatid;
	}

	public char getSeatRow() {
		return seatRow;
	}

	public void setSeatRow(char seatRow) {
		this.seatRow = seatRow;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

}
