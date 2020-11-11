package cl.idesoft.ejemplo.service;

import cl.idesoft.ejemplo.dto.Persona;

public interface IPersonaService {

    void insertarPersona(Persona persona);

    Persona obtenerPersona(Integer id);

    void eliminarPersona(Integer id);

    void actualizarPersona(Persona persona);

}
