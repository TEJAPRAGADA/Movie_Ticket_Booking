package com.example.exception;

public class TicketNotFoundException extends RuntimeException {

	public TicketNotFoundException(int ticketId) {
		super("Ticket not found with id: " + ticketId);
	}
}
