package org.example.evalbonnabaud;

import org.example.evalbonnabaud.controller.TicketController;
import org.example.evalbonnabaud.mock.TicketDaoMock;
import org.example.evalbonnabaud.model.Ticket;
import org.example.evalbonnabaud.security.AppUserDetails;
import org.example.evalbonnabaud.model.Utilisateur;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TicketControllerUnitTest {

    @Test
    void resolveExistingTicket_shouldReturn200() {
        // Arrange
        TicketController ticketController = new TicketController(new TicketDaoMock());
        Utilisateur admin = new Utilisateur();
        admin.setAdmin(true);
        AppUserDetails userDetails = new AppUserDetails(admin);
        Ticket ticketEnvoye = new Ticket();
        ticketEnvoye.setId(1);

        // Act
        ResponseEntity<?> response = ticketController.resolve(1, ticketEnvoye, userDetails);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void resolveNonExistingTicket_shouldReturn404() {
        // Arrange
        TicketController ticketController = new TicketController(new TicketDaoMock());
        Utilisateur admin = new Utilisateur();
        admin.setAdmin(true);
        AppUserDetails userDetails = new AppUserDetails(admin);
        Ticket ticketEnvoye = new Ticket();
        ticketEnvoye.setId(999);

        // Act
        ResponseEntity<?> response = ticketController.resolve(999, ticketEnvoye, userDetails);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
