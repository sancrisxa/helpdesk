package com.sancrisxa.helpdesk.repositories;

import com.sancrisxa.helpdesk.models.Ticket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketRepository extends PagingAndSortingRepository<Ticket, Long> {
    @Query(value = "select ticket.* from tickets as ticket where ticket.created >= date(now()) - interval (:day) day", nativeQuery = true)
    public List<Ticket> findAllTicketsByDay(@Param("day") Integer day);
}
