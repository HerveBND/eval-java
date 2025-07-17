package org.example.evalbonnabaud.dao;

import org.example.evalbonnabaud.model.Priorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrioriteDao extends JpaRepository<Priorite, Integer> {
}
