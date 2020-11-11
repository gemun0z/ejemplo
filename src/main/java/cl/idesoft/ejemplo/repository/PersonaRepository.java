package cl.idesoft.ejemplo.repository;

import cl.idesoft.ejemplo.entity.PersonaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends CrudRepository<PersonaEntity, Integer> {
}
