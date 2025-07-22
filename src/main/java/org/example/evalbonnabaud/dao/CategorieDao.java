package org.example.evalbonnabaud.dao;

import org.example.evalbonnabaud.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieDao extends JpaRepository<Categorie, Integer> {
}
