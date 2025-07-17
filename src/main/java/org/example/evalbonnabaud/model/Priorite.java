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
public class Priorite {

    public interface add {
    }

    public interface update {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Column(nullable = false, unique = true)
    @NotBlank(groups = {Priorite.add.class, Priorite.update.class})
    protected String nom;

}
