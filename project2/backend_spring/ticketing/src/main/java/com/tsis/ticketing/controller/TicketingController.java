package com.tsis.ticketing.controller;

import com.tsis.ticketing.domain.Ticketing;
import com.tsis.ticketing.service.TicketingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RequestMapping("/ticketing")
public class TicketingController {
    @Autowired
    TicketingService ticketingService;

    @GetMapping
    public ResponseEntity<List<Ticketing>> getAllTicketings() {
        return new ResponseEntity<>(ticketingService.getAllTicketings(), HttpStatus.OK);
    }

    @PostMapping("/reserve")
    public ResponseEntity<String> createTicketing(@RequestBody Ticketing ticketing) {
        System.out.println(ticketing.toString());
        if (ticketingService.createTicketing(ticketing))
            return new ResponseEntity<>("예매 완료", HttpStatus.OK);
        return new ResponseEntity<>("예매 실패", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/check/{PhoneNumber}")
    public ResponseEntity<?> getInfo(@PathVariable("PhoneNumber") String Phonenumber) {
        return new ResponseEntity<>(ticketingService.getInfo(Phonenumber), HttpStatus.OK);
    }

    @GetMapping("/get/{MovieID}")
    public ResponseEntity<List<String>> getSeats(@PathVariable("MovieID") int MovieID) {
        return new ResponseEntity<>(ticketingService.getSeats(MovieID), HttpStatus.OK);
    }
}
