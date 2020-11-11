package cl.idesoft.ejemplo.service;

import cl.idesoft.ejemplo.dto.Persona;
import cl.idesoft.ejemplo.entity.PersonaEntity;
import cl.idesoft.ejemplo.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private PersonaRepository repository;

    @Override
    public void insertarPersona(Persona persona) {
        PersonaEntity entity = new PersonaEntity();
        entity.setId(persona.getId());
        entity.setNombre(persona.getNombre());
        entity.setApellido(persona.getApellido());
        entity.setEdad(persona.getEdad());
        repository.save(entity);
    }

    @Override
    public Persona obtenerPersona(Integer id) {
        PersonaEntity entity = repository.findById(id).get();
        Persona persona = new Persona();
        persona.setId(entity.getId());
        persona.setNombre(entity.getNombre());
        persona.setApellido(entity.getApellido());
        persona.setEdad(entity.getEdad());
        return persona;
    }

    @Override
    public void eliminarPersona(Integer id) {
        PersonaEntity entity = repository.findById(id).get();
        repository.delete(entity);
    }

    @Override
    public void actualizarPersona(Persona persona) {
        PersonaEntity entity = repository.findById(persona.getId()).get();
        entity.setNombre(persona.getNombre());
        entity.setApellido(persona.getApellido());
        entity.setEdad(persona.getEdad());
        repository.save(entity);
    }
}
