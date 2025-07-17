package org.example.evalbonnabaud.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Utilisateur {

    public interface add {
    }

    public interface update {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Column(nullable = false, unique = true)
    @NotBlank(groups = {add.class, update.class})
    protected String pseudo;

    @Column(nullable = false)
    @NotBlank(groups = {add.class})
    protected String password;

}
