package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.exception.TicketNotFoundException;
import com.example.model.MovieTicketModel;

@Service
public class MovieTicketService {

	List<MovieTicketModel> ticketList = new ArrayList<>(
			List.of(
					new MovieTicketModel(1, "Avengers", "Teja", "A1", 250.0),
					new MovieTicketModel(2, "Inception", "Pavan", "B4", 300.0)));

	private int idCounter = 3;

	public MovieTicketModel bookTicket(MovieTicketModel ticket) {

		ticket.setTicketId(idCounter++);
		ticketList.add(ticket);

		System.out.println("Ticket booked successfully: " + ticket);

		return ticket;
	}

	public List<MovieTicketModel> getAllTickets() {

		System.out.println("Fetching all tickets");

		return ticketList;
	}

	public MovieTicketModel getTicketById(int ticketId) {

		for (MovieTicketModel t : ticketList) {
			if (t.getTicketId() == ticketId) {
				System.out.println("Ticket found for id " + ticketId + ": " + t);
				return t;
			}
		}

		System.out.println("Ticket not found for id " + ticketId);

		throw new TicketNotFoundException(ticketId);
	}

	public MovieTicketModel updateTicket(int ticketId, MovieTicketModel updatedTicket) {

		MovieTicketModel ticket = getTicketById(ticketId);
		ticket.setMovieName(updatedTicket.getMovieName());
		ticket.setCustomerName(updatedTicket.getCustomerName());
		ticket.setSeatNumber(updatedTicket.getSeatNumber());
		ticket.setTicketPrice(updatedTicket.getTicketPrice());

		System.out.println("Ticket updated successfully for id " + ticketId);

		return ticket;
	}

	public MovieTicketModel partialUpdateTicket(int ticketId, MovieTicketModel partialTicket) {

		MovieTicketModel ticket = getTicketById(ticketId);

		if (partialTicket.getMovieName() != null) {
			ticket.setMovieName(partialTicket.getMovieName());
		}
		if (partialTicket.getCustomerName() != null) {
			ticket.setCustomerName(partialTicket.getCustomerName());
		}
		if (partialTicket.getSeatNumber() != null) {
			ticket.setSeatNumber(partialTicket.getSeatNumber());
		}
		if (partialTicket.getTicketPrice() != null) {
			ticket.setTicketPrice(partialTicket.getTicketPrice());
		}

		System.out.println("Ticket partially updated for id " + ticketId);

		return ticket;
	}

	public MovieTicketModel cancelTicket(int ticketId) {

		MovieTicketModel ticket = getTicketById(ticketId);
		ticketList.remove(ticket);

		System.out.println("Ticket cancelled successfully for id " + ticketId);

		return ticket;
	}
}
