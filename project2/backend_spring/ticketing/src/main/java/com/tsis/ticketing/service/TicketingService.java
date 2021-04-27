package com.tsis.ticketing.service;

import com.tsis.ticketing.domain.Ticketing;

import java.util.List;
import java.util.Map;

public interface TicketingService {
    List<Ticketing> getAllTicketings();

    boolean createTicketing(Ticketing ticketing);

    List<Map<String, Object>> getInfo(String PhoneNumber);

    List<String> getSeats(int MovieID);
}
