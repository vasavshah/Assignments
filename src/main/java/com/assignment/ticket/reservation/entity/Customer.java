package com.assignment.ticket.reservation.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity(name = "CUSTOMER")
public class Customer {

	@Id
	@Column(name = "CUSTOMER_EMAIL")
	private String customerEmail;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@OneToMany
	@JoinTable(name = "CUSTOMER_RESERVATIONS", joinColumns = @JoinColumn(name = "CUSTOMER_EMAIL") , inverseJoinColumns = @JoinColumn(name = "RESERVATION_ID") )
	private Set<SeatReservation> reservations;

	public Customer() {
	}

	public Customer(String customerEmail, String firstName, String lastName) {
		setCustomerEmail(customerEmail);
		setFirstName(firstName);
		setLastName(lastName);
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<SeatReservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<SeatReservation> reservations) {
		this.reservations = reservations;
	}
}
