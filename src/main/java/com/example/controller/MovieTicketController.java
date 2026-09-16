package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.MovieTicketModel;
import com.example.service.MovieTicketService;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/tickets")
public class MovieTicketController {

	@Autowired
	MovieTicketService mts;

	// POST -> Book ticket
	@PostMapping("/booking")
	public MovieTicketModel bookTicket(@Valid @RequestBody MovieTicketModel ticket) {
		return mts.bookTicket(ticket);
	}

	// GET -> Get all tickets
	@GetMapping("/getalldetails")
	public List<MovieTicketModel> getAllTickets() {
		return mts.getAllTickets();
	}

	// GET by ID
	@GetMapping("/getbyid/{id}")
	public MovieTicketModel getTicketById(@PathVariable("id") int ticketId) {
		return mts.getTicketById(ticketId);
	}

	// PUT -> Update ticket (full update)
	@PutMapping("/update/{id}")
	public MovieTicketModel updateTicket(@PathVariable("id") int ticketId, @Valid @RequestBody MovieTicketModel ticket) {
		return mts.updateTicket(ticketId, ticket);
	}

	// PATCH -> Partial update
	@PatchMapping("/partialupdate/{id}")
	public MovieTicketModel partialUpdateTicket(@PathVariable("id") int ticketId,
			@RequestBody MovieTicketModel partialTicket) {
		return mts.partialUpdateTicket(ticketId, partialTicket);
	}

	// DELETE -> Cancel ticket
	@DeleteMapping("/cancelbyid/{id}")
	public MovieTicketModel cancelTicket(@PathVariable("id") int ticketId) {
		return mts.cancelTicket(ticketId);
	}
}
