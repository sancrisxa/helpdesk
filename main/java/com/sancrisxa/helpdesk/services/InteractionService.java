package com.sancrisxa.helpdesk.services;

import com.sancrisxa.helpdesk.models.Interaction;

public interface InteractionService {
    public Interaction create(Interaction interaction, Long ticketId);
    public Boolean delete(Long id, Long ticketId);
}
