package org.example.evalbonnabaud.model;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.evalbonnabaud.view.TicketView;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Categorie {

    public interface add {
    }

    public interface update {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Column(nullable = false, unique = true)
    @NotBlank(groups = {Categorie.add.class, Categorie.update.class})
    @JsonView(TicketView.class)
    protected String nom;

}
