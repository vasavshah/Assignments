package com.assignment.ticket.reservation.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
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

@Entity(name = "SEAT_RESERVATION")
@Table(name = "No")
public class SeatReservation {

	@Column(name = "RESERVATION_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long reservationId;

	@Column(name = "RESERVATION_TIME")
	private Timestamp reservationTime;

	@Column(name = "HOLD_IND")
	private boolean holdIndicator;

	@ManyToOne
	@JoinTable(name = "CUSTOMER_RESERVATIONS", joinColumns = @JoinColumn(name = "RESERVATION_ID") , inverseJoinColumns = @JoinColumn(name = "CUSTOMER_EMAIL") )
	private Customer customer;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "CUSTOMER_RESERVATIONS", joinColumns = @JoinColumn(name = "SEAT_ID") )
	private Seat seat;

	public SeatReservation() {
	}

	public SeatReservation(long reservationId, Timestamp reservationTime, boolean holdIndicator) {
		setReservationId(reservationId);
		setReservationTime(reservationTime);
		setHoldIndicator(holdIndicator);
	}

	public long getReservationId() {
		return reservationId;
	}

	public void setReservationId(long reservationId) {
		this.reservationId = reservationId;
	}

	public Timestamp getReservationTime() {
		return reservationTime;
	}

	public void setReservationTime(Timestamp reservationTime) {
		this.reservationTime = reservationTime;
	}

	public boolean isHoldIndicator() {
		return holdIndicator;
	}

	public void setHoldIndicator(boolean holdIndicator) {
		this.holdIndicator = holdIndicator;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}
}
