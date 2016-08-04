package com.assignment.ticket.reservation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.assignment.ticket.reservation.service.TicketService;

@Controller
public class TicketReservationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TicketReservationController.class);

	@Autowired
	private TicketService ticketService;

	@RequestMapping("/index/{levelId}")
	public String getNumberOfSeats(@PathVariable("levelId") Integer levelId) {
		LOGGER.info("Controller Called");
		ticketService.numSeatsAvailable(levelId);
		return "redirect:/index";
	}

}
