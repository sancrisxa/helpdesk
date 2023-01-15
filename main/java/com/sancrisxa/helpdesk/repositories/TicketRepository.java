package com.sancrisxa.helpdesk.repositories;

import com.sancrisxa.helpdesk.models.Ticket;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TicketRepository extends PagingAndSortingRepository<Ticket, Long> {
}
