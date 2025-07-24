package org.example.evalbonnabaud.mock;

import org.example.evalbonnabaud.dao.TicketDao;
import org.example.evalbonnabaud.model.Priorite;
import org.example.evalbonnabaud.model.Ticket;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class TicketDaoMock implements TicketDao {

    @Override
    public List<Ticket> findByResoluFalse() {
        Ticket ticket = new Ticket();
        ticket.setId(1);
        ticket.setTitre("CICD");
        ticket.setDescription("Improve CICD Workflow");
        ticket.setResolu(false);

        Priorite priorite = new Priorite();
        priorite.setId(1);
        priorite.setNom("IMMEDIAT");
        ticket.setPriorite(priorite);

        return List.of(ticket);
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Ticket> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Ticket> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Ticket> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Ticket getOne(Integer integer) {
        return null;
    }

    @Override
    public Ticket getById(Integer integer) {
        return null;
    }

    @Override
    public Ticket getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Ticket> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Ticket> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Ticket> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Ticket> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Ticket> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Ticket> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Ticket, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Ticket> S save(S entity) {
        return entity;
    }

    @Override
    public <S extends Ticket> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Ticket> findById(Integer integer) {
        if (integer.equals(1)) {
            Ticket ticket = new Ticket();
            ticket.setId(1);
            ticket.setTitre("CICD");
            ticket.setDescription("Improve CICD Workflow");
            ticket.setResolu(false);

            // Créer et configurer la priorité
            Priorite priorite = new Priorite();
            priorite.setId(1);
            priorite.setNom("IMMEDIAT");
            ticket.setPriorite(priorite);

            return Optional.of(ticket);
        }
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Ticket> findAll() {
        return List.of();
    }

    @Override
    public List<Ticket> findAllById(Iterable<Integer> integers) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Ticket entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Ticket> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Ticket> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Ticket> findAll(Pageable pageable) {
        return null;
    }
}
