package cl.idesoft.ejemplo.service;

import cl.idesoft.ejemplo.dto.Persona;
import cl.idesoft.ejemplo.model.PersonaModel;

public interface IPersonaService {

    PersonaModel insertarPersona(Persona persona);

    Persona obtenerPersona(Integer id);

    void eliminarPersona(Integer id);

    void actualizarPersona(Persona persona);

}
