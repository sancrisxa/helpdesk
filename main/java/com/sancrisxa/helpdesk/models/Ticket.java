package com.sancrisxa.helpdesk.models;

import java.util.Date;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table( name = "tickets" )
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotEmpty(message = "Can not be empty")
    private String name;

    @Column
    @NotEmpty(message = "Can not be empty")
    private String description;

    @Column
    private Date created;

    @Column
    private Date closed;

    @Column
    private Boolean finished = false;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User userOpen;

    @ManyToOne
    @JoinColumn(name = "technician_id")
    @JsonBackReference
    private User technician;

    @Column
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ticket")
    private List<Interaction> interactions;

    @PrePersist
    public void prePersist() {
        this.setCreated(new Date());
    }

    public Ticket() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getClosed() {
        return closed;
    }

    public void setClosed(Date closed) {
        this.closed = closed;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public User getUserOpen() {
        return userOpen;
    }

    public void setUserOpen(User userOpen) {
        this.userOpen = userOpen;
    }

    public User getTechnician() {
        return technician;
    }

    public void setTechnician(User technician) {
        this.technician = technician;
    }

    public List<Interaction> getInteractions() {
        return interactions;
    }

    public void setInteractions(List<Interaction> interactions) {
        this.interactions = interactions;
    }
}