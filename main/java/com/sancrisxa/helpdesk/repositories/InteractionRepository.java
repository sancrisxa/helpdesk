package com.sancrisxa.helpdesk.repositories;

import com.sancrisxa.helpdesk.models.Interaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InteractionRepository extends JpaRepository<Interaction, Long> {
}
