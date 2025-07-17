package org.example.evalbonnabaud.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ticket {

    public interface add {
    }

    public interface update {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Column(nullable = false, unique = true)
    @NotBlank(groups = {Ticket.add.class, Ticket.update.class})
    protected String titre;

    @Column(nullable = false)
    @NotBlank(groups = {Ticket.add.class,  Ticket.update.class})
    protected String decription;


    @Column(nullable = false)
    @NotBlank(groups = {Utilisateur.add.class})
    protected boolean resolu;

}
