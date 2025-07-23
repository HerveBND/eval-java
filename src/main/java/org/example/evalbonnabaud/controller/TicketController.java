package org.example.evalbonnabaud.controller;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.Valid;
import org.example.evalbonnabaud.dao.TicketDao;
import org.example.evalbonnabaud.model.Ticket;
import org.example.evalbonnabaud.security.AppUserDetails;
import org.example.evalbonnabaud.security.IsAdministrateur;
import org.example.evalbonnabaud.view.TicketView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    protected TicketDao ticketDao;

    @Autowired
    public TicketController(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    @GetMapping("/liste")
    @JsonView(TicketView.class)
    public List<Ticket> getAll() {
        return ticketDao.findAll();
    }

    @GetMapping("/{id}")
    @JsonView(TicketView.class)
    public ResponseEntity<Ticket> get(@PathVariable int id) {

        Optional<Ticket> ticketOptional = ticketDao.findById(id);
        return ticketOptional.map(ticket -> new ResponseEntity<>(ticket, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping
    @JsonView(TicketView.class)
    public ResponseEntity<Ticket> add(
            @RequestBody @Valid Ticket ticketEnvoye) {

        ticketDao.save(ticketEnvoye);

        return new ResponseEntity<>(ticketEnvoye, HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    @JsonView(TicketView.class)
    @IsAdministrateur
    public ResponseEntity<?> resolve(
            @PathVariable int id,
            @RequestBody @Valid Ticket ticketEnvoye,
            @AuthenticationPrincipal AppUserDetails userDetails) {

        ticketEnvoye.setId(id);

        if(!userDetails.getUtilisateur().isAdmin()) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        Optional<Ticket> ticketOptional = ticketDao.findById(id);

        if(ticketOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Ticket ticket = ticketOptional.get();

        if(ticket.isResolu()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        ticketEnvoye.setResolu(true);
        ticketEnvoye.setResolveur(userDetails.getUtilisateur());

        ticketDao.save(ticketEnvoye);

        return new ResponseEntity<>(ticketEnvoye, HttpStatus.OK);

    }

    @GetMapping("/non-resolus")
    @JsonView(TicketView.class)
    public List<Ticket> getNonResolus() {
        return ticketDao.findByResoluFalse();
    }
}