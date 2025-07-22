package org.example.evalbonnabaud.model;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.evalbonnabaud.view.TicketView;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Ticket {

    public interface add {
    }

    public interface update {
    }

    public Ticket(String titre, String description, Categorie categorie,
                  Priorite priorite) {
        this.titre = titre;
        this.description = description;
        this.categories = categories;
        this.priorite = priorite;
        this.soumissionneur = soumissionneur;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Column(nullable = false, unique = true)
    @NotBlank(groups = {Ticket.add.class, Ticket.update.class})
    protected String titre;

    @Column(nullable = false)
    @NotBlank(groups = {Ticket.add.class,  Ticket.update.class})
    protected String description;


    @Column(nullable = false)
    protected boolean resolu = false;

    @ManyToMany
    @JsonView(TicketView.class)
    @JoinTable(
            name = "ticket_categories",
            joinColumns = @JoinColumn(name = "ticket_id"),
            inverseJoinColumns = @JoinColumn(name = "categorie_id"))
    protected List<Categorie> categories = new ArrayList<>();

    @ManyToOne(optional = false)
    @JsonView(TicketView.class)
    protected Priorite priorite;

    @ManyToOne
    @JsonView(TicketView.class)
    protected Utilisateur resolveur;

    @ManyToOne
    @JsonView(TicketView.class)
    protected Utilisateur soumissionneur;
}
