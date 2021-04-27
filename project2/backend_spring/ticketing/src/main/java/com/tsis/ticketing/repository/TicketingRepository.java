package com.tsis.ticketing.repository;

import com.tsis.ticketing.domain.Ticketing;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TicketingRepository {
    List<Ticketing> readAllTicketing();

    int createTicketing(Ticketing ticketing);

    List<Map<String, Object>> checkInfo(String phoneNumber);

    List<String> getSeats(int MovieID);
}
