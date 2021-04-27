package com.tsis.ticketing.service;

import com.tsis.ticketing.domain.Ticketing;
import com.tsis.ticketing.repository.TicketingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TicketingServiceImpl implements TicketingService {
    @Autowired
    private TicketingRepository ticketingRepository;

    @Override
    public List<Ticketing> getAllTicketings() {
        return ticketingRepository.readAllTicketing();
    }

    @Override
    public boolean createTicketing(Ticketing ticketing) {
        return ticketingRepository.createTicketing(ticketing) > 0;
    }

    @Override
    public List<Map<String, Object>> getInfo(String PhoneNumber) {
        return ticketingRepository.checkInfo(PhoneNumber);
    }

    @Override
    public List<String> getSeats(int MovieID) {
        return ticketingRepository.getSeats(MovieID);
    }
}
