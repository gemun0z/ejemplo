package cl.idesoft.ejemplo.service;

import cl.idesoft.ejemplo.assembler.PersonaModelAssembler;
import cl.idesoft.ejemplo.dto.Persona;
import cl.idesoft.ejemplo.entity.PersonaEntity;
import cl.idesoft.ejemplo.model.PersonaModel;
import cl.idesoft.ejemplo.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private PersonaRepository repository;

    @Autowired
    private PersonaModelAssembler assembler;

    @Override
    public PersonaModel insertarPersona(Persona persona) {
        PersonaEntity entity = new PersonaEntity();
        entity.setId(persona.getId());
        entity.setNombre(persona.getNombre());
        entity.setApellidoPaterno(persona.getApellidoPaterno());
        entity.setApellidoMaterno(persona.getApellidoMaterno());
        entity.setEdad(persona.getEdad());
        return assembler.toModel(repository.save(entity));
    }

    @Override
    public Persona obtenerPersona(Integer id) {
        PersonaEntity entity = repository.findById(id).get();
        Persona persona = new Persona();
        persona.setId(entity.getId());
        persona.setNombre(entity.getNombre());
        persona.setApellidoPaterno(entity.getApellidoPaterno());
        persona.setApellidoMaterno(entity.getApellidoMaterno());
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
        entity.setApellidoPaterno(persona.getApellidoPaterno());
        entity.setApellidoMaterno(persona.getApellidoMaterno());
        entity.setEdad(persona.getEdad());
        repository.save(entity);
    }
}
