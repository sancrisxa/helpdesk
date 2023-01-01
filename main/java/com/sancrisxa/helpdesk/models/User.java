package com.sancrisxa.helpdesk.models;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @Email(message = "Please provide a valid email")
    @NotEmpty(message = "Can not be empty")
    private String email;

    @Column
    @NotEmpty(message = "Can not be empty")
    private String name;

    @Column
    @NotEmpty(message = "Can not be empty")
    private String lastName;

    @Column
    @NotEmpty(message = "Can not be empty")
    @Length(min = 5, message = "You need to provide a password that contains at least 5 characters")
    private String password;

    @Column
    private Boolean active = true;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @Column
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userOpen")
    private Set<Ticket> tickets;

    @Column
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "technician")
    private Set<Ticket> ticketsTechnician;

    @Column
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userInteraction")
    private Set<Interaction> interactions;

    public User() {}

    public User (String email, String name, String lastName, String password, Boolean active) {
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.active = active;
    }

    public User (Long id, String email, String name, String lastName, String password, Boolean active) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}