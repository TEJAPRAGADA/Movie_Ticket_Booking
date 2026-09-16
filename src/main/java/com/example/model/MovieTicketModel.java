package com.example.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieTicketModel {

	private int ticketId;

	@NotBlank(message = "Movie name is required")
	private String movieName;

	@NotBlank(message = "Customer name cannot be empty")
	private String customerName;

	private String seatNumber;

	@Positive(message = "Ticket price must be positive")
	private Double ticketPrice;

}
