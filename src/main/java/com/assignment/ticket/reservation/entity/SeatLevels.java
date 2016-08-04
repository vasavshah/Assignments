package com.assignment.ticket.reservation.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "SeatLevels")
@Table(name="SEAT_LEVELS")
public class SeatLevels {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "LEVEL_ID")
	private int levelId;

	@Column(name = "LEVEL_NAME")
	private String levelName;

	@Column(name = "NUM_OF_ROWS")
	private int numberOfRows;

	@Column(name = "NUM_OF_SEATS_IN_ROW")
	private int numberOfSeatsInRow;

	public Collection<Seat> getSeats() {
		return seats;
	}

	public void setSeats(Collection<Seat> seats) {
		this.seats = seats;
	}

	@OneToMany
	@JoinTable(name = "SEAT_REL_LEVEL", joinColumns = @JoinColumn(name = "LEVEL_ID") , inverseJoinColumns = @JoinColumn(name = "SEAT_ID") )
	private Collection<Seat> seats;

	public SeatLevels() {
	}

	public SeatLevels(int levelId, String levelName, int numberOfRows, int numberOfSeatsInRow) {
		setLevelId(levelId);
		setLevelName(levelName);
		setNumberOfRows(numberOfRows);
		setNumberOfSeatsInRow(numberOfSeatsInRow);
	}

	public int getLevelId() {
		return levelId;
	}

	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public int getNumberOfRows() {
		return numberOfRows;
	}

	public void setNumberOfRows(int numberOfRows) {
		this.numberOfRows = numberOfRows;
	}

	public int getNumberOfSeatsInRow() {
		return numberOfSeatsInRow;
	}

	public void setNumberOfSeatsInRow(int numberOfSeatsInRow) {
		this.numberOfSeatsInRow = numberOfSeatsInRow;
	}

}
