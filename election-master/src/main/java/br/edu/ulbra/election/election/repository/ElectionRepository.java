package br.edu.ulbra.election.election.repository;

import br.edu.ulbra.election.election.model.Election;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ElectionRepository extends CrudRepository<Election, Long> {
    Optional<Election> findByYear(Integer year);
}
